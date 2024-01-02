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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author youse
 */
public class Purchase {

    public static void run() throws IOException {
        ArrayList<Books.BookInfo> bookinfo = new ArrayList();
        ArrayList SoldBookInfo = new ArrayList<>();
        ReadSoldBooks(SoldBookInfo);
        Books b = new Books();
        b.readBooks(bookinfo);
        System.out.println("To buy book enter book ISBN");
        String ID;
        String choice;
        Scanner in = new Scanner(System.in);
        ID = in.next();
        for (int i = 0; i < bookinfo.size(); ++i) {

            Books.BookInfo obj1 = bookinfo.get(i);
            if ((obj1.getISBN()).equals(ID)) {
                bookinfo.get(i);
                int num1 = Integer.parseInt(bookinfo.get(i).getNumOfCopies());
                if (num1 <= 0) {
                    System.out.println("there's no copy left");
                    break;
                } else {
                    System.out.println("Book Price is: " + bookinfo.get(i).getPrice() + "\t\tPress 1 to pay with 2, No to use cash");
                    int num = Integer.parseInt(bookinfo.get(i).getNumOfCopies());
                    int newnum = num - 1;
                    String newcopynum = String.valueOf(newnum);
                    bookinfo.get(i).setNumOfCopies(newcopynum);
                    Books.fileUpdateBooks(bookinfo);

                    choice = in.next();

                    if (choice.equals("1")) {
//            long visanumb ;  
//            
//                while(true){
//                 System.out.println("enter visa credentials");
//               
//                   try {
//                    visanumb = in.nextLong();
//                } catch (Exception e) {               System.out.println("Incorrect input: an integer is required");
//                }
//                   
//                }
                        boolean continueInput = true;

                        do {
                            try {
                                System.out.print("Enter  visa credentials: ");
                                long visanumb = in.nextLong();

                                continueInput = false;
                            } catch (InputMismatchException ex) {
                                System.out.println("Try again. ("
                                        + "Incorrect input: an integer is required)");
                                in.nextLine(); // discard input 
                            }
                        } while (continueInput);

                        boolean continueInput2 = true;

                        do {
                            try {
                                System.out.print("Enter  visa password: ");
                                long visanumb = in.nextLong();

                                continueInput2 = false;
                            } catch (InputMismatchException ex) {
                                System.out.println("Try again. ("
                                        + "Incorrect input: an integer is required)");
                                in.nextLine(); // discard input 
                            }
                        } while (continueInput2);
                        //  System.out.println("Enter visa password: ");
                        //String t;
                        // t= in.next();

                        System.out.println("Purchase completed!");
                        LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String formattedDate = myDateObj.format(myFormatObj);
                        SoldBookInfo obj = new SoldBookInfo();
                        obj.setID(Loggedin.IDSession);
                        obj.setISBN(ID);
                        obj.setRequestDate(formattedDate);
                        obj.setDueDate(formattedDate);
                        SoldBookInfo.add(obj);

                        fileUpdateSoldBooks(SoldBookInfo);
                    } else if (choice.equals("2")) {
                        System.out.println("You have chose to pay using cash");
                        System.out.println("Enter amount of cash");
                        String t;
                        t = in.next();
                        double cash = Integer.parseInt(t);
                        if (cash < bookinfo.get(i).getPrice()) {
                            System.out.println("not enough cash");

                        } else {
                            cash = cash - bookinfo.get(i).getPrice();
                            System.out.println("Cash back: " + cash);
                            System.out.println("Purchase completed!");
                            LocalDateTime myDateObj = LocalDateTime.now();
                            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            String formattedDate = myDateObj.format(myFormatObj);
                            SoldBookInfo obj = new SoldBookInfo();
                            obj.setID(Loggedin.IDSession);
                            obj.setISBN(ID);
                            obj.setRequestDate(formattedDate);
                            obj.setDueDate(formattedDate);
                            SoldBookInfo.add(obj);
                            fileUpdateSoldBooks(SoldBookInfo);
                        }
                    }

                }
            }
        }
    }

    public static void ReadSoldBooks(ArrayList<SoldBookInfo> list) throws IOException {

        String filepath = null;
        try {
            filepath = "SoldBooks.txt";
        } catch (Exception e) {
        }
        try (FileReader file = new FileReader(filepath)) {
            BufferedReader br = new BufferedReader(file);

            String line;

            while ((line = br.readLine()) != null) {

                SoldBookInfo obj = new SoldBookInfo();

                String[] parts = line.split(" ");

                obj.setISBN(parts[0]);
                obj.setID(parts[1]);
                obj.setRequestDate(parts[2]);
                obj.setDueDate(parts[3]);

                list.add(obj);

            }
        }
    }

    public static void fileUpdateSoldBooks(ArrayList<SoldBookInfo> list) throws IOException {

        String filepath = "SoldBooks.txt";
        try (FileWriter file = new FileWriter(filepath)) {
            for (int i = 0; i < list.size(); ++i) {
                SoldBookInfo userObj = list.get(i);

                String line = userObj.getISBN() + " " + userObj.getID() + " " + userObj.getRequestDate() + " " + userObj.getDueDate();
                file.write(line + "\n");
            }
        }
    }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<sold books info >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public static class SoldBookInfo {

        private String ISBN;
        private String ID;
        private String RequestDate;
        private String DueDate;

        public void setISBN(String pass) {
            this.ISBN = pass;
        }

        public void setID(String n) {
            this.ID = n;
        }

        public void setRequestDate(String n) {
            this.RequestDate = n;
        }

        public void setDueDate(String d) {
            this.DueDate = d;
        }

        public String getISBN() {
            return this.ISBN;
        }

        public String getID() {
            return this.ID;
        }

        public String getRequestDate() {
            return this.RequestDate;
        }

        public String getDueDate() {
            return this.DueDate;
        }

    }

}
