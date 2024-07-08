package com.kvin.library;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LibraryManagmentSystem {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Library library = new Library();
	
	public static boolean reOperate() {
		System.out.print("Do you want to reoperate ? (y/n): ");
        try {
			String reOperate = reader.readLine();
			if(reOperate.equalsIgnoreCase("y")) {
				return true;
			} else if(reOperate.equalsIgnoreCase("n")) {
				System.out.println("Exist from the managment system !");
				System.out.println("Good Bye");
				System.out.println("==================================");
				return false;
			}
		} catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
		}
        return false;
	}
	public static void operationBySelectedNum(int operationNo) throws IOException {
		if(operationNo == 1) {
			System.out.println("Welcome to the section of adding new books");
			System.out.println("------------------------------------------");
			System.out.print("Enter the title of the book: ");
	        String title = reader.readLine();
			System.out.print("Enter the author of the book: ");
	        String author = reader.readLine();
			System.out.print("Enter the ISBM of the book: ");
	        String ISBM = reader.readLine();
			Book newBook = new Book(title,author,ISBM, true);
			library.addBooks(newBook);			
		}
		if(operationNo == 2) {
			System.out.println("Welcome to the section of adding new library member");
			System.out.println("------------------------------------------");
			System.out.print("Enter the name of a member: ");
            String name = reader.readLine();
			System.out.print("Enter the memberId of a member: ");
            int memberId = Integer.parseInt(reader.readLine());
			Member newMember = new Member(name,memberId);
			library.addMember(newMember);			
		}
		if(operationNo == 3) {
			System.out.println("Welcome to the section of borrowing books to a member");
			System.out.println("------------------------------------------------------");
			System.out.println("1. Find the member");
			System.out.println("2. Display all books");
			System.out.println("3. Display all members");
			System.out.println("4. Find the book");
			System.out.println("5. Borrow the book");
			System.out.print("Enter the operation number: ");
			int num = Integer.parseInt(reader.readLine());
			if(num == 1) {
				System.out.print("Enter member id to find: ");
	            int memberId = Integer.parseInt(reader.readLine());
	            Member foundMember = library.findMember(memberId);
				if(foundMember == null) {
					System.out.println("========================");
					System.out.println("The member is not found!");
					System.out.println("========================");
				} else {
					System.out.println("========================");
					System.out.println("Member " + foundMember.getName() + " is found in the system database!");
					System.out.println("========================");
				}
			} else if(num == 2) {
				library.displayBooks();
			} else if(num == 3) {
				library.displayMember();
			} else if(num == 4) {
				System.out.print("Enter book title to find: ");
				String title = reader.readLine();
				Book foundBook = library.findBook(title);
				if(foundBook == null) {
					System.out.println("========================");
					System.out.println("The book is not found!");
					System.out.println("========================");
				} else {
					System.out.println("========================");
					System.out.println("Book name " + foundBook.getTitle() + " is found in the system database!");
					System.out.println("========================");
				}
			} else if (num == 5) {
				System.out.print("Enter a book title to borrow: ");
				String title = reader.readLine();
				Book foundBook = library.findBook(title);
				System.out.print("Enter a member id: ");
	            int memberId = Integer.parseInt(reader.readLine());
	            Member foundMember = library.findMember(memberId);
	            if(foundBook != null && foundMember != null) {
	            	library.borrowBook(foundMember,foundBook);
					System.out.println("Book " + foundBook.getTitle() + " is successfully borrow to member " + foundMember.getName());
				} else {
					System.out.print("Book or Member is not fount in the system database");
				}
				
			}
		}
		if(operationNo == 4) {
			
			System.out.print("Enter a member id: ");
            int memberId = Integer.parseInt(reader.readLine());
            Member foundMember = library.findMember(memberId);
            Book[] borrowedBooksOfMember = foundMember.getBorrowedBooks();
            System.out.print("Enter a book title to return: ");
			String title = reader.readLine();
			Book foundBook = null;
            for(int i = 0; i <= borrowedBooksOfMember.length - 1; i++ ) {
            	if(title.equalsIgnoreCase(borrowedBooksOfMember[i].getTitle())) {
            		foundBook = borrowedBooksOfMember[i];
            	}
            }
			if(foundBook != null && foundMember != null) {
				library.returnBook(foundMember, foundBook);
				System.out.println("Book " + foundBook.getTitle() + " is successfully return to the library by " + foundMember.getName());
			} else {
				System.out.print("Book or Member is not fount in the system database");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			boolean isContinueProject = true;
			while(isContinueProject) {
				System.out.println("Welcome from mini library managment system");
				System.out.println("==========================================");
				System.out.println("Please select one operation !");
				System.out.println("==========================================");
				System.out.println("==========================================");
				System.out.println("1.Add books to library: ");
				System.out.println("2.Add new library member: ");
				System.out.println("3.Borrow the available books to member: ");
				System.out.println("4.Return the borrowed books to library: ");
				System.out.print("Operation id: ");
		        int num = Integer.parseInt(reader.readLine());
		        operationBySelectedNum(num);
		        isContinueProject = reOperate();
			}
			
			
		} catch(IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
		}
	}	

}
