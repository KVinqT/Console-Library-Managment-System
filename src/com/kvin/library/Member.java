package com.kvin.library;

public class Member {
	private String name;
	private int memberId;
	private Book[] borrowedBooks = new Book[5];
	
	public  Member(String name,int memberId) {
		this.name = name;
		if(Integer.valueOf(memberId) instanceof Integer) {
			this.memberId = memberId;
		} 
	}
	
	public String getName() {
		return this.name;
	}
	public int getMemberId() {
		return this.memberId;
	}
	public Book[] getBorrowedBooks() {
		return this.borrowedBooks;
	}
	public void borrowBook(Book book) {
		//checking if the member's limit is full or not
		int borrowedBooksCount = 0;
		for(Book b: borrowedBooks) {
			if(b != null) {
				borrowedBooksCount++;
			} 
		}
		if(borrowedBooksCount == 5) {
			System.out.println("The borrowed books limit of this member is full");
			return;
		}
		
		//add the borrow book to the array
		for(int i = 0; i <= borrowedBooks.length - 1; i++ ) {
			if(borrowedBooks[i] == null) {
				borrowedBooks[i] = book;
			}
		}
	}
	
	public void returnBook(Book book) {
		int removeIndex = 0;
		for(int i = 0 ; i <= borrowedBooks.length - 1; i++ ) {
			if(borrowedBooks[i].getTitle().equalsIgnoreCase(book.getTitle())) {
				removeIndex = i;
			}
		}
		borrowedBooks[removeIndex] = null;
	}
}
