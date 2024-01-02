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
import libraryoop.User.userInfo;

/**
 *
 * @author youse
 */
public class UserSettings {

    public void adminrun() throws IOException, InterruptedException {

        Librarians l = new Librarians();
        ArrayList userInfo = new ArrayList<>();
        User u = new User();
        u.ReadUsers(userInfo);
        int choice = 0;

        while (true) {
            System.out.println("-------------------Administrator user control panel----------------------------");
            System.out.println("If you want to add User Press 1 ");
            System.out.println("To access User Info Modifier Press 2");
            System.out.println("To go Back to main Menu Press 3");
            System.out.println("-------------------------------------------------------------------------------");

            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            String t;
            if (choice == 1) {

                userInfo obj = new userInfo();

                System.out.print("Enter your First Name: ");
                t = in.next();
                obj.setFirstName(t);
                System.out.print("Enter your Last Name: ");
                t = in.next();
                obj.setLastName(t);
                System.out.print("Enter your ID: ");
                t = in.next();
                obj.setID(t);
                System.out.print("Enter your Address: ");
                t = in.next();
                obj.setAddress(t);
                System.out.print("Enter your CellPhone: ");
                t = in.next();
                obj.setCellPhone(t);
                System.out.print("Enter your Password: ");
                t = in.next();
                obj.setPassword(t);
                System.out.print("Enter your Email: ");
                t = in.next();
                obj.setEmail(t);
                System.out.println("Do you want him as Admin? Press 1 for Yes\t 2 For No");
                t = in.next();
                if(t.equals("1")){
                    obj.setIsadmin(true);
                }else if(t.equals("2")){
                    obj.setIsadmin(false);
                }
                obj.setIsBlocked(false);

                userInfo.add(obj); /// adding every user at the array list;
                u.UpdateUsers(userInfo);
                }
            /*------------------------------------MENU <User Info editor>-------------------------------------------------*/
                else if (choice == 2) {
                System.out.println("If you want to Edit Your First Name Press 1, \nOr Last Name Press 2 ");
                System.out.println("Or Address press 3 \nOr Cell Phone number press 4");
                System.out.println("Or Password Press 5 \nOr Email Address Press 6");
                try {
                    choice = in.nextInt();
                } catch (Exception e) {
                }
                if (choice == 1) {
                    String ID, FirstName;
                    System.out.println("enter user ID");
                    ID = in.next();
                    System.out.println("Enter new First name");
                    FirstName = in.next();
                    EditUserFirstName(ID, userInfo, FirstName);
                    u.UpdateUsers(userInfo);
                    System.out.println("Redirecting back to User Settings..");
                    TimeUnit.SECONDS.sleep(2);
                }
                if (choice == 2) {
                    String ID, LastName;
                    System.out.println("enter user ID");
                    ID = in.next();
                    System.out.println("Enter new Last name");
                    LastName = in.next();
                    EditUserLastName(ID, userInfo, LastName);
                    u.UpdateUsers(userInfo);
                    System.out.println("Redirecting back to User Settings..");
                    TimeUnit.SECONDS.sleep(2);
                }
                if (choice == 3) {
                    String ID, Address;
                    System.out.println("enter user ID");
                    ID = in.next();
                    System.out.println("Enter new Address");
                    Address = in.next();
                    EditUserAddress(ID, userInfo, Address);
                    u.UpdateUsers(userInfo);
                    System.out.println("Redirecting back to User Settings..");
                    TimeUnit.SECONDS.sleep(2);
                }
                if (choice == 4) {
                    String ID, CellPhone;
                    System.out.println("enter user ID");
                    ID = in.next();
                    System.out.println("Enter new Cell Phone");
                    CellPhone = in.next();
                    EditUserCellPhone(ID, userInfo, CellPhone);
                    u.UpdateUsers(userInfo);
                    System.out.println("Redirecting back to User Settings..");
                    TimeUnit.SECONDS.sleep(2);
                }
                if (choice == 5) {
                    String ID, Password;
                    System.out.println("enter user ID");
                    ID = in.next();
                    System.out.println("Enter new Password");
                    Password = in.next();
                    EditUserPassword(ID, userInfo, Password);
                    u.UpdateUsers(userInfo);
                    System.out.println("Redirecting back to User Settings..");
                    TimeUnit.SECONDS.sleep(2);
                }
                if (choice == 6) {
                    String ID;
                    String Email;
                    System.out.println("enter user ID");
                    ID = in.next();
                    System.out.println("Enter new Email");
                    Email = in.next();
                    EditUserEmail(ID, userInfo, Email);
                    u.UpdateUsers(userInfo);
                    System.out.println("Redirecting back to User Settings..");
                    TimeUnit.SECONDS.sleep(2);
                }
            /*------------------------------------------------------------------------------------------------*/
            } else if (choice == 3) {
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
    public void EditUserFirstName(String id, ArrayList<User.userInfo> list, String NewFname) {

        for (int i = 0; i < list.size(); ++i) {

            User.userInfo obj = list.get(i);

            if (obj.getID().equals(id)) {
                obj.setFirstName(NewFname);
                System.out.println("Your first name has been updated to " + NewFname + "!");

            }

        }
    }

    public void EditUserLastName(String id, ArrayList<User.userInfo> list, String newLName) {

        for (int i = 0; i < list.size(); ++i) {

            User.userInfo obj = list.get(i);

            if (obj.getID().equals(id)) {
                obj.setLastName(newLName);
                System.out.println("Your last name has been updated to " + newLName + "!");

            }
        }
    }

    public void EditUserAddress(String id, ArrayList<User.userInfo> list, String newAddress) {

        for (int i = 0; i < list.size(); ++i) {

            User.userInfo obj = list.get(i);

            if (obj.getID().equals(id)) {
                obj.setAddress(newAddress);
                System.out.println("Your Address has been updated to " + newAddress + "!");

            }
        }
    }

    public void EditUserCellPhone(String id, ArrayList<User.userInfo> list, String newPhone) {

        for (int i = 0; i < list.size(); ++i) {

            User.userInfo obj = list.get(i);

            if (obj.getID().equals(id)) {
                obj.setCellPhone(newPhone);
                System.out.println("Your Cell phone has been updated to " + newPhone + "!");

            }
        }
    }

    public void EditUserPassword(String id, ArrayList<User.userInfo> list, String newPassword) {

        for (int i = 0; i < list.size(); ++i) {

            User.userInfo obj = list.get(i);

            if (obj.getID().equals(id)) {
                obj.setPassword(newPassword);
                System.out.println("Your password has been changed to " + newPassword + "!");

            }
        }
    }

    public void EditUserEmail(String id, ArrayList<User.userInfo> list, String newMail) {

        for (int i = 0; i < list.size(); ++i) {

            User.userInfo obj = list.get(i);

            if (obj.getID().equals(id)) {
                obj.setEmail(newMail);
                System.out.println("Your email has been updated to " + newMail + "!");

            }
        }
    }


}
