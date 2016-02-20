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
/**
 * 根据数据库表生成bean，通过修改48 和 50 行的数据进行调配是单个表还是所有表
 * url 是数据库连接地址
 * targetPath 是文件所存放的位置
 * packagePath 包路径
 * templetePath 末班存放位置
 * 56 行标示生成文件的类型
 * 
 * 通过修改48 和 50 行的数据进行调配是单个表还是所有表
 * @author pccw
 *
 */
public class Table2BeanUtil {
	private Configuration cfg = null;
	private final String CODE_FILE_CHARSET = "UTF-8";
	private static String targetPath = "src\\org\\scf\\common\\ipay";
	private static String packagePath = "org.scf.common.ipay.bean";
	private static String templetePath ="src\\org\\scf\\codeGen\\tabel2Bean\\template";
	
	public static void main(String[] args) throws Exception {
		new Table2BeanUtil().excute();
	}
	public void excute() throws Exception {
		Table2BeanUtil maker = new Table2BeanUtil();
		maker.init();
		File targetFilepath = new File(targetPath);
		if(!targetFilepath.exists()){
			targetFilepath.mkdirs();
		}
		String templateFile = "Bean2.ftl";
		Map<String,Map> map = JDBCUtil.getInstance().getTables(packagePath);// 获取全部的表
		if(map != null) {
			Iterator<String> it = map.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				Map columnMap = map.get(key);
				File targetFile = new File(targetFilepath.getPath() + "\\" + firstUpper(key) + "Bean.java");
				if (!targetFile.exists()) {
					targetFile.createNewFile();
				}
				maker.process(columnMap, targetFile, templateFile);
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
			osw = new OutputStreamWriter(new FileOutputStream(targetFile), CODE_FILE_CHARSET);
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
