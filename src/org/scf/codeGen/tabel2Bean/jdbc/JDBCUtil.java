package org.scf.codeGen.tabel2Bean.jdbc;

import org.scf.codeGen.tabel2Bean.util.Constant;
import org.scf.codeGen.tabel2Bean.util.ProptertiesUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {

	private Connection con = null;
	private static JDBCUtil jDBCUtil ;
	private JDBCUtil(){
		// 注册数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 创建数据库连接
		createConnection();
	}
	public static JDBCUtil getInstance(){
		if (jDBCUtil == null){
			jDBCUtil = new  JDBCUtil();
		}
		return jDBCUtil;
	}

	/**
	 * 创建数据库连接
	 * @return
     */
	private Connection createConnection(){
		//读取属性配置文件
		ProptertiesUtil pro = ProptertiesUtil.getInstance(Constant.cfgFilePath);
		String url = pro.getValueByKey("url");
		String username = pro.getValueByKey("username");
		String passwd = pro.getValueByKey("passwd");
		try {
			con = DriverManager.getConnection(url , username , passwd) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void closeCon(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String convertDatabaseCharsetType(String in, String type) {  
        String dbUser;  
        if (in != null) {  
            if (type.equals("oracle")) {  
                dbUser = in.toUpperCase();  
            } else if (type.equals("postgresql")) {  
                dbUser = "public";  
            } else if (type.equals("mysql")) {  
                dbUser = null;  
            } else if (type.equals("mssqlserver")) {  
                dbUser = null;  
            } else if (type.equals("db2")) {  
                dbUser = in.toUpperCase();  
            } else {  
                dbUser = in;  
            }  
        } else {  
            dbUser = "public";  
        }  
        return dbUser;  
    }  
	//获取一个数据库的所有表和视图
	 public Map<String,Map> getTables(String packagePath) throws SQLException {
		 Map<String,Map> result = new HashMap<String,Map>();
		 
	        DatabaseMetaData dbMetData = con.getMetaData();
	        // mysql convertDatabaseCharsetType null  
	        ResultSet rs = dbMetData.getTables(null,  
	                convertDatabaseCharsetType("root", "mysql"), null,  
	                new String[] { "TABLE", "VIEW" });  
	  
	        while (rs.next()) {  
	            if (rs.getString(4) != null  
	                    && (rs.getString(4).equalsIgnoreCase("TABLE") || rs  
	                            .getString(4).equalsIgnoreCase("VIEW"))) {  
	                String tableName = rs.getString(3).toLowerCase();  // 得到表名
	                Map rootMap = new HashMap();
	                List list = new ArrayList();
	                ResultSet colRet = dbMetData.getColumns(null, "%", tableName, "%");
	                while(colRet.next()){
	    				String fieldName = colRet.getString("COLUMN_NAME");
	    				String variableType = "String";
	    				String jdbcType = colRet.getString("TYPE_NAME") == null ? "varchar":colRet.getString("TYPE_NAME");
	    				if(jdbcType.equals("varchar")){
	    					variableType = "String";
	    					jdbcType = jdbcType.toUpperCase();
	    				}else if(jdbcType.equals("datetime") || jdbcType.equals("timestamp")){
	    					variableType = "java.util.Date";
	    					jdbcType = "TIMESTAMP";
	    				}else if(jdbcType.equals("int")){
	    					variableType = "Integer";
	    				}
	    				//String variableType = colRet.getString("TYPE_NAME").equals("varchar") ? "String" :"Integer";
	    				Map rootMap1 = new HashMap();
	    				rootMap1.put("fieldName", fieldName);
	    				rootMap1.put("fuFieldName", firstUpper(fieldName));
	    				rootMap1.put("variableType", variableType);
	    				rootMap1.put("jdbcType",jdbcType);
	    				list.add(rootMap1);
	    			}
	    			rootMap.put("metaDataList", list);
	    			rootMap.put("packageName",packagePath);
	    			rootMap.put("beanName", tableName.replace("_", ""));
	    			rootMap.put("beanNameClass", firstUpper(tableName.replace("_", "")));
	    			rootMap.put("tableName", tableName);

	    			result.put(tableName.replace("_", ""), rootMap);
	            } 
	            
	        }  
	        return result;
	    }  
	 
	 private String firstUpper(String str){
			String c = str.substring(0,1);
			String upperC = c.toUpperCase();
			return upperC+str.substring(1);
	}
	
	
	
}
