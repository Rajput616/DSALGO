package com.company;
import java.util.Scanner;

class Online_Library{
    public int no_of_books = 0;
    public int no_of_issued_books = 0;
    public String[] issuedBooks = new String[100];
    public String[] AvailableBooks = new String[100];

    public void  getIssuedBooks() {
        for(String book : issuedBooks){
            if(book == null)
                break;
            System.out.println(book);
        }
    }

    public void addBook(){
        System.out.println("Enter Book Name to Add");
        Scanner sc = new Scanner(System.in);
        AvailableBooks[no_of_books++] = sc.nextLine();
        System.out.println("Book Added Successfully");
    }
    public void issueBooK(){
        System.out.println("Books Available right now");
        int Book_number = 0;
        for(String book : AvailableBooks) {
            if (book == null){
                Book_number++;
                continue;
            }
            System.out.println("\t" + Book_number++ + ". "+  book);
        }
        System.out.print("Which book number for book you want to issue : ");
        Scanner sc = new Scanner(System.in);
        Book_number = sc.nextInt();
        issuedBooks[no_of_issued_books++] = AvailableBooks[Book_number];
        System.out.println("Book Issued");
        AvailableBooks[Book_number] = null;
        Book_number = 0;
        System.out.println("Books Available right now");
        for(String book : AvailableBooks){
            if(book == null){
                Book_number++;
                continue;
            }
            System.out.println("\t" + Book_number++ +". "+ book);
        }
        no_of_issued_books++;
    }

    public void returnBook(){
        System.out.print("Enter Book Name u want to return : ");
        Scanner sc = new Scanner(System.in);
        AvailableBooks[no_of_books] = sc.nextLine();
        System.out.println("Book Returned Successfully");
        no_of_books++;
    }
    public void showAvailableBooks(){
        System.out.println("Books Available right now");
        for(String book : AvailableBooks){
            if(book == null)
                continue;
            System.out.println("\t" + book);
        }
    }
}
public class CWH_Online_Library {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int user_choice;
        Online_Library Lib = new Online_Library ();
        //Show Menu

        System.out.println ("Work You Can Do in Library : ");
        System.out.println ("1. Add Book in Library\n" +
                            "2. Issue Book from Library\n" +
                            "3. Return Book to Library\n" +
                            "4. Show Available Books\n" +
                            "5. Show Books Issued\n" +
                            "6. Exit from the Library\n");
         do {
            System.out.print("Enter New Choice : ");
            user_choice = sc.nextInt();
            switch (user_choice) {
                case 1:
                    Lib.addBook();
                    break;
                case 2:
                    Lib.issueBooK();
                    break;
                case 3:
                    Lib.returnBook();
                    break;
                case 4:
                    Lib.showAvailableBooks();
                    break;
                case 5 :
                    Lib.getIssuedBooks();
                    break;
                default:
                    System.out.println("You exited from the Library -> Hope to see u again!");
            }
        }while(user_choice >=1 && user_choice <=5);
        System.out.println("Bye Bye");
    }
}