package com.example.cyldao.dao;

import java.lang.reflect.Field;

/**
 * Created by CYL on 16-7-13.
 * email:670654904@qq.com
 */
public class MyTpye {
    private String cName;

    public Field field;
    public String fieldName;
    public String type;


    public MyTpye(Field field,String cName) {
           this.cName = cName;
           this.field = field;
           this.type = field.getType().getSimpleName();
           this.type =(this.type.charAt(0)+"").toUpperCase() + type.substring(1,type.length());

           this.fieldName = field.getName();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }



}
