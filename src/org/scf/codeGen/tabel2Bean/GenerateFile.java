package org.scf.codeGen.tabel2Bean;

/**
 * Created by scf on 2016/2/20.
 */
public class GenerateFile {
    public static void main(String [] args) throws Exception{
        Table2BeanUtil table2BeanUtil = new Table2BeanUtil("controllerftl");
        new Thread(table2BeanUtil, "controllerftl线程").start();
//
//        Table2BeanUtil table2BeanUtil2 = new Table2BeanUtil("beanftl");
//        new Thread(table2BeanUtil2, "beanftl线程").start();
//
//        Table2BeanUtil table2BeanUtil3 = new Table2BeanUtil("daoftl");
//        new Thread(table2BeanUtil3, "daoftl线程").start();
//
//        Table2BeanUtil table2BeanUtil4 = new Table2BeanUtil("daoImplftl");
//        new Thread(table2BeanUtil4, "daoImplftl线程").start();
//
//        Table2BeanUtil table2BeanUtil5 = new Table2BeanUtil("jQueryEasyUiJspftl");
//        new Thread(table2BeanUtil5, "jQueryEasyUiJspftl线程").start();
//
//        Table2BeanUtil table2BeanUtil6 = new Table2BeanUtil("mybatisMapperftl");
//        new Thread(table2BeanUtil6, "mybatisMapperftl线程").start();

//        Table2BeanUtil table2BeanUtil7 = new Table2BeanUtil("serviceftl");
//        new Thread(table2BeanUtil7, "serviceftl线程").start();
//        
//        Table2BeanUtil table2BeanUtil71 = new Table2BeanUtil("serviceImplftl");
//        new Thread(table2BeanUtil71, "serviceftlImpl线程").start();

//        Table2BeanUtil table2BeanUtil8 = new Table2BeanUtil("beanftl");
//        new Thread(table2BeanUtil8, "beanftl线程").start();
//        
//        Table2BeanUtil table2BeanUtil9 = new Table2BeanUtil("beanExampleftl");
//        new Thread(table2BeanUtil9, "beanftl线程").start();
        
        
    }
}
