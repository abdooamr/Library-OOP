/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import libraryoop.Books.BookInfo;
import libraryoop.User.userInfo;

/**
 *
 * @author youse
 */
public class BookSettings {

    public void run() throws IOException, InterruptedException {

        ArrayList bookinfo = new ArrayList<>();
        Books b = new Books();
        b.readBooks(bookinfo);
        String choice = "";

        while (true) {
            System.out.println("-------------------Book Settings----------------------------");
            System.out.println("If you want to add book Press 1 ");
            System.out.println("To remove book press 2");
            System.out.println("To access Book Info Modifier Press 3");
            System.out.println("To go Back to main Menu Press 4");
            System.out.println("------------------------------------------------------------");

            Scanner in = new Scanner(System.in);
            choice = in.next();
            String t;

            if (choice.equals("1")) {
                BookInfo obj = new BookInfo();

                System.out.print("Enter book ISBN: ");
                t = in.next();
                obj.setISBN(t);
                System.out.print("Enter book title: ");
                t = in.next();
                obj.setTitle(t);
                System.out.print("Enter book Author: ");
                t = in.next();
                obj.setAuthor(t);
                System.out.print("Enter book Location: ");
                t = in.next();
                obj.setLocation(t);
                System.out.print("Enter Number of Copies: ");
                t = in.next();
                obj.setNumOfCopies(t);
                System.out.print("Enter book Genre: ");
                t = in.next();
                obj.setGenre(t);
                System.out.print("Enter book Price: ");
                double price = in.nextDouble();
                obj.setPrice(price);

                bookinfo.add(obj); /// adding every user at the array list;
                b.fileUpdateBooks(bookinfo);

            } else if (choice.equals("2")) {
                BookInfo obj = new BookInfo();
                System.out.print("Enter Book ID: ");
                t = in.next();
                obj.setISBN(t);

                b.RemoveBook(t, bookinfo);
                b.fileUpdateBooks(bookinfo);
                //  retriveDataBooks(usersList);

            } else if (choice.equals("3")) {

                System.out.println("-------------------Book Settings----------------------------");
                System.out.println("If you want to Edit Book Title Press 1, \nOr Author Press 2 ");
                System.out.println("Or Location press 3 \nOr NumOfCopies press 4");
                System.out.println("Or Genre Press 5 \nOr Price Press 6");
                System.out.println("To go Back to main Menu Press 7");
                System.out.println("------------------------------------------------------------");

                choice = in.next();
                if (choice.equals("1")) {
                    String ID, Title;
                    System.out.println("enter Book ISBN");
                    ID = in.next();
                    System.out.println("Enter new Title");
                    Title = in.next();
                    EditBookTitle(ID, bookinfo, Title);
                    b.fileUpdateBooks(bookinfo);
                    System.out.println("Redirecting back to Book Settings..");
                    TimeUnit.MILLISECONDS.sleep(700);
                } else if (choice.equals("2")) {
                    String ID, Author;
                    System.out.println("enter Book ISBN");
                    ID = in.next();
                    System.out.println("Enter new Author");
                    Author = in.next();
                    EditBookAuthor(ID, bookinfo, Author);
                    b.fileUpdateBooks(bookinfo);
                    System.out.println("Redirecting back to Book Settings..");
                    TimeUnit.MILLISECONDS.sleep(700);
                } else if (choice.equals("3")) {
                    String ID, Location;
                    System.out.println("enter Book ISBN");
                    ID = in.next();
                    System.out.println("Enter new Location");
                    Location = in.next();
                    EditBookLocation(ID, bookinfo, Location);
                    b.fileUpdateBooks(bookinfo);
                    System.out.println("Redirecting back to Book Settings..");
                    TimeUnit.MILLISECONDS.sleep(700);
                } else if (choice.equals("4")) {
                    String ID, NumofCopies;
                    System.out.println("enter Book ISBN");
                    ID = in.next();
                    System.out.println("Enter new Number of Copies");
                    NumofCopies = in.next();
                    EditBookNumOfCopies(ID, bookinfo, NumofCopies);
                    b.fileUpdateBooks(bookinfo);
                    System.out.println("Redirecting back to Book Settings..");
                    TimeUnit.MILLISECONDS.sleep(700);
                } else if (choice.equals("5")) {
                    String ID, Genre;
                    System.out.println("enter Book ISBN");
                    ID = in.next();
                    System.out.println("Enter new Genre");
                    Genre = in.next();
                    EditBookGenre(ID, bookinfo, Genre);
                    b.fileUpdateBooks(bookinfo);
                    System.out.println("Redirecting back to Book Settings..");
                    TimeUnit.MILLISECONDS.sleep(700);
                } else if (choice.equals("6")) {
                    String ID;
                    Double Price;
                    System.out.println("enter Book ISBN");
                    ID = in.next();
                    System.out.println("Enter new Price");
                    Price = in.nextDouble();
                    EditBookPrice(ID, bookinfo, Price);
                    b.fileUpdateBooks(bookinfo);
                    System.out.println("Redirecting back to Book Settings..");
                    TimeUnit.MILLISECONDS.sleep(700);
                } else if (choice.equals("7")) {
                    System.out.println("Redirecting back to Main Menu..");
                    break;
                } }else if (choice.equals("4")) {
                    System.out.println("Redirecting back to Main Menu..");
                    break;
                }

            }

        }
    

//            public void EditBookTitle(String id, ArrayList<BookInfo> list,String newAuthor) {
//
//        for (int i = 0; i < list.size(); ++i) {
//
//            BookInfo obj = list.get(i);
//
//            if (obj.getISBN().equals(id)) {
//                obj.setAuthor(newAuthor);
//                System.out.println("Book Author has been updated!");
//                
//            }
//
//        }
//
//    }
    public void EditBookAuthor(String id, ArrayList<BookInfo> list, String newAuthor) {

        for (int i = 0; i < list.size(); ++i) {

            BookInfo obj = list.get(i);

            if (obj.getISBN().equals(id)) {
                obj.setAuthor(newAuthor);
                System.out.println("Book Author has been updated!");

            }

        }
    }

