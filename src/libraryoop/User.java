/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static libraryoop.Loggedin.ClearSession;

/**
 *
 * @author youse
 */
public class User {

        public static void ReadUsers(ArrayList<userInfo> list) throws IOException {
             String filepath = "Users.txt";
        
        
     try (FileReader file = new FileReader(filepath)) {
         BufferedReader br = new BufferedReader(file);
         
         String line;
         
         while((line = br.readLine()) != null) {
             
             userInfo obj = new userInfo();
             
             String [] parts = line.split(" ");
             
             obj.setFirstName(parts[0]);
             obj.setLastName(parts[1]);
             obj.setID(parts[2]);
             obj.setAddress(parts[3]);
             obj.setCellPhone(parts[4]);
             obj.setPassword(parts[5]);
             obj.setEmail(parts[6]);
             if(parts[7].equals("true"))
             {
                 obj.setIsBlocked(true);
             }else {
                 obj.setIsBlocked(false);
             }
             
             if(parts[8].equals("true"))
             {
                 obj.setIsadmin(true);
             }else {
                 obj.setIsadmin(false);
             }
             
             // System.out.println("ID:"+obj.getID()+" First name:"+obj.getFirstName()+" Last name:"+obj.getLasttName()
             //        +" Address:"+obj.getAdress()+" Phone:"+obj.getCellPhone()+" Email:"+obj.getEmail()+" Blocked:"+obj.getIsBlocked()+" Admin:"+ obj.getIsadmin());
             list.add(obj);
             
             
         }
     }
    }
    public static void UpdateUsers(ArrayList<userInfo> list) throws IOException {
        
        String filepath = "Users.txt";
        
        
        try (FileWriter file = new FileWriter(filepath)) {
            for(int i = 0; i < list.size(); ++i) {
                userInfo userObj = list.get(i);
                
                String line = userObj.getFirstName() + " " + userObj.getLasttName()+" " + userObj.getID()+" "+userObj.getAdress()
                        +" "+ userObj.getCellPhone()+ " " + userObj.getPassword() +" "+ userObj.getEmail()+" "+userObj.getIsBlocked()+" "+userObj.getIsadmin();
                
                file.write(line + "\n");
                
            }
        }
    }
    public static void SearchUser(String name, ArrayList<userInfo> list) {
        //      o.retriveBooks(usersList);
        for (int i = 0; i < list.size(); ++i) {

            userInfo user = list.get(i);
            while (user.getID().equals(name)) {
                if ((user.getID()).equals(name)) {
                    list.get(i);
                    System.out.println("ID:" + user.getID() + " First name:" + user.getFirstName() + " Last name:" + user.getLasttName()
                            + " Address:" + user.getAdress() + " Phone:" + user.getCellPhone() + " Email:" + user.getEmail() + " Blocked:" + user.getIsBlocked());
                    break;
                }

            }
        }
    }
          public static void run() throws IOException {
        
        ArrayList usersList = new ArrayList<>();
        ReadUsers(usersList);
        UpdateUsers(usersList);
        
    
        //SearchUser("zo", usersList);
  
       }
           static class WindowEventHandler extends WindowAdapter {
  @Override
  public void windowClosing(WindowEvent evt) {
   
      try {
          ClearSession();
      } catch (IOException ex) {
          Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
      }

  }
}


    public static class userInfo implements Serializable {

        private String firstName;
        private String lastName;
        private String ID;
        private String adress;
        private String cellPhone;
        private String email;
        private String password;
        private boolean isBlocked;
        private boolean isadmin;

        public void setPassword(String pass) {
            this.password = pass;
        }

        public void setFirstName(String n) {
            this.firstName = n;
        }

        public void setLastName(String n) {
            this.lastName = n;
        }

        public void setID(String d) {
            this.ID = d;
        }

        public void setAddress(String a) {
            this.adress = a;
        }

        public void setCellPhone(String ph) {
            this.cellPhone = ph;
        }

        public void setEmail(String e) {
            this.email = e;
        }

        public void setIsBlocked(boolean b) {
            this.isBlocked = b;
        }

        public void setIsadmin(boolean isadmin) {
            this.isadmin = isadmin;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLasttName() {
            return this.lastName;
        }

        public String getID() {
            return this.ID;
        }

        public String getAdress() {
            return this.adress;
        }

        public String getCellPhone() {
            return this.cellPhone;
        }

        public String getEmail() {
            return this.email;
        }

        public String getPassword() {
            return this.password;
        }

        public boolean getIsBlocked() {
            return this.isBlocked;
        }

        public boolean getIsadmin() {
            return isadmin;
        }

    }
}
