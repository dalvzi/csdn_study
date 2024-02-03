package com.ldl.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class clazz1 = User.class;
        Class clazz2 = clazz1.getClass();
        Class clazz3 = Class.forName("com.ldl.reflect.User");


        //获取全类名
        String name = clazz1.getName();
        //获取类名
        String simpleName = clazz1.getSimpleName();
        //获取public类属性
        Field[] fields = clazz1.getFields();
        //获取全部类属性
        Field[] declaredFields = clazz1.getDeclaredFields();
        //获得指定属性的值
//        Field id = clazz1.getField("id");
        Field id = clazz1.getDeclaredField("id");
        //获取本类及父类的public方法
        Method[] methods = clazz1.getMethods();
        //获取本类的所有方法
        Method[] declaredMethods = clazz1.getDeclaredMethods();
        //获得指定方法
        Method method = clazz1.getMethod("getUsername", null);
        //获得构造器
        Constructor[] constructors = clazz1.getConstructors();
        //获得全部构造器
        Constructor[] declaredConstructors = clazz1.getDeclaredConstructors();
        //获得指定构造器
        Constructor constructor = clazz1.getConstructor();
        //获得指定的构造器
        Constructor declaredConstructor = clazz1.getDeclaredConstructor();
        //接口
        Class[] interfaces = clazz1.getInterfaces();
        //注解
        Annotation[] annotations = clazz1.getAnnotations();
        //注解
//        Annotation declaredAnnotation = clazz1.getDeclaredAnnotation(null);

        User user = (User)clazz1.newInstance();
        //通过反射调用方法
        Method setUsername = clazz1.getDeclaredMethod("setUsername", String.class);
        setUsername.invoke(user, "lilili");
        System.out.println(user.getUsername());

        User user2 = (User)clazz1.newInstance();
        Field username = clazz1.getDeclaredField("username");
        // 不能直接操作私有属性，需要关掉安全监测机制
        username.setAccessible(true);
        username.set(user2, "lilili222");
        System.out.println(user2.getUsername());

    }

}

class User {
    private String id;
    private String username;
    private String password;


    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
