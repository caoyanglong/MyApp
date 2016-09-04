package cyldao.dao;


import java.lang.reflect.Field;

import cyldao.AnalysJson;

/**
 * Created by CYL on 16-7-13.
 * email:670654904@qq.com
 */
public class CustomType extends MyTpye {
    private String jsonObjectName;
    private AnalysJson analysJson;

    public CustomType(Field field, String cName) {
        super(field, cName);
        jsonObjectName = fieldName + "Object";
        //不是basetype 才可以使用的
        if(!AnalysJson.isBaseType(field.getType().getSimpleName())){
            this.analysJson = new AnalysJson(field.getType());
            this.analysJson.setParent(cName);
        }


    }

    public String getTypeCode() {
        return "JSONObject " + jsonObjectName + " = object.optJSONObject(\"" + fieldName +
                "\");\nif(" + jsonObjectName +
                "!=null){\nthis." +
                fieldName +
                " = new " + type +
                "(" + jsonObjectName +
                ");\n}\n" +
                "";
    }

    public AnalysJson getAnalysJson() {
        return analysJson;
    }
}
