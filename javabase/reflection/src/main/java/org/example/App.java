package org.example;

import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws NoSuchFieldException {
//        printClassInfo("".getClass());
//        printClassInfo(Runnable.class);
//        printClassInfo(java.time.Month.class);
//        printClassInfo(String[].class);
//        printClassInfo(int.class);
//        Student student = new Student("三班",1);
//        printFiledInfo(student.getClass(),student);

        //Student student = new Student("三班",1);
        //printMethodInfo(student.getClass(), student);
        Student student = getStudent();
        student.print();

    }

    static Student getStudent(){
        Class<Student> studentClass = Student.class;
        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if(constructor.getParameterCount()==2){
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if(parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1]==Integer.class){
                    try {
                        Student test = (Student)constructor.newInstance("测试", 2);
                        return test;
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return null;
    }

    static void printMethodInfo(Class cls,Object obj){
        try {
            Method getName = cls.getMethod("getNumber", Integer.class);
            ((Student)obj).getNumber(1);
            System.out.println("getName.getName() = " + getName.getName());
            getName.invoke(obj,2);

            Method getNumber = cls.getMethod("getNumber", Integer.class, String.class);
            getNumber.invoke(obj,2,"sanban");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static void printFiledInfo(Class cls,Object obj) throws NoSuchFieldException {
        //cls.getField()和cls.getFields()都是获取public属性
        //cls.getDeclaredFields() 和cls.getDeclaredField()获取当前类的field,包括private属性
        for (Field declaredField : cls.getDeclaredFields()) {
            System.out.println("declaredField = " + declaredField);
        }
        System.out.println("父类public属性：cls.getField(\"name\") = " + cls.getField("name"));
        //System.out.println("父类private属性：cls.getField(\"address\") = " + cls.getField("address"));
        System.out.println("当前类public属性：cls.getField(\"number\") = " + cls.getField("number"));
        //System.out.println("当前类private属性：cls.getField(\"classRoom\") = " + cls.getField("classRoom"));

        System.out.println("*******************");
        Field field = cls.getField("number");
        System.out.println("field.getName() = " + field.getName());
        System.out.println("field.getType() = " + field.getType());

        Field classRoom = cls.getDeclaredField("classRoom");
        try {
            System.out.println("field.get(obj) = " + field.get(obj));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        //当访问private filed值的时候需要设置accessible
        classRoom.setAccessible(true);
        try {
            System.out.println("classRoom.get(obj) = " + classRoom.get(obj));
            classRoom.set(obj,"四班");
            System.out.println("修改之后的值：");
            System.out.println("classRoom.get(obj) = " + classRoom.get(obj));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }

}
