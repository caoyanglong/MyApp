package cyldao.dao;

import java.lang.reflect.Field;

/**
 * Created by CYL on 16-7-13.
 * email:670654904@qq.com
 */
public class BaseType extends MyTpye {
    public BaseType(Field field, String cName) {
        super(field, cName);
    }

    public String getBaseCode() {
        return "this." + fieldName + " = object.opt" + type + "(\"" + fieldName +
                "\");";
    }
}
