package com.example.cyldao.dao;


import com.example.cyldao.AnalysJson;

import java.lang.reflect.Field;

/**
 * Created by CYL on 16-7-13.
 * email:670654904@qq.com
 */
public class ListType extends MyTpye {
    private Class onnerClass;
    private AnalysJson analysJson;
    private String arrayName;

    public ListType(Field field, String cName) {
        super(field, cName);
        this.arrayName = fieldName+"Array";
        String listName = field.getGenericType().getTypeName();
        System.out.println("---------------------------->"+listName);
        listName = listName.substring(listName.indexOf("<")+1,listName.lastIndexOf(">"));
        try {
            onnerClass = Class.forName(listName);

            //不是basetype 才可以使用的
            if(!AnalysJson.isBaseType(onnerClass.getSimpleName())){
                this.analysJson = new AnalysJson(onnerClass);
                this.analysJson.setParent(cName);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getTypeCode(){
        return "JSONArray " +arrayName+
                " = object.optJSONArray(\"" +fieldName+
                "\");\nif(" +arrayName+
                "!=null){\nthis." +
                fieldName+" = new ArrayList<>();\n" +
                "for(int i=0;i<" +arrayName+".length();i++"+
                "){\n" +getContentByType()+
                "\n}\n"+
                "}";
    }

    /**
     * 得到内容根据类型
     * @return
     */
    public String getContentByType(){
        if(AnalysJson.isBaseType(onnerClass.getSimpleName())){
            String fileType = AnalysJson.typeMap.get(onnerClass.getSimpleName());

            return "this."+fieldName+".add(" +arrayName+
                    ".opt" +fileType+
                    "(i));";
        }
        else{
            return "this."+fieldName+".add(new " +onnerClass.getSimpleName()+
                    "("+arrayName+".optJSONObject(i)));";
        }
    }

    public AnalysJson getAnalysJson() {
        return analysJson;
    }
}
