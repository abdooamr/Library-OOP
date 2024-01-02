/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static libraryoop.LoginMenuGUI.LoginMenuGUI;

/**
 *
 * @author youse
 */
public class LibraryOOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
             //UserPanel();
           // new UsersGUI().setVisible(true);
            // new RemoveBookGUI().setVisible(true);
             // new BlockUser().setVisible(true);
           //    new AddBook().setVisible(true);
                   fframe f1 = new fframe();
        f1.setVisible(true);
        int i;
        int x=1;
        for(i=2; i<=900; i+=4, x+=1){
            f1.setLocation(800 - ((i+x)/2), 500 - (i/2));
            f1.setSize(i+x,i);
            try{
                Thread.sleep(4);
                
            }catch(Exception e){}
        }
        
    }
}

class fframe extends JFrame implements Runnable{
    Thread t1;
    fframe(){
        
        super("Library Management System");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icon/lib.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1100, 845,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        
        JLabel l1 = new JLabel(i2);
        add(l1);
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(3500);
            this.setVisible(false);
                //  Logins();
               
              LoginMenuGUI();
            ArrayList<User.userInfo> usersarr=new ArrayList();
            ArrayList<Books.BookInfo> bookarr=new ArrayList();
            User.ReadUsers(usersarr);
            Books.readBooks(bookarr);
            
           // User Login = new User() ;
            
        
          //  UserPanel();
            Loggedin oka = new Loggedin();
            oka.run();
         //   Register x =new Register();
            Books b = new Books();
            b.run();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
        
    //}
        
    //}
//  Runtime.getRuntime().addShutdownHook(new Thread() {
//      public void run() {
//          try {
//              Loggedin.ClearSession();
//          } catch (IOException ex) {
//              Logger.getLogger(LibraryOOP.class.getName()).log(Level.SEVERE, null, ex);
//          }
//        System.out.println("Login session has been cleared!");
//      }
//    });
  
                          //    LocalDateTime myDateObj = LocalDateTime.now();
                        //    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                           // String formattedDate = myDateObj.format(myFormatObj);
//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//	//Getting current date
//	Calendar cal = Calendar.getInstance();
//	//Displaying current date in the desired format
//	System.out.println("Current Date: "+sdf.format(cal.getTime()));
//	   
//	//Number of Days to add
//        cal.add(Calendar.DAY_OF_MONTH, 7);  
//	//Date after adding the days to the current date
//	String newDate = sdf.format(cal.getTime());  
//	//Displaying the new Date after addition of Days to current date
//	System.out.println("Date after Addition: "+newDate);
//        Books b = new Books();
//       b.run();
//
     //  LoginMenu x = new LoginMenu();
      // x.LoginMenu();
//
       // Purchase p = new Purchase();
      //  p.run();
//Search s = new Search();
//s
//ArrayList<Borrow.RentedBookInfo> RentedBookInfo = new ArrayList();
//    Borrow b = new Borrow();
//    b.fileUpdateRentedBooks(RentedBookInfo);
   //Purchase p =new Purchase();
   //p.run();
//        BookSettings bedit = new BookSettings();
//        bedit.run();
//          UserSettings us = new UserSettings();
//          us.adminrun();
     //       Librarians l=new Librarians();
     //       l.run();
        
        
        /* TO BE ADDED READER CLASS
            AND USER FUNCTIONS
             LOGIN SESSION < used inside user functions to buy/rent/return books>
            
            */
        
        
        // TODO code application logic here
        
  // HERE  }
   /*     public void run(){
        try{
            Thread.sleep(3500);

                //  Logins();
              LoginMenu();
            ArrayList<User.userInfo> usersarr=new ArrayList();
            ArrayList<Books.BookInfo> bookarr=new ArrayList();
            User.ReadUsers(usersarr);
            Books.readBooks(bookarr);
            
           // User Login = new User() ;
            
        
          //  UserPanel();
            Loggedin oka = new Loggedin();
            oka.run();
         //   Register x =new Register();
            Books b = new Books();
            b.run();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }*/
    

