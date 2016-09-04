package cyldao.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CYL on 16-9-4.
 * email:670654904@qq.com
 */
public class GenerationJsonClass {
    private String classBefore;
    private String classAfter;
    private String parentName;
    //全路径名称
    private List<String> childNames = new ArrayList<>();

    public GenerationJsonClass(String classBefore, String classAfter) {
        this.classBefore = classBefore;
        this.classAfter = classAfter;
    }

    public GenerationJsonClass(String classBefore, String classAfter, String parentName, List<String> childNames) {
        this.classBefore = classBefore;
        this.classAfter = classAfter;
        this.parentName = parentName;
        this.childNames = childNames;
    }

    public GenerationJsonClass(String classBefore, String classAfter, String parentName) {
        this.classBefore = classBefore;
        this.classAfter = classAfter;
        this.parentName = parentName;
    }

    public GenerationJsonClass() {
    }

    public String getClassBefore() {
        return classBefore;
    }

    public void setClassBefore(String classBefore) {
        this.classBefore = classBefore;
    }

    public String getClassAfter() {
        return classAfter;
    }

    public void setClassAfter(String classAfter) {
        this.classAfter = classAfter;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<String> getChildNames() {
        return childNames;
    }

    public void setChildName(String childName) {
        this.childNames.add(childName);
    }
}
