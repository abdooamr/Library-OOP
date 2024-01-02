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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author youse
 */
public class Borrow {
    
       public static void run() throws IOException {
       
               ArrayList<Books.BookInfo> bookinfo = new ArrayList();
                ArrayList<RentedBookInfo> RentedBookInfo = new ArrayList();
               ReadRentedBooks(RentedBookInfo);
        Books b = new Books();
        b.readBooks(bookinfo);
        System.out.println("To rent book enter book ISBN");
        String ID;
        Scanner in = new Scanner(System.in);
        ID = in.next();
        
        //int ISBN= Integer.parseInt(ID);
        
                for (int i = 0; i < bookinfo.size(); ++i) {

            Books.BookInfo obj1 = bookinfo.get(i);
            if ((obj1.getISBN()).equals(ID)) {
                bookinfo.get(i);
                int num1 = Integer.parseInt(bookinfo.get(i).getNumOfCopies());
                if (num1 <= 1) {
                    System.out.println("there's no copy left to rent");
                    break;
                } else {
                    System.out.println("You have rented the book for 14 days make sure to return it before Due date to avoid getting blocked!");
                    int num = Integer.parseInt(bookinfo.get(i).getNumOfCopies());
                    int newnum = num - 1;
                    String newcopynum = String.valueOf(newnum);
                    bookinfo.get(i).setNumOfCopies(newcopynum);
                    Books.fileUpdateBooks(bookinfo);
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	//Getting current date
	Calendar cal = Calendar.getInstance();
	//Displaying current date in the desired format
	//System.out.println("Current Date: "+sdf.format(cal.getTime()));
	   
	//Number of Days to add

	//Displaying the new Date after addition of Days to current date

                                    RentedBookInfo obj = new RentedBookInfo();
                            obj.setID(Loggedin.IDSession);
                            obj.setISBN(ID);
                            obj.setRequestDate(sdf.format(cal.getTime()));
                            cal.add(Calendar.DAY_OF_MONTH, 7);  
                            String newDate = sdf.format(cal.getTime());  
                            obj.setDueDate(newDate);
                            RentedBookInfo.add(obj);
                            fileUpdateRentedBooks(RentedBookInfo);
                }}}
        
        
       }
        public static void ReturnBook(String id, ArrayList<RentedBookInfo> list) {

        for (int i = 0; i < list.size(); ++i) {

            RentedBookInfo obj = list.get(i);
            if ((obj.getISBN()).equals(id)) {
                list.remove(i);
                System.out.println("Book returned succefully!");
                JOptionPane.showMessageDialog(null, "Book returned succefully!");
                
                break;
            }
        }

    }
     public static void ReadRentedBooks(ArrayList<RentedBookInfo> list) throws IOException {

            String filepath = null;
        try {
            filepath = "RentedBooks.txt";
        } catch (Exception e) {
        }
        try (FileReader file = new FileReader(filepath)) {
            BufferedReader br = new BufferedReader(file);

            String line;

            while ((line = br.readLine()) != null) {

                RentedBookInfo obj = new RentedBookInfo();

                String[] parts = line.split(" ");

                obj.setISBN(parts[0]);
                obj.setID(parts[1]);
                obj.setRequestDate(parts[2]);
                obj.setDueDate(parts[3]);

                list.add(obj);
               

            }
            // System.out.println("Done");
        }
    }

    public static void fileUpdateRentedBooks(ArrayList<RentedBookInfo> list) throws IOException {

String filepath = "RentedBooks.txt";
        try (FileWriter file = new FileWriter(filepath)) {
            for (int i = 0; i < list.size(); ++i) {
                RentedBookInfo userObj = list.get(i);

                String line = userObj.getISBN() + " " + userObj.getID() + " " + userObj.getRequestDate() + " " + userObj.getDueDate();
                file.write(line + "\n");
            }
        }
    }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<sold books info >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public static class RentedBookInfo {

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

