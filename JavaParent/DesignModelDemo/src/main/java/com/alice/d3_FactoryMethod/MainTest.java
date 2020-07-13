package com.alice.d3_FactoryMethod;

import java.lang.reflect.Method;

public class MainTest {

    public static void main(String[] args) {

        try {
            Student student = (Student) Class.forName("com.alice.d3_FactoryMethod.Student").newInstance();
            student.setAddress("beijing");
            student.setName("liusc");
            System.out.println(student);
            System.out.println(Class.forName("com.alice.d3_FactoryMethod.Student").getName());
            System.out.println(Student.class);
//            System.out.println(Class.forName("com.alice.d3_FactoryMethod.Student").getSimpleName());
//            System.out.println(Class.forName("com.alice.d3_FactoryMethod.Student"));
//            ClassLoader classLoader = Class.forName("com.alice.d3_FactoryMethod.Student").getClassLoader();
//            System.out.println(classLoader.getParent());

            Method[] methods = Class.forName("com.alice.d3_FactoryMethod.Student").getMethods();
            StringBuffer stringBuffer = new StringBuffer();
            for (Method method : methods) {
                stringBuffer.append(method.getName() + " ");
            }
            System.out.println(stringBuffer.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
