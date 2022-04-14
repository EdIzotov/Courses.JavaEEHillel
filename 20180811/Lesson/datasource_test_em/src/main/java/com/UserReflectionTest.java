package com;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserReflectionTest {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Object obj = new User("1", "2");
        System.out.println(obj);

        Class aClass = obj.getClass();

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
            field.setAccessible(true);
            field.set(obj, "newValue");
        }
        // System.out.println(obj);

        Method toString = aClass.getMethod("toString");
        Override annotation = toString.getAnnotation(Override.class);
        RoleAnnotation roleAnnotation = toString.getAnnotation(RoleAnnotation.class);
        if (roleAnnotation != null) {
            System.out.println(roleAnnotation.priveleg());
            System.out.println(roleAnnotation.role());
        }


        toString.invoke(obj);


        String str = "test";
        System.out.println(str.hashCode());

        Class<? extends String> metaData = str.getClass();
        Field value = metaData.getDeclaredField("value");
        value.setAccessible(true);
        value.set(str, "test123".toCharArray());
        System.out.println(str.hashCode());
        System.out.println(str);

        //str = str.concat("123");
        //System.out.println(str.hashCode());


    }
}
