package com.gordon.basic;

import com.gordon.basic.proxy.ProxyObjectInvocationHandler;
import com.gordon.basic.proxy.SmsService;
import com.gordon.basic.proxy.SmsServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author dongchen
 * @Data 2022/10/24
 * @Time 21:35
 */
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
//		/**
//		 * 获取class对象
//		 */
//		Class<TargetObject> aClass = (Class<TargetObject>) Class.forName("com.gordon.basic.TargetObject");
//		System.out.println(aClass);
//
////		Class<TargetObject> targetObjectClass = TargetObject.class;
////		System.out.println(targetObjectClass);
//
////		Class<?> aClass1 = ClassLoader.getSystemClassLoader().loadClass("com.gordon.basic.TargetObject");//获取类加载器，jvm双亲委派
////		System.out.println("aClass = " + aClass);
//
//		Method[] methods = aClass.getMethods();
//		for (Method method : methods) {
//			//System.out.println("method.getName() = " + method.getName());
//		}
//		TargetObject targetObject = aClass.newInstance();
//
//		Method publicMethod = aClass.getDeclaredMethod("publicMethod", String.class);
//		publicMethod.invoke(targetObject,"zhangsan");
//		aClass.getDeclaredMethod("staticMethod", String.class).invoke(aClass,"zhangsan");
//
//		for (Field declaredField : aClass.getDeclaredFields()) {
//
//			System.out.println("declaredField = " + declaredField);
//			System.out.println(targetObject.toString());
//			declaredField.setAccessible(true);
//			declaredField.set(targetObject,"lisi");
//			System.out.println(targetObject.toString());
//		}



	}
}
