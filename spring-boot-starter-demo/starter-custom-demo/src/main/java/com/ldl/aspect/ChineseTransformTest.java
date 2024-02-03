package com.ldl.aspect;

import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;

public class ChineseTransformTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("ldl", "李德良1");
        map.put("lili", "李德良2");
        map.put("liangliang", "李德良3");

        Student student = new Student("lili|liangliang|ldl", "", 10);
        Class clazz = student.getClass();
        Annotation annotation = clazz.getAnnotation(ChineseTransform.class);
    }

}
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ChineseTransform {

}

class Student {

    @ChineseTransform
    private String name;
    private String realName;
    private int age;

    public Student(String name, String realName, int age) {
        this.name = name;
        this.realName = realName;
        this.age = age;
    }
}