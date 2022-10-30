package com.gordon.basic.proxy;

import javax.print.attribute.standard.JobKOctets;

/**
 * @author dongchen
 * @Data 2022/10/25
 * @Time 22:22
 */
public class CGlibProxyMain {
	public static void main(String[] args) {
//		CGlibTargetObject cGlibTargetObject = new CGlibTargetObject();
//		CGlibProxyFactory cGlibProxyFactory = new CGlibProxyFactory(cGlibTargetObject);
//		CGlibTargetObject proxyObject = (CGlibTargetObject) cGlibProxyFactory.getProxyObject();
//		proxyObject.sendMessage("zhangsan");

		int i=0;
		System.out.println("i = " + i);
		test(i);
		System.out.println(i);

	}

	public static void test(int j){
		j=2;
		j++;
		System.out.println(j);
	}
}
