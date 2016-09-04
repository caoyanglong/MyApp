package com.example.cyldao.utils;


import com.example.cyldao.AnalysJson;
import com.example.cyldao.dao.BaseType;
import com.example.cyldao.dao.CustomType;
import com.example.cyldao.dao.ListType;
import com.example.model.VideoModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyClass {
    public final static String opt = " = object.opt";

    private static List<GenerationJsonClass> generationJsonClasses = new ArrayList<>();
    private static Map<String,GenerationJsonClass> map = new HashMap<>();


    public static void main(String[] data) {
        Class<?> topModelClass = VideoModel.class;
        AnalysJson analysJson = new AnalysJson(topModelClass);
//        analysJson.setCustomType(AnalysJson.CustomClassType.Main);
        handleClass(analysJson);
        System.out.println(generationJsonClasses.size());
        handleMap(topModelClass.getName());
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println(baseClass.toString());
        System.out.println("--------------------------------------------------------------------------------------------------------------");

    }
    private static StringBuffer baseClass = new StringBuffer();
    /**
     * 处理map 中装载 的信息 最终生成  class代码
     * @param className
     */
    private static void handleMap(String className) {
        GenerationJsonClass generationJsonClass = map.get(className);
        System.out.println(className);
       if(generationJsonClass != null){
           baseClass.append(generationJsonClass.getClassBefore());
           List<String> childs = generationJsonClass.getChildNames();
           for (String name:childs){
               System.out.println(name);
               handleMap(name);
           }
           baseClass.append(generationJsonClass.getClassAfter());
       }
    }

    public final static String tab = "   ";

    private static void handleClass(AnalysJson analysJson) {
        List<String> childs = new ArrayList<>();
        //处理基本类型的类
        analysJson.getBaseTypes();
        StringBuffer baseCode = new StringBuffer();
        baseCode.append(analysJson.getClassBefore());
        baseCode.append(analysJson.getFiledContent());
        baseCode.append(analysJson.getConstructorBefore());
        for (BaseType type : analysJson.getBaseTypes()) {
            baseCode.append(tab + type.getBaseCode() + "\n");
        }

//处理自定义类型的类
        for (CustomType type : analysJson.getCustomTypes()) {
            childs.add(type.field.getType().getName());

            baseCode.append(tab + type.getTypeCode());
            AnalysJson analysJson1 = type.getAnalysJson();
            if (analysJson1 != null) {
                handleClass(analysJson1);
            }
        }
        //处理list 类型的 数据
        for (ListType type : analysJson.getListTypes()) {
            baseCode.append(tab + type.getTypeCode());
            AnalysJson analysJson1 = type.getAnalysJson();
            if (analysJson1 != null) {
                handleClass(analysJson1);
                childs.add(type.getAnalysJson().getaClass().getName());
            }
        }
        //处理类的结尾信息
        baseCode.append(analysJson.getConstructorAfter());
        baseCode.append(analysJson.getGetMethod());
        baseCode.append(analysJson.getSetMethod());
        String before = baseCode.toString();
        //类的结尾括号
        baseCode.append(analysJson.getClassAfter());
        generationJsonClasses.add(new GenerationJsonClass(before,analysJson.getClassAfter(),analysJson.getParent(),childs));
        map.put(analysJson.getaClass().getName(),new GenerationJsonClass(before,analysJson.getClassAfter(),analysJson.getParent(),childs));

    }

}
