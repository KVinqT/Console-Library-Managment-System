package com.kvin.library;

import java.util.Arrays;

public class Library {
	private Book[] books;
	private Member[] members;
	
	public Library(){
		books = new Book[0];
		members = new Member[0];
	}
	
	public void addBooks(Book book) {
		books =  Arrays.copyOf(books, books.length + 1);
		books[books.length - 1] = book;
		System.out.println("==========================================");
		System.out.println("Book named " + books[books.length-1].getTitle() + " is sucessfully added to the library");
		System.out.println("==========================================");
	}
	
	public void addMember(Member member) {
		members = Arrays.copyOf(members, members.length + 1);
		members[members.length - 1] = member;
		System.out.println("==========================================");
		System.out.println("New member " + members[members.length-1].getName() + " is sucessfully registered");
		System.out.println("==========================================");
	}
	
	public void borrowBook(Member member, Book book) {
		if(book.isAvailable()) {
			//remove borrowed book from the array
			int totalNewArrayCount = 0; 
			for(Book b: books) {
				if(!b.getTitle().equalsIgnoreCase(book.getTitle())) {
					totalNewArrayCount++;
				}
			}
			
			books = Arrays.copyOf(books,totalNewArrayCount);
			int index = 0;
			for(Book b: books) {
				if(!b.getTitle().equalsIgnoreCase(book.getTitle())) {
					books[index] = b;
					index++;
				}
			}
		}
		
		//call borrow book function from book object to change the state of isAvailable
		book.borrow();
		
		//add to the array of the member's borrowed books
		member.borrowBook(book);
	}
	
	public void returnBook(Member member, Book book) {
		books = Arrays.copyOf(books, books.length + 1);
		books[books.length - 1] = book;
		book.returnBook();
		member.returnBook(book);
	}
	
	public Book findBook(String title) {
		
		for(Book book: books) {
			if(book.getTitle().equalsIgnoreCase(title)) {
				return book;
			}
		}
		return null;
	}
	
	public Member findMember(int memberId) {
		for(Member member: members) {
			if(member.getMemberId() == memberId) {
				return member;
			}
		}
		return null;
	}
	
	public Book[] getBooks() {
		return books;
	}
	
	public Member[] getMembers() {
		return members;
	}
	public void displayBooks() {
		System.out.println("--- Lists of books in the library ---");
		for(int i = 0; i <= books.length - 1; i++) {
			System.out.println(Integer.toString(i + 1) + "." + " " + books[i].getTitle());
		}
	}
	
	public void displayMember() {
		System.out.println("--- Lists of members in the library ---");
		for(int i = 0; i <= members.length - 1; i++) {
			System.out.println(Integer.toString(i + 1) + "." + " " + members[i].getName());
		}
	}
}
