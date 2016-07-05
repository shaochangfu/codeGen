package org.scf.codeGen.tabel2Bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.scf.codeGen.tabel2Bean.jdbc.JDBCUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.scf.codeGen.tabel2Bean.util.CommonUtil;
import org.scf.codeGen.tabel2Bean.util.Constant;

/**
 * 根据数据库表生成bean，通过修改48 和 50 行的数据进行调配是单个表还是所有表
 * url 是数据库连接地址
 * targetPath 是文件所存放的位置
 * packagePath 包路径
 * templetePath 模板存放位置
 * @author scf
 *
 */
public class Table2BeanUtil implements Runnable{
	private  Configuration cfg = null;
	private  String suffix = ""; // 文件后缀
	private  String targetPath = ""; // 生成的文件保存位置
	private  String packagePath = ""; // 文件的包名
	private  String templetePath =""; // 模板文件路径
	private  String templateFile = ""; // 模板文件名

	public static void main(String[] args) throws Exception {
		new Table2BeanUtil("mybatisMapperftl").excute();
	}

	public Table2BeanUtil(){}
	public Table2BeanUtil(String templateFileCfgt){
		// 初始化模板文件属性配置
		CommonUtil commonUtil = CommonUtil.getInstance();
		String [] templateFileCfg = commonUtil.parseTemplateFileCfg(templateFileCfgt);
		templateFile = templateFileCfg[0];
		templetePath = templateFileCfg[1];
		packagePath = templateFileCfg[2];
		targetPath = templateFileCfg[3];
		suffix = templateFileCfg[4];
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+"正在生成代码。");
			excute();
		}catch (Exception ex){ex.printStackTrace();}
	}
	public void excute() throws Exception {
		init();
		File targetFilepath = new File(targetPath);
		if(!targetFilepath.exists()){
			targetFilepath.mkdirs();
		}

		Map<String,Map> map = JDBCUtil.getInstance().getTables(packagePath);// 获取全部的表
		if(map != null) {
			Iterator<String> it = map.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				final Map columnMap = map.get(key);
				final File targetFile = new File(targetFilepath.getPath() + "\\" + firstUpper(key) + suffix);
				if (!targetFile.exists()) {
					targetFile.createNewFile();
				}
				// 多线程生成文件
				Thread t = new Thread(){
					public void run() {
						process(columnMap, targetFile, templateFile);
					}
				};
				t.start();
			}
		}
	}
	public void init() throws Exception {
		cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(templetePath));
	}
	//
	public void process(Map rootMap,File targetFile,String templateFile) {
		OutputStreamWriter osw = null;
		try {
			osw = new OutputStreamWriter(new FileOutputStream(targetFile), Constant.CODE_FILE_CHARSET);
			Template template = cfg.getTemplate(templateFile);
			template.process(rootMap, osw);
			osw.flush();
			osw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(osw != null){
				try {
					osw.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * 首字母大写
	 * @param str
	 * @return
     */
	private static String firstUpper(String str){
		String c = str.substring(0,1);
		String upperC = c.toUpperCase();
		return upperC+str.substring(1);
	}
}
