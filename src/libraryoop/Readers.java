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
public class Readers {
     public void run() throws IOException, InterruptedException {
         
         
         ArrayList<Loggedin.Status> statsarr=new ArrayList();
         Loggedin.ReadStatus(statsarr);
               Loggedin ln = new Loggedin();

         System.out.println("Welcome "+  ln.fnameSession + " " + ln.lnameSession + "");
            while (true) {
         System.out.println("To Navigate to Search Menu Press 1\nTo Buy book press 2");
         System.out.println("To borrow book press 3");
                System.out.println("To go to previous menu press 4");
         String choice = "";
         Scanner input= new Scanner(System.in);
         choice = input.next();
                 if(choice.equals("1")){
                     System.out.println("To Open Search menu for books press 1\nTo Open Search menu for users press 2");
                     choice = input.next();
                     if(choice.equals("1")){
                                          Search s= new Search();
                     s.SearchBook();
                     }
                     else if(choice.equals("2")){
                    String t = null;
                    t =input.next();
                            ArrayList userInfo = new ArrayList<>();
        User u = new User();
        u.ReadUsers(userInfo);
                    Search.SearchUserByFirstName(t,userInfo);
                

         }       
                 
                 else if(choice.equals("2")){
             Purchase p=new Purchase();
             p.run();
         }
                else  if(choice.equals("3")){
             Borrow b=new Borrow();
             b.run();
         }
                }
                else if(choice.equals("4")){
                break;}
            }
         //if(choice)
         
     }
}
