package org.scf.codeGen.tabel2Bean;

/**
 * Created by scf on 2016/2/20.
 */
public class GenerateFile {
    public static void main(String [] args) throws Exception{
        new Table2BeanUtil().excute("controllerftl");
    }
}
