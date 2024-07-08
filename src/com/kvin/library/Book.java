package com.kvin.library;

public class Book {
	private String title;
	private String author;
	private String ISBN;
	private boolean isAvailable;
	
	public Book(String title, String author, String ISBN, boolean isAvailable) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.isAvailable = true;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void borrow() {
		this.isAvailable = false;
	}
	
	public void returnBook() {
		this.isAvailable = true;
	}
	
	public String toString() {
		return "Added Books Details \n" + "Book Name: " + this.title + "\n" + "Author Name: " + this.author + "\n" + "ISBN Number: " + this.ISBN ;
	}
	
}
