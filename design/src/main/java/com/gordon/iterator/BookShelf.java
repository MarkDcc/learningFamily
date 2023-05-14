package com.gordon.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:dongchen
 * @Date: 2023/1/3 21:12
 */
public class BookShelf implements Aggregate{
	private List<Book> books = new ArrayList<>();

	public Book getBook(int index){
		return books.get(index);
	}

	public void appendBook(Book book){
		books.add(book);
	}

	public int getLength(){
		return books.size();
	}


	@Override
	public BookIterator getIterator() {
		return new BookShelfIterator(this);
	}
}
