package org.example.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @Author:dongchen
 * @Date: 2023/4/16 21:26
 */
public class Test {
//
//	// 定义一个泛型类
//	static class MyList<T> {
//	}
//
//	;
//
//	static interface MyList2<T> {
//	}
//
//	// 定义一个继承自 MyList<String> 类的子类
//	static class MyStringList extends MyList<String> {
//	}
//
//	;
//
//	// 定义一个实现了 MyList<Integer> 接口的类
//	static class MyIntegerList implements MyList2<Integer> {
//	}
//
//	;
//
//	public static void main(String[] args) {
//		// 获取 MyStringList 类的泛型父类和实现的接口
//		Type stringListType = MyStringList.class.getGenericSuperclass();
//		Type[] stringListInterfaces = MyStringList.class.getGenericInterfaces();
//
//		// 获取 MyIntegerList 类的泛型父类和实现的接口
//		Type integerListType = MyIntegerList.class.getGenericSuperclass();
//		Type[] integerListInterfaces = MyIntegerList.class.getGenericInterfaces();
//
//		// 输出泛型信息
//		System.out.println("MyStringList 类的泛型父类是：" + stringListType); // 输出：MyList<java.lang.String>
//		System.out.println("MyStringList 类实现的泛型接口是：" + stringListInterfaces[0]); // 输出：MyList<java.lang.String>
//
//		System.out.println("MyIntegerList 类的泛型父类是：" + integerListType); // 输出：java.lang.Object
//		System.out.println("MyIntegerList 类实现的泛型接口是：" + integerListInterfaces[0]); // 输出：MyList<java.lang.Integer>
//
//	}

	static class Super<T> {
		public void foo(T t) {}
	}

	static class Sub extends Super<String> {}

	public static void main(String[] args) throws ClassNotFoundException {
		// 获取 Sub 类的泛型父类 Super<String> 的类型
		Type superType = Sub.class.getGenericSuperclass();
		System.out.println("Sub.class.getTypeName() = " + Sub.class.getSuperclass().getTypeParameters());
		TypeVariable<Class<Sub>>[] typeParameters = Sub.class.getTypeParameters();
		for (TypeVariable<Class<Sub>> typeParameter : typeParameters) {
			System.out.println("typeParameter.getName() = " + typeParameter.getName());
		}
		System.out.println("superType.getTypeName() = " + superType.getTypeName());
		//ParameterizedType parameterizedType = (ParameterizedType) superType;
		TypeVariable superType1 = (TypeVariable) superType;
		System.out.println("superType1.getName() = " + superType1.getName());
		//System.out.println("parameterizedType.getActualTypeArguments()[0].getTypeName() = " + parameterizedType.getActualTypeArguments()[0].getTypeName());
		String className = superType.getTypeName();
		int dollarIndex = className.lastIndexOf('$');
		String suffix = className.substring(dollarIndex + 1);
		Class<?> aClass = Class.forName(suffix);
		System.out.println("aClass.getName() = " + aClass.getName());

		// 获取 Sub 类实现的泛型接口的类型数组
		Type[] interfaceTypes = Sub.class.getGenericInterfaces();

		// 输出泛型信息
		System.out.println("Sub 类的泛型父类是：" + superType); // 输出：Super<java.lang.String>
		System.out.println("Sub 类实现的泛型接口有：");
		for (Type interfaceType : interfaceTypes) {
			System.out.println(interfaceType); // 输出：空数组
		}
	}
}
