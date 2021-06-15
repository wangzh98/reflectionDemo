package com.wzh;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Person person = new Person();
        person.age = 22;
        test(person);
    }

    public static void test(Object object) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = object.getClass();
        Field ageField = aClass.getDeclaredField("age");
        int anInt = ageField.getInt((object));
        System.out.println(anInt);

        Method method = aClass.getDeclaredMethod("sayhello");
        method.setAccessible(true);
        method.invoke(object);
        System.out.println(aClass.isAnnotationPresent(MyAnno.class));
        System.out.println(ageField.getDeclaredAnnotation(MyAnno.class).name());


    }
}

@MyAnno(name = "aa")
class Person {
    @MyAnno
    int age;

    @MyAnno
    private void sayhello() {
        System.out.println("hello");
    }
}
