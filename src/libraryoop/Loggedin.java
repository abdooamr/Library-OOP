/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryoop;

import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import static libraryoop.User.ReadUsers;

/**
 *
 * @author youse
 */
public class Loggedin {

    public static void ClearSession() throws IOException {
        FileWriter fwOb = new FileWriter("Status.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }
    static public String fnameSession= "";
    static public String lnameSession= "";
    static public String IDSession = "";
    public static void ReadStatus(ArrayList<Status> list) throws IOException {

        String filepath = "Status.txt";
        FileReader file = new FileReader(filepath);
        BufferedReader br = new BufferedReader(file);

        String line;

        while ((line = br.readLine()) != null) {

            Status obj = new Status();

            String[] parts = line.split(" ");

            obj.setName(parts[0]);
            obj.setID(parts[1]);
            if (parts[2].equals("true")) {
                obj.setstatus(true);
            } else {
                obj.setstatus(false);
            }
           // System.out.println("ID:" + obj.getID() + " First name:" + obj.getName() + " Logged:" + obj.getstatus());

            list.add(obj);

        }

        file.close();
    }

    public static void ADDSTATS(String Name, String ID, boolean Status) throws FileNotFoundException, IOException {
        ArrayList statsarr = new ArrayList<>();

        Status obj = new Status();

        obj.setName(Name);
        obj.setID(ID);
        obj.setstatus(Status);
        statsarr.add(obj);
        UpdateStatus(statsarr);
        LoggedinInfo();
    }

    public static void UpdateStatus(ArrayList<Status> statsarr) throws IOException {

        String filepath = "Status.txt";

        FileWriter file = new FileWriter(filepath);

        for (int i = 0; i < statsarr.size(); ++i) {
            Status userObj = statsarr.get(i);

            String line = userObj.getName() + " " + userObj.getID() + " " + userObj.getstatus();
          //  System.out.println("OKID:" + userObj.getID() + " First name:" + userObj.getName() + " Logged:" + userObj.getstatus());
            file.write(line + "\n");

        }

        file.close();
    }
    public static void LoggedinInfo() throws IOException{
        ArrayList<User.userInfo> userlist = new ArrayList();
     ReadUsers(userlist);
                 ArrayList<Status> statsarr=new ArrayList();
         ReadStatus(statsarr);
         String ID= statsarr.get(0).getID();
        
          for (int i = 0; i < userlist.size(); i++) {
              if (userlist.get(i).getID().equals(ID)) {
                  fnameSession = userlist.get(i).getFirstName();
                  lnameSession = userlist.get(i).getLasttName();
                  IDSession = userlist.get(i).getID();
              }
          }
        
        
    }

    public void run() throws IOException {
        //  ADDSTATS("Ok", "34", false);
        ArrayList statsarr = new ArrayList<>();
        ReadStatus(statsarr);
        System.out.println("11ok");
//        ReadStatus(usersList);

    }

    public static class Status implements Serializable {

        private String Name;

        private String ID;

        private boolean status;

        public void setName(String n) {
            this.Name = n;
        }

        public void setID(String d) {
            this.ID = d;
        }

        public void setstatus(boolean b) {
            this.status = b;
        }

        public String getName() {
            return this.Name;
        }

        public String getID() {
            return this.ID;
        }

        public boolean getstatus() {
            return this.status;
        }

    }

}
