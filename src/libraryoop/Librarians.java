/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

/**
 *
 * @author youse
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import jdk.internal.org.objectweb.asm.Handle;
import libraryoop.Books.BookInfo;
import libraryoop.User.userInfo;

public class Librarians {

//    public void run() throws IOException, InterruptedException {
//
//        ArrayList usersList = new ArrayList<>();
//        ArrayList bookinfo = new ArrayList<>();
//        Books b = new Books();
//        User u = new User();
//        b.readBooks(bookinfo);
//        u.ReadUsers(usersList);
//
//        Loggedin ln = new Loggedin();
//
//        System.out.println("[LIBRARIAN] Welcome " + ln.fnameSession + " " + ln.lnameSession + "");
//        String ch;
//        String t;
//
//        while (true) {
//            System.out.println("If you want to access user Settings Press 1, \nOr Book Settings Press 2 ");
//            System.out.println("To remove Student press 3\nTo block user press 4\nTo unBlock user press 5");
//            System.out.println("To view blocked users press 6");
//            System.out.println("To go to Search menu press 7\nTo set user as Admin press 8");
//            System.out.println("To Logout Press 9\nTo Exit press 10");
//            Scanner in = new Scanner(System.in);
//            ch = in.next();
//            if (ch.equals("1")) {
//                LoginMenu.Clearconsle();
//                UserSettings us = new UserSettings();
//                us.adminrun();
//            } else if (ch.equals("2")) {
//                LoginMenu.Clearconsle();
//                BookSettings bs = new BookSettings();
//                bs.run();
//            } else if (ch.equals("3")) {
//                LoginMenu.Clearconsle();
//                System.out.print("Enter user ID to remove: ");
//                t = in.next();
//                deleteUser(t, usersList);
//                u.UpdateUsers(usersList);
//            } else if (ch.equals("4")) {
//                LoginMenu.Clearconsle();
//                System.out.print("Enter user ID to block: ");
//                t = in.next();
//                block(t, usersList);
//                u.UpdateUsers(usersList);
//            } else if (ch.equals("5")) {
//                LoginMenu.Clearconsle();
//                System.out.print("Enter user ID to unblock: ");
//                t = in.next();
//              //  unBlock(t, usersList);
//                u.UpdateUsers(usersList);
//            } else if (ch.equals("6")) {
//                blockedusers(usersList);
//            }
//             else if (ch.equals("7")) {
//                System.out.println("To Search for user press 1\n To search for Book press 2");
//                ch = in.next();
//                if (ch.equals("1")) {
//                    System.out.println("Redirecting to user search menu...");
//                    
//                    Search s = new Search();
//                    s.SearchUser();
//                }
//                else if(ch.equals("2")){
//                    System.out.println("Redirecting to book search menu...");
//                    Search s = new Search();
//                    s.SearchBook();
//                }
//            }
//            else if (ch.equals("8")){
//                System.out.println("Please enter user ID to set as Admin");
//            t = in.next();
//            SetUserAdmin(t,usersList);
//             u.UpdateUsers(usersList);
//            }
//            else if (ch.equals("9")) {
//
//                u.UpdateUsers(usersList);
//                System.out.println("You Have logged out...\tRedirecting back to login menu..");
//                TimeUnit.SECONDS.sleep(1);
//                try {
//                    Loggedin.ClearSession();
//                } catch (IOException ex) {
//                    Logger.getLogger(LibraryOOP.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                LoginMenu.LoginMenu();
//            } else if (ch.equals("10")) {
//                u.UpdateUsers(usersList);
//                System.out.println("Good Bye!");
//                TimeUnit.SECONDS.sleep(1);
//                break;
//            }
////            else if (ch.equals("")){
////                Search s= new Search();
////                s.SearchUser();
////                       
////            }
//
//        }
//    }

    public static void block(String id, ArrayList<userInfo> list) throws IOException {
     //   LoginMenu.Clearconsle();
        for (int i = 0; i < list.size(); ++i) {

            userInfo obj = list.get(i);

            if (obj.getID().equals(id)) {
                if(obj.getIsBlocked()==false){
                obj.setIsBlocked(true);
                System.out.println("User has been blocked!");
                JOptionPane.showMessageDialog(null, "User has been blocked!");
                User.UpdateUsers(list);
                }else
                {
                  obj.setIsBlocked(false);  
                  System.out.println("User has been unblocked!");
                  JOptionPane.showMessageDialog(null, "User has been unblocked!");
                  User.UpdateUsers(list);
                }
            }

        }

    }

//    public void unBlock(String id, ArrayList<userInfo> list) throws IOException {
//        LoginMenu.Clearconsle();
//        for (int i = 0; i < list.size(); ++i) {
//
//            userInfo obj = list.get(i);
//
//            if (obj.getID().equals(id)) {
//                obj.setIsBlocked(false);
//                System.out.println("User has been unblocked!");
//            }
//
//        }
//
//    }

    public void deleteUser(String id, ArrayList<userInfo> list) throws IOException {
        LoginMenu.Clearconsle();
        for (int i = 0; i < list.size(); ++i) {

            userInfo obj = list.get(i);
            if ((obj.getID()).equals(id)) {
                list.remove(i);
                System.out.println("User removed succefully!");
                break;

            }
        }

    }

    public void blockedusers(ArrayList<userInfo> list) throws IOException {

        LoginMenu.Clearconsle();
        //      o.retriveBooks(usersList);
        for (int i = 0; i < list.size(); ++i) {

            userInfo user = list.get(i);
            while (user.getIsBlocked() == true) {
                if (user.getIsBlocked() == true) {
                    list.get(i);
                    System.out.println("ID:" + user.getID() + " First name:" + user.getFirstName() + " Last name:" + user.getLasttName()
                            + " Address:" + user.getAdress() + " Phone:" + user.getCellPhone() + " Email:" + user.getEmail() + " Blocked:" + user.getIsBlocked());
                    break;
                }

            }
        }
        System.out.println("To return to Menu Type anything");
        Scanner in = new Scanner(System.in);
        in.next();

    }
        public void SetUserAdmin(String id, ArrayList<User.userInfo> list) throws InterruptedException {
            LoginMenu.Clearconsle();
        for (int i = 0; i < list.size(); ++i) {

            User.userInfo obj = list.get(i);

            if (obj.getID().equals(id)) {
                obj.setIsadmin(true);
                System.out.println("User has been promoted to admin!");
                TimeUnit.SECONDS.sleep(2);
                

            }
        }
    }
}
