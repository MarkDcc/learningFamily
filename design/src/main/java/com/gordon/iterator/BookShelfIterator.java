package com.gordon.iterator;

/**
 * @Author:dongchen
 * @Date: 2023/1/3 21:17
 */
public class BookShelfIterator implements BookIterator<Book>{
	private BookShelf bookShelf;
	int index = 0;

	public BookShelfIterator(BookShelf bookShelf){
		this.bookShelf = bookShelf;
	}
	@Override
	public boolean hasNext() {
		return index<bookShelf.getLength();
	}

	@Override
	public Book next() {
		Book book = bookShelf.getBook(index);
		index++;
		return book;
	}
}
