/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static libraryoop.User.ReadUsers;
import libraryoop.User.userInfo;

/**
 *
 * @author youse
 */
public class LoginMenu {

    static void LoginMenu() throws IOException, InterruptedException {
        LoginMenu x = new LoginMenu();
        x.MenuLogin();

    }

    public static boolean found;

    /*-------------------------Menu Choose Admin/User------------------------------------------*/
    private void MenuLogin() throws IOException, InterruptedException {

        String[] role = {"Admin", "User"};
        System.out.println("Welcome to library management system");

        Scanner input = new Scanner(System.in);
        String choice = "";

        int roler;
        while (found == false) {
            System.out.println(" To login As Admin press 1\n To login as User press 2\n To Exit press 3");
            try {
                choice = input.next();
            } catch (Exception e) {
            }
            if (choice.equals("1")) {
                Clearconsle();
                System.out.println("You've chosen to login as " + role[0]);
                //TimeUnit.MILLISECONDS.sleep(700);

                AdminLogin();
                if (found == true) {
                    break;
                }
            } else if (choice.equals("2")) {
                Clearconsle();
                System.out.println("You've chosen to login as " + role[1]);

                TimeUnit.MILLISECONDS.sleep(700);
                if (found == true) {
                    break;
                }
                UserLogin();

            } else if (choice.equals("3")) {
                System.out.println("Good Bye!");
                break;
            }
        }
    }

    /*--------------------------CLEARING-CONSOLE------------------------------*/
    public static void Clearconsle() {
        for (int i = 0; i < 10; ++i) {
            System.out.println();
        }
    }

    /*---------------------------------------------------------------------------*/
 /*------------------------- USER LOGIN ------------------------------------------*/
    private boolean UserLogin() throws IOException, InterruptedException {
        User x = new User();
        Loggedin session = new Loggedin();
        x.run();
        ArrayList<User.userInfo> userlist = new ArrayList();
        String ID, Pass;
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your ID");
        ID = input.next();
        System.out.println("Please enter your Password");
        Pass = input.next();
        ReadUsers(userlist);

        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getID().equals(ID) && userlist.get(i).getPassword().equals(Pass) && userlist.get(i).getIsadmin() == false) {
                if (userlist.get(i).getIsBlocked() == true) {
                    System.out.println("You're blocked please contact Librarians regarding this!");
                } else {
                    System.out.println("Login successfully");
                    TimeUnit.MILLISECONDS.sleep(700);
                    Clearconsle();

                    //  System.out.println("Welcome "+userlist.get(i).getFirstName());                
                    session.ADDSTATS(Pass, ID, true);
                    Readers r = new Readers();
                    r.run();
                    found = true;

                    break;
                }
            }

        }
        if (!found) {
            System.out.println("Login Failed");
            TimeUnit.MILLISECONDS.sleep(2000);
            Clearconsle();
            found = false;

        }
        return found;
    }

    /*---------------------------------------------------------------------------*/
 /*------------------------- ADMIN LOGIN ------------------------------------------*/
    private boolean AdminLogin() throws IOException, InterruptedException {
        User x = new User();
        Loggedin session = new Loggedin();
        x.run();
        ArrayList<User.userInfo> userlist = new ArrayList();
        String ID, Pass;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your ID");
        ID = input.next();
        System.out.println("Please enter your Password");
        Pass = input.next();
        ReadUsers(userlist);

        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getID().equals(ID) && userlist.get(i).getPassword().equals(Pass) && userlist.get(i).getIsadmin() == true) {
                System.out.println("Login successfully");
                TimeUnit.MILLISECONDS.sleep(700);
                Clearconsle();
                // System.out.println("Welcome "+userlist.get(i).getFirstName());
                session.ADDSTATS(Pass, ID, true);

                Librarians l = new Librarians();
               // l.run();
                found = true;
                break;
            }

        }
        if (!found) {
            System.out.println("Login Failed");
            TimeUnit.MILLISECONDS.sleep(700);
            Clearconsle();
            found = false;
        }
        return found;

    }

    /*---------------------------------------------------------------------------*/
 /* public void actionPerformed (ActionEvent ae){
                           ArrayList<User.userInfo> userlist=new ArrayList();
        try {
            ReadUsers(userlist);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(ae.getSource() == b1){
            if(c1.getSelectedItem().equals("Admin")){
                        String ID=id.getText();   
             String Pass =password.getText();
            boolean found=false;
         for(int i=0;i<userlist.size();i++){
             if(userlist.get(i).getID().equals(ID)&&userlist.get(i).getPassword().equals(Pass)&&userlist.get(i).getIsadmin()==true){  
            JOptionPane.showMessageDialog(null,"Login successfully");
                             setVisible(false);
                            // AdminGUI a = new AdminGUI();
                            User x = new User();
             found=true;
             break;
             }
                 
         } 
         if (!found)
                JOptionPane.showMessageDialog(null,"Try again","",JOptionPane.WARNING_MESSAGE);
                        
            }
            else   if(c1.getSelectedItem().equals("User")){
                        String ID=id.getText();   
             String Pass =password.getText();
               boolean found=false;
         for(int i=0;i<userlist.size();i++){
             if(userlist.get(i).getID().equals(ID)&&userlist.get(i).getPassword().equals(Pass)&&userlist.get(i).getIsadmin()==false){  
            JOptionPane.showMessageDialog(null,"Login successfully");
                 try {
                     Loggedin.ADDSTATS(Pass, ID, true);
                 } catch (IOException ex) {
                     Logger.getLogger(LoginMenu.class.getName()).log(Level.SEVERE, null, ex);
                 }
                             setVisible(false);
                             User x = new User();
                 try {
                     x.run();
                     //       User.UserGUI ug =  x.new.UserGUI();
                 } catch (IOException ex) {
                     Logger.getLogger(LoginMenu.class.getName()).log(Level.SEVERE, null, ex);
                 }
                             
             found=true;
             break;
             }
                 
         } 
         if (!found)
                JOptionPane.showMessageDialog(null,"Try again","",JOptionPane.WARNING_MESSAGE);
                        

            }
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            this.setVisible(false);
            //new Signup().setVisible(true);
            
        }
    }*/
}
