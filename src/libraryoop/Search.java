/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author youse
 */
public class Search {

    public void SearchUser() throws IOException, InterruptedException {

        ArrayList userInfo = new ArrayList<>();
        User u = new User();
        u.ReadUsers(userInfo);

        String choice = "";
        Scanner in = new Scanner(System.in);
       
        String t;

        while (true) {
            System.out.println("To search by by first name press 1\nTo search by last name press 2");
            System.out.println("To search by ID press 3\n to search by address press 4");
            System.out.println("To search by cellphone press 5\nTo search by email press 6");
            System.out.println("To Return to previous menu press 7");

             choice = in.next();
            if (choice.equals("1")) {

                System.out.println("Please enter user first name");
                t = in.next();
                SearchUserByFirstName(t, userInfo);
            }
            else if (choice.equals("2")) {
                System.out.println("Please enter user last name");
                t = in.next();
                SearchUserByLastName(t, userInfo);
            }
           else if (choice.equals("3")) {
                System.out.println("Please enter user ID");
                t = in.next();
                SearchUserByID(t, userInfo);
            }
           else if (choice.equals("4")) {
                                System.out.println("Please enter user Address");
                t = in.next();
                SearchUserByAddress(t, userInfo);
            }
           else if (choice.equals("5")) {
                                System.out.println("Please enter user Cellphone");
                t = in.next();
                SearchUserByCellPhone(t, userInfo);
            }
           else if (choice.equals("6")) {
                                System.out.println("Please enter user Email");
                t = in.next();
                SearchUserByEmail(t, userInfo);
            }
            else if(choice.equals("7")){
                System.out.println("Redirecting to Previous menu");
                break;
            }

        }
    }
    
    public void SearchBook() throws IOException, InterruptedException {

        ArrayList bookinfo = new ArrayList<>();
        Books b = new Books();
        b.readBooks(bookinfo);

        String choice = "";

               System.out.println("To search by by genre press 1\nTo search by title press 2");
            System.out.println("To search by Author press 3\n to search by location press 4");
            System.out.println("To search by ID press 5\nTo go back to previous menu press 6");

        String t;

        while (true) {        Scanner in = new Scanner(System.in);
        choice =in.next();
//            System.out.println("To search by by genre press 1\nTo search by title press 2");
//            System.out.println("To search by Author press 3\n to search by location press 4");
//            System.out.println("To search by ID press 5\nTo go back to previous menu press 6");
//                    choice = in.next();
            if (choice.equals("1")) {

                System.out.println("Please enter Genre");
                t = in.next();
                b.SearchByGenre(t, bookinfo);
            }
            else if (choice.equals("2")) {
                System.out.println("Please enter Title");
                t = in.next();
                b.SearchByTitle(t, bookinfo);
            }
           else if (choice.equals("3")) {
                System.out.println("Please enter Author");
                t = in.next();
                b.SearchByAuthor(t, bookinfo);
            }
           else if (choice.equals("4")) {
                                System.out.println("Please enter location");
                t = in.next();
                b.SearchBylocation(t, bookinfo);
            }
           else if (choice.equals("5")) {
                                System.out.println("Please enter user ID");
                t = in.next();
                b.SearchBook(t, bookinfo);
            }
            else if(choice.equals("6")){
                System.out.println("Redirecting to Previous menu");
                break;
            }

        }
    }
    /*----------------------------------------------------------------USER SEARCH FUNCTIONS-------------------------------------------------------------------------------*/
    public static void SearchUserByID(String ID, ArrayList<User.userInfo> list) {
        //      o.retriveBooks(usersList);
        for (int i = 0; i < list.size(); ++i) {

            User.userInfo user = list.get(i);
            while (user.getID().equals(ID)) {
                if ((user.getID()).equals(ID)) {
                    list.get(i);
                    System.out.println("ID:" + user.getID() + " First name:" + user.getFirstName() + " Last name:" + user.getLasttName()
                            + " Address:" + user.getAdress() + " Phone:" + user.getCellPhone() + " Email:" + user.getEmail() + " Blocked:" + user.getIsBlocked());
                    break;
                }

            }
        }
    }

    public static void SearchUserByFirstName(String fname, ArrayList<User.userInfo> list) {
        //      o.retriveBooks(usersList);
        for (int i = 0; i < list.size(); ++i) {

            User.userInfo user = list.get(i);
            while (user.getFirstName().equals(fname)) {
                if ((user.getFirstName()).equals(fname)) {
                    list.get(i);
                    System.out.println("ID:" + user.getID() + " First name:" + user.getFirstName() + " Last name:" + user.getLasttName()
                            + " Address:" + user.getAdress() + " Phone:" + user.getCellPhone() + " Email:" + user.getEmail() + " Blocked:" + user.getIsBlocked());
                    break;
                }

            }
        }
    }

    public static void SearchUserByLastName(String lname, ArrayList<User.userInfo> list) {
        //      o.retriveBooks(usersList);
        for (int i = 0; i < list.size(); ++i) {

            User.userInfo user = list.get(i);
            while (user.getLasttName().equals(lname)) {
                if ((user.getLasttName()).equals(lname)) {
                    list.get(i);
                    System.out.println("ID:" + user.getID() + " First name:" + user.getFirstName() + " Last name:" + user.getLasttName()
                            + " Address:" + user.getAdress() + " Phone:" + user.getCellPhone() + " Email:" + user.getEmail() + " Blocked:" + user.getIsBlocked());
                    break;
                }

            }
        }
    }

    public static void SearchUserByAddress(String address, ArrayList<User.userInfo> list) {
        //      o.retriveBooks(usersList);
        for (int i = 0; i < list.size(); ++i) {

            User.userInfo user = list.get(i);
            while (user.getAdress().equals(address)) {
                if ((user.getAdress()).equals(address)) {
                    list.get(i);
                    System.out.println("ID:" + user.getID() + " First name:" + user.getFirstName() + " Last name:" + user.getLasttName()
                            + " Address:" + user.getAdress() + " Phone:" + user.getCellPhone() + " Email:" + user.getEmail() + " Blocked:" + user.getIsBlocked());
                    break;
                }

            }
        }
    }

    public static void SearchUserByCellPhone(String cellphone, ArrayList<User.userInfo> list) {
        //      o.retriveBooks(usersList);
        for (int i = 0; i < list.size(); ++i) {

            User.userInfo user = list.get(i);
            while (user.getCellPhone().equals(cellphone)) {
                if ((user.getCellPhone()).equals(cellphone)) {
                    list.get(i);
                    System.out.println("ID:" + user.getID() + " First name:" + user.getFirstName() + " Last name:" + user.getLasttName()
                            + " Address:" + user.getAdress() + " Phone:" + user.getCellPhone() + " Email:" + user.getEmail() + " Blocked:" + user.getIsBlocked());
                    break;
                }

            }
        }
    }

    public static void SearchUserByEmail(String email, ArrayList<User.userInfo> list) {
        //      o.retriveBooks(usersList);
        for (int i = 0; i < list.size(); ++i) {

            User.userInfo user = list.get(i);
            while (user.getEmail().equals(email)) {
                if ((user.getEmail()).equals(email)) {
                    list.get(i);
                    System.out.println("ID:" + user.getID() + " First name:" + user.getFirstName() + " Last name:" + user.getLasttName()
                            + " Address:" + user.getAdress() + " Phone:" + user.getCellPhone() + " Email:" + user.getEmail() + " Blocked:" + user.getIsBlocked());
                    break;
                }

            }
        }
    }
    /*---------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------BOOK SEARCH FUNCTIONS-------------------------------------------------------------------------------*/

}
