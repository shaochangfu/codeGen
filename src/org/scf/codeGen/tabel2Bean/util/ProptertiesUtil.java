package org.scf.codeGen.tabel2Bean.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by scf on 2016/2/20.
 * 操作属性配置文件
 */
public class ProptertiesUtil {

    private static ProptertiesUtil proptertiesUtil;
    Properties props = new Properties();
    private String cfgFilePath_g = "";

    /**
     * 初始化属性配置文件数据
     * @param cfgFilePath
     */
    private ProptertiesUtil(String cfgFilePath){
        cfgFilePath_g = cfgFilePath;
        try{
            InputStream in = new FileInputStream(cfgFilePath);
            props.load(in);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 获取属性配置文件实例
     * @param cfgFilePath
     * @return
     */
    public static ProptertiesUtil getInstance(String cfgFilePath){
        if(proptertiesUtil == null){
            proptertiesUtil = new ProptertiesUtil(cfgFilePath);
        }
        return proptertiesUtil;
    }

    /**
     * 根据key修改value,如果key不存在，则增加对应的key和value值。
     * @param key
     * @param value
     */
    public void setValueByKey(String key,String value){
        try{
            OutputStream out = new FileOutputStream(cfgFilePath_g);
            props.setProperty(key, value);
            props.store(out, "Update " + key + " name");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 根据key获得value值
     * @param key
     * @return
     */
    public String getValueByKey(String key){
        return props.getProperty(key);
    }

    public static void main(String [] args){
        ProptertiesUtil proptertiesUtil = ProptertiesUtil.getInstance("D:\\workspace\\github\\codeGen\\src\\cfg.properties");
        System.out.println(proptertiesUtil.getValueByKey("a"));
        proptertiesUtil.setValueByKey("a","c");
        System.out.println(proptertiesUtil.getValueByKey("b"));
    }

}
