package org.scf.codeGen.tabel2Bean.util;

/**
 * Created by scf on 2016/2/20.
 */
public class CommonUtil {
    private static CommonUtil commonUtil;
    private CommonUtil(){}
    public static CommonUtil getInstance(){
        if(commonUtil == null){
            commonUtil = new CommonUtil();
        }
        return commonUtil;
    }

    /**
     *  解析模板文件属性配置，返回数组。
     * @return
     */
    public String[] parseTemplateFileCfg(String templateFileCfgKey){
        ProptertiesUtil proptertiesUtil = ProptertiesUtil.getInstance(Constant.cfgFilePath);
        String value = proptertiesUtil.getValueByKey(templateFileCfgKey);
        return value.split(",");
    }
}
