package com.gordon.iterator;

/**
 * @Author:dongchen
 * @Date: 2023/1/3 21:26
 */
public class IteratorMain {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf();
		bookShelf.appendBook(new Book("第一本"));
		bookShelf.appendBook(new Book("第二本"));
		bookShelf.appendBook(new Book("第三本"));
		bookShelf.appendBook(new Book("第四本"));
		BookIterator<Book> iterator = bookShelf.getIterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			System.out.println(book.toString());
		}
	}
}
