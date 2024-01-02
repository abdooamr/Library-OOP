/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import libraryoop.User.userInfo;
import static libraryoop.Books.readBooks;

/**
 *
 * @author youse
 */
public class Books implements Serializable {
    //static   ArrayList userinfo = new ArrayList<>();
    /*                                                                   */
    static ArrayList<User.userInfo> userLists = new ArrayList();
    static ArrayList<Books.BookInfo> booksarr = new ArrayList();
    /*                                                                   */
    
    
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH FUNCTIONS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH BOOK BY GENRE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void SearchByGenre(String genre, ArrayList<Books.BookInfo> list) {
        boolean found = false;
        for (int i = 0; i < list.size(); ++i) {
            Books.BookInfo obj = list.get(i);
            while ((obj.getGenre()).equals(genre)) {
                if ((obj.getGenre()).equals(genre)) {
                    list.get(i);
                    System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Book not found");
        }
    }
    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH BOOK BY TITLE>>>>>>>>>>>>>>>>>>

    public void SearchByTitle(String Name, ArrayList<Books.BookInfo> list) {
        boolean found = false;
        for (int i = 0; i < list.size(); ++i) {
            Books.BookInfo obj = list.get(i);
            while ((obj.getTitle()).equals(Name)) {
                if ((obj.getTitle()).equals(Name)) {
                    list.get(i);
                    System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Book not found");
        }
    }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH BOOK BY AUTHOR>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public void SearchByAuthor(String Author, ArrayList<Books.BookInfo> list) {
        boolean found = false;
        for (int i = 0; i < list.size(); ++i) {
            Books.BookInfo obj = list.get(i);
            while ((obj.getAuthor()).equals(Author)) {
                if ((obj.getAuthor()).equals(Author)) {
                    list.get(i);
                    System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
                    found = true;
                    break;
                }

            }

        }
        if (!found) {
            System.out.println("Book not found");
        }
    }
    ////<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH BOOK BY location>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
   public void SearchBylocation(String location, ArrayList<Books.BookInfo> list) {
        boolean found = false;
        for (int i = 0; i < list.size(); ++i) {
            Books.BookInfo obj = list.get(i);
            while ((obj.getLocation()).equals(location)) {
                if ((obj.getLocation()).equals(location)) {
                    list.get(i);
                    System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
                    found = true;
                    break;
                }

            }

        }
        if (!found) {
            System.out.println("Book not found");
        }
    }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH BOOK BY ID>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public void SearchBook(String id, ArrayList<Books.BookInfo> list) {
        //      o.retriveBooks(usersList);
        boolean found = false;
        for (int i = 0; i < list.size(); ++i) {

            Books.BookInfo obj = list.get(i);
            if ((obj.getISBN()).equals(id)) {
                list.get(i);
                System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());
                found = true;
                break;
            }

        }
        if (!found) {
            System.out.println("Book not found");
        }

    }

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<END OF SEARCH >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>        
    public static String VB(ArrayList<BookInfo> list) throws IOException {
        String filepath = "Books.txt";
        String finalValue = "";
        try (FileReader file = new FileReader(filepath)) {
            BufferedReader br = new BufferedReader(file);

            String line;

            while ((line = br.readLine()) != null) {
                BookInfo obj = new BookInfo();

                String[] parts = line.split(" ");

                obj.setISBN(parts[0]);
                obj.setTitle(parts[1]);
                obj.setAuthor(parts[2]);
                obj.setLocation(parts[3]);
                obj.setNumOfCopies(parts[4]);
                obj.setGenre(parts[5]);
                double fixedprice = Double.parseDouble(parts[6]);
                obj.setPrice(fixedprice);
                if (parts[7].equals("true")) {
                    obj.setRent(true);
                } else {
                    obj.setRent(false);
                }
                list.add(obj);
                String s = String.valueOf(fixedprice);
                finalValue += "ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice() + "\n\n";

            }

        }
        String x = finalValue;
        System.out.println(x);
        return x;
    }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<VIEW ALL BOOKS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   

    public static void ViewBooks(ArrayList<BookInfo> list) throws IOException {
        String filepath = "Books.txt";

        try (FileReader file = new FileReader(filepath)) {
            BufferedReader br = new BufferedReader(file);

            String line;

            while ((line = br.readLine()) != null) {

                BookInfo obj = new BookInfo();

                String[] parts = line.split(" ");

                obj.setISBN(parts[0]);
                obj.setTitle(parts[1]);
                obj.setAuthor(parts[2]);
                obj.setLocation(parts[3]);
                obj.setNumOfCopies(parts[4]);
                obj.setGenre(parts[5]);
                double fixedprice = Double.parseDouble(parts[6]);
                obj.setPrice(fixedprice);
                if (parts[7].equals("true")) {
                    obj.setRent(true);
                } else {
                    obj.setRent(false);
                }
                list.add(obj);

                System.out.println("ID:" + obj.getISBN() + " Title:" + obj.getTitle() + " Author:" + obj.getAuthor() + " Location:" + obj.getLocation() + " Number of copies:" + obj.getNumOfCopies() + " Genre:" + obj.getGenre() + " Price:" + obj.getPrice());

            }
        }
    }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<BOOK FILE READ AND UPDATE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>     

    public static void readBooks(ArrayList<BookInfo> list) throws IOException {
        String filepath = "Books.txt";

        try (FileReader file = new FileReader(filepath)) {
            BufferedReader br = new BufferedReader(file);

            String line;

            while ((line = br.readLine()) != null) {

                BookInfo obj = new BookInfo();

                String[] parts = line.split(" ");

                obj.setISBN(parts[0]);
                obj.setTitle(parts[1]);
                obj.setAuthor(parts[2]);
                obj.setLocation(parts[3]);
                obj.setNumOfCopies(parts[4]);
                obj.setGenre(parts[5]);
                double fixedprice = Double.parseDouble(parts[6]);
                obj.setPrice(fixedprice);
                if (parts[7].equals("true")) {
                    obj.setRent(true);
                } else {
                    obj.setRent(false);
                }
                list.add(obj);

            }
        }
    }

    /*   */

    public static void fileUpdateBooks(ArrayList<BookInfo> list) throws IOException {

        String filepath = "Books.txt";
        try (FileWriter file = new FileWriter(filepath)) {
            for (int i = 0; i < list.size(); ++i) {
                BookInfo userObj = list.get(i);

                String line = userObj.getISBN() + " " + userObj.getTitle() + " " + userObj.getAuthor() + " " + userObj.getLocation() + " "
                        + userObj.getNumOfCopies() + " " + userObj.getGenre() + " " + userObj.getPrice() + " " + userObj.getisRent();
                file.write(line + "\n");

            }
        }
    }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<END OF FILE HANDELING>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>     

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<REMOVE BOOK>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>     
    public static void RemoveBook(String id, ArrayList<BookInfo> list) {

        for (int i = 0; i < list.size(); ++i) {

            BookInfo obj = list.get(i);
            if ((obj.getISBN()).equals(id)) {
                list.remove(i);
                System.out.println("Book removed succefully!");
                JOptionPane.showMessageDialog(null, "Book removed succefully!");
                
                break;
            }
        }

    }
    // ArrayList UserInfo = new ArrayList<>();
    static ArrayList<User.userInfo> usersarr = new ArrayList();
    // User.ReadUsers(userInfo);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Buy BOOK>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    

    public void run() throws IOException {
        ArrayList bookinfo = new ArrayList<>();
        readBooks(bookinfo);
        User.ReadUsers(userLists);
        //   SearchByAuthor("2", bookinfo);
      

    }

    public static class BookInfo {

        private String ISBN;
        private String Title;
        private String Author;
        private String Location;
        private String NumOfCopies;
        private String Genre;
        private double Price;
        boolean rent;

        public void setISBN(String pass) {
            this.ISBN = pass;
        }

        public void setTitle(String n) {
            this.Title = n;
        }

        public void setAuthor(String n) {
            this.Author = n;
        }

        public void setLocation(String d) {
            this.Location = d;
        }

        public void setNumOfCopies(String a) {
            this.NumOfCopies = a;
        }

        public void setGenre(String ph) {
            this.Genre = ph;
        }

        public void setPrice(double e) {
            this.Price = e;
        }

        public void setRent(boolean rent) {
            this.rent = rent;
        }

        public String getISBN() {
            return this.ISBN;
        }

        public String getTitle() {
            return this.Title;
        }

        public String getAuthor() {
            return this.Author;
        }

        public String getLocation() {
            return this.Location;
        }

        public String getNumOfCopies() {
            return this.NumOfCopies;
        }

        public String getGenre() {
            return this.Genre;
        }

        public double getPrice() {
            return this.Price;
        }

        public boolean getisRent() {
            return rent;
        }

    }
    
}