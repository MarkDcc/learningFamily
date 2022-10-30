package com.gordon.multithred.basic.chapter3;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author dongchen
 * @Data 2022/10/16
 * @Time 20:25
 */
public class AtomicDemo {

	@Test
	public void testAtomicArray(){

		AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{1,2,3});
		System.out.println(atomicIntegerArray.addAndGet(0,2));
	}

	@Test
	public void testAtomicReference(){
		Boo boo = new Boo(1);
		AtomicStampedReference<Boo> reference = new AtomicStampedReference<Boo>(boo,1);
		Boo newBoo = new Boo(2);
		reference.compareAndSet(boo,newBoo,reference.getStamp(),3);
		System.out.println(reference.getStamp());
		System.out.println(reference.getReference());
	}

	class Boo{

		private int age;

		public Boo(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Boo{" +
					"age=" + age +
					'}';
		}
	}
}
