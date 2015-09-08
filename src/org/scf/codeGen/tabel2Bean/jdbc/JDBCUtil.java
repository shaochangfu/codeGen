package org.scf.codeGen.tabel2Bean.jdbc;

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
	private static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=UTF-8";
	static Connection con = null;
	public JDBCUtil jDBCUtil = new JDBCUtil();
	private JDBCUtil(){
		super();
	}
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		try {
			con = DriverManager.getConnection(url , "root" , "pccw" ) ;
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
	 public static Map<String,Map> getTables(Connection conn,String packagePath) throws SQLException {
		 Map<String,Map> result = new HashMap<String,Map>();
		 
	        DatabaseMetaData dbMetData = conn.getMetaData();  
	        // mysql convertDatabaseCharsetType null  
	        ResultSet rs = dbMetData.getTables(null,  
	                convertDatabaseCharsetType("root", "mysql"), null,  
	                new String[] { "TABLE", "VIEW" });  
	  
	        while (rs.next()) {  
	            if (rs.getString(4) != null  
	                    && (rs.getString(4).equalsIgnoreCase("TABLE") || rs  
	                            .getString(4).equalsIgnoreCase("VIEW"))) {  
	                String tableName = rs.getString(3).toLowerCase();  // 得到表名
	                System.out.println(tableName);
	                Map rootMap = new HashMap();
	                List list = new ArrayList();
	                ResultSet colRet = dbMetData.getColumns(null, "%", tableName, "%");
	                while(colRet.next()){
	    				String fieldName = colRet.getString("COLUMN_NAME");
	    				String variableType = colRet.getString("TYPE_NAME").equals("varchar") ? "String" :"int";
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
	                // 根据表名提前表里面信息：  
	               /* ResultSet colRet = dbMetData.getColumns(null, "%", tableName,  
	                        "%");  
	                while (colRet.next()) {  
	                    String columnName = colRet.getString("COLUMN_NAME");  
	                    String columnType = colRet.getString("TYPE_NAME");  
	                    int datasize = colRet.getInt("COLUMN_SIZE");  
	                    int digits = colRet.getInt("DECIMAL_DIGITS");  
	                    int nullable = colRet.getInt("NULLABLE");  
	                     System.out.println(columnName + " " + columnType + " "+  
	                     datasize + " " + digits + " " + nullable);  
	                }  */
	    			result.put(tableName, rootMap);
	            } 
	            
	        }  
	        return result;
	    }  
	 
	 public static void main(String[] args) {
		 con =  getConnection();
		 try {
			getTables(con,"");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 closeCon(con);
	}
	 private static String firstUpper(String str){
			String c = str.substring(0,1);
			String upperC = c.toUpperCase();
			return upperC+str.substring(1);
		}
	
}
