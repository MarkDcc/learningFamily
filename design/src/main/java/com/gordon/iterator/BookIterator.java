package com.gordon.iterator;


/**
 * @Author:dongchen
 * @Date: 2023/1/3 21:08
 */
public interface BookIterator<T> {
	boolean hasNext();
	T next();
}
