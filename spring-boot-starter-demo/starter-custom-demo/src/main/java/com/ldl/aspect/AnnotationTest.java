package com.ldl.aspect;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class AnnotationTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class clazz = Class.forName("com.ldl.aspect.User");
        //通过反射获取注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解value的值
        TableLdl tableLdl = (TableLdl)clazz.getAnnotation(TableLdl.class);
        System.out.println(tableLdl.value());

        Field name = clazz.getDeclaredField("name");
        FiledLdl filedLdl = name.getAnnotation(FiledLdl.class);
        System.out.println(filedLdl.columnName());
        System.out.println(filedLdl.type());
        System.out.println(filedLdl.length());

    }

}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableLdl {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FiledLdl {
    String columnName();
    String type();
    int length();
}

@TableLdl("user")
class User {
    @FiledLdl(columnName = "db_id", type = "string", length = 10)
    private int id;
    @FiledLdl(columnName = "db_age", type = "string", length = 10)
    private int age;
    @FiledLdl(columnName = "db_name", type = "int", length = 10)
    private int name;

    public User() {}

    public User(int id, int age, int name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }
}