    public void EditBookTitle(String id, ArrayList<BookInfo> list, String newTitle) {

        for (int i = 0; i < list.size(); ++i) {

            BookInfo obj = list.get(i);

            if (obj.getISBN().equals(id)) {
                obj.setTitle(newTitle);
                System.out.println("Title has been updated!");

            }
        }
    }

    public void EditBookLocation(String id, ArrayList<BookInfo> list, String newLocation) {

        for (int i = 0; i < list.size(); ++i) {

            BookInfo obj = list.get(i);

            if (obj.getISBN().equals(id)) {
                obj.setLocation(newLocation);
                System.out.println("Location has been updated!");

            }
        }
    }

    public void EditBookNumOfCopies(String id, ArrayList<BookInfo> list, String newNumOfCopies) {

        for (int i = 0; i < list.size(); ++i) {

            BookInfo obj = list.get(i);

            if (obj.getISBN().equals(id)) {
                obj.setNumOfCopies(newNumOfCopies);
                System.out.println("Number of copies has been updated!");

            }
        }
    }

    public void EditBookGenre(String id, ArrayList<BookInfo> list, String newGenre) {

        for (int i = 0; i < list.size(); ++i) {

            BookInfo obj = list.get(i);

            if (obj.getISBN().equals(id)) {
                obj.setGenre(newGenre);
                System.out.println("Genre has been updated!");

            }
        }
    }

    public void EditBookPrice(String id, ArrayList<BookInfo> list, Double newPrice) {

        for (int i = 0; i < list.size(); ++i) {

            BookInfo obj = list.get(i);

            if (obj.getISBN().equals(id)) {
                obj.setPrice(newPrice);
                System.out.println("price has been updated!");

            }
        }
    }

}
