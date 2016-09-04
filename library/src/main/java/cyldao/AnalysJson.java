package cyldao;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cyldao.dao.BaseType;
import cyldao.dao.CustomType;
import cyldao.dao.ListType;

/**
 * Created by CYL on 16-7-13.
 * email:670654904@qq.com
 */
public class AnalysJson {
    private String parent;
    private List<BaseType> baseTypes;
    private List<CustomType> customTypes;
    private List<ListType> listTypes;
    /**
     * 记录 基本数据类型的对应关系
     */
    public static Map<String,String > typeMap = new HashMap<>();


    private Class aClass;

    public static List<String> baseTypeArray = new ArrayList<>();
    static {
        baseTypeArray.add("int");
        baseTypeArray.add("String");
        baseTypeArray.add("boolean");
        baseTypeArray.add("long");
        baseTypeArray.add("char");
        baseTypeArray.add("integer");


        typeMap.put("int","Int");
        typeMap.put("String","String");
        typeMap.put("boolean","Boolean");
        typeMap.put("long","Long");
        typeMap.put("char","Char");
        typeMap.put("Integer","Int");
    }


    public AnalysJson(Class<?> aClass) {
        this.baseTypes = new ArrayList<>();
        this.customTypes = new ArrayList<>();
        this.listTypes = new ArrayList<>();
        this.aClass = aClass;
        if (aClass != null) {
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
//                System.out.println("basetype----=========---->"+aClass.getName()+"========="+field.getName());
                String typeName = field.getType().getSimpleName();
                //字段中的数据类型
                if (isBaseType(typeName)) {
                    baseTypes.add(new BaseType(field, field.getName()));

                }
                //数组类型
                else if (typeName.equalsIgnoreCase("list")) {
                    listTypes.add(new ListType(field,  field.getName()));
                }
                //自定义类型
                else {
                    if(aClass.getSimpleName().equalsIgnoreCase("Class") || aClass.getSimpleName().equalsIgnoreCase("Constructor")){

                    }
                    else{
                        customTypes.add(new CustomType(field,  field.getName()));
                    }
                }
            }
        }
    }

    /**
     * 判断是不是基本数据类型
     * @param type
     * @return
     */
    public static boolean isBaseType(String type){
        boolean flag = false;
        for (String ctype:baseTypeArray){
            if(ctype.equalsIgnoreCase(type)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void setBaseTypes(BaseType baseType) {
        this.baseTypes.add(baseType);
    }

    public void setCustomTypes(CustomType customType) {
        this.customTypes.add(customType);
    }

    public void setListTypes(ListType listType) {
        this.listTypes.add(listType);
    }

    public List<BaseType> getBaseTypes() {
        return baseTypes;
    }

    public List<CustomType> getCustomTypes() {
        return customTypes;
    }

    public List<ListType> getListTypes() {
        return listTypes;
    }

    public String getClassBefore() {
        if(parent == null){

            System.out.println("main");
                        return "\npublic class " + aClass.getSimpleName() +
                    "{\n";
        }
        else{
            return "\npublic static class "+aClass.getSimpleName() +
                    "{\n";
        }
    }

    public String getFiledContent() {
        StringBuffer buffer = new StringBuffer();
        for (Field field : aClass.getDeclaredFields()) {
            buffer.append("private " + field.getType().getSimpleName() + " " + field.getName() +
                    ";\n");
        }
        return buffer.toString();
    }

    public String getGetMethod() {
        StringBuffer buffer = new StringBuffer();
        for (Field field : aClass.getDeclaredFields()) {
            buffer.append("public " + field.getType().getSimpleName() +
                    " get" + toUoloadFisrt(field.getName()) + "(){\n" +
                    "return this." +
                    field.getName() + ";}\n");
        }
        return buffer.toString();
    }

    public String getSetMethod(){
        StringBuffer buffer = new StringBuffer();
        for (Field field : aClass.getDeclaredFields()) {
            buffer.append("public void"  +
                    " set" + toUoloadFisrt(field.getName()) + "(" +field.getType().getSimpleName()+" " +
                    ""+field.getName()+
                    "){\n" +
                    "this." +
                    field.getName() + " = " +field.getName()+
                    ";}\n");
        }
        return buffer.toString();
    }

    public String getConstructorBefore() {
        return "\npublic " + aClass.getSimpleName() + "(JSONObject object){\n" +
                "\n";
    }

    public String getConstructorAfter() {
        return "}\n";
    }

    public String getClassAfter() {
        return "}\n";
    }

    public String toUoloadFisrt(String content) {
        return content.substring(0, 1).toUpperCase() + content.substring(1);
    }


    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * 得到当前类
     * @return
     */
    public Class getaClass() {
        return aClass;
    }
}
