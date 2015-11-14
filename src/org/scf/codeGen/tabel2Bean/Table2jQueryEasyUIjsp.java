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
 * 根据表生成基于jquery easy UI的jsp 页面
 * @author scf
 *
 */
public class Table2jQueryEasyUIjsp {

	private Configuration cfg = null;
	private final String CODE_FILE_CHARSET = "UTF-8";
	private String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=UTF-8";// 数据库连接
	private String user = "root";
	private String passwd = "123456";
	private static Connection con = null;
	private static String targetPath = "src\\org\\scf\\common\\ipay\\jsp";
	private static String packagePath = "org.scf.common.ipay.bean";
	//private static String tableStr = "studentscf";
	private static String templetePath ="src\\org\\scf\\codeGen\\tabel2Bean\\template";
	
	public static void main(String[] args) throws Exception {
		Table2jQueryEasyUIjsp maker = new Table2jQueryEasyUIjsp();
		maker.init();
		File targetFilepath = new File(targetPath);//+"\\"+tableStr.toLowerCase()
		if(!targetFilepath.exists()){
			targetFilepath.mkdirs();
		}
		String templateFile = "jQueryEasyUIjsp.ftl";// 模板文件
		Map<String,Map> map = JDBCUtil.getTables(con,packagePath);// 获取全部的表
		//Map<String,Map> map = maker.getAllColumn("test");// 获取表test的数据
		if(map != null){
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				Map columnMap = map.get(key);
				File targetFile = new File(targetFilepath.getPath()+"\\"+firstUpper(key)+".jsp");
				if(!targetFile.exists()){
					targetFile.createNewFile();
				}
				maker.process(columnMap, targetFile, templateFile);
			}
//			int len = tableList.size();
//			for(int i = 1; i<len;i++){
//				String tableStr = tableList.get(i);
//				maker.process(maker.getAllColumn(tableStr), targetFile, templateFile);
//			}
		}
	}
	
	public void init() throws Exception {
		cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(templetePath));
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url , user , passwd ) ;
	}
	// 获取指定表的信息
	public Map getAllColumn(String tableName){
		Map rootMap = new HashMap();
		List list = new ArrayList();
		try {
			DatabaseMetaData dmd = con.getMetaData();
			ResultSet rs = dmd.getColumns("","test",tableName, null);
			while(rs.next()){
				String fieldName = rs.getString("COLUMN_NAME");
				String variableType = rs.getString("TYPE_NAME").equals("varchar") ? "String" :"";
				Map rootMap1 = new HashMap();
				rootMap1.put("fieldName", fieldName);
				rootMap1.put("fuFieldName", firstUpper(fieldName));
				rootMap1.put("variableType", variableType);
				list.add(rootMap1);
			}
			rootMap.put("metaDataList", list);
			rootMap.put("packageName",packagePath);
			rootMap.put("beanName", tableName);
			rootMap.put("beanNameClass", firstUpper(tableName));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rootMap;
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
	private static String firstUpper(String str){
		String c = str.substring(0,1);
		String upperC = c.toUpperCase();
		return upperC+str.substring(1);
	}

}
