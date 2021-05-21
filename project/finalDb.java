import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.TextField;  
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import java.awt.BorderLayout;
import javafx.scene.control.ToggleGroup;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;  

public class finalDb extends Application {
   
  
   int index = 1;
   int count = 0;
   
   public void start(Stage primaryStage) throws Exception{
      
      //titel label and text box
      Label title = new Label("Title:");
      TextField titles = new TextField();
      Label titlelab = new Label("");
      
      
      //first name lable and text box
      Label fname = new Label("First Name:");
      TextField fnames = new TextField();
      Label fnamelab = new Label("");
      
      
      //last name lable and text box
      Label lname = new Label("Last Name:");
      TextField lnames = new TextField();
      Label lnamelab = new Label("");
      
      
      //firt address lable and text box
      Label address1 = new Label("Street Address 1:");
      TextField addresses1 = new TextField();
      Label address1lab = new Label("");
      
      //second address lable and text box
      Label address2 = new Label("Street Address 2:");
      TextField addresses2 = new TextField();
      Label address2lab = new Label("");
      
      //City lable and text box
      Label city = new Label("City:");
      TextField cities = new TextField();
      Label citylab = new Label("");
      
      //state label
      Label state = new Label("State:");
      TextField states = new TextField();
      Label statelab = new Label("");
      
      
      //zip lable and text box
      Label zip = new Label("Zip:");
      TextField zips = new TextField();
      Label ziplab = new Label("");
      
      
      //phone lable and text box
      Label phone = new Label("Phone:");
      TextField phones = new TextField();
      Label phonelab = new Label("");
      
      
      //Email lable and text box
      Label email = new Label("Email:");
      TextField emails = new TextField();
      Label emaillab = new Label("");
      
      
      //date lable and text box
      Label date = new Label("date:");
      TextField dates = new TextField();
      Label datelab = new Label("");
      
      
      //submit and clear button
      Button submit = new Button("Submit");
      Button clear = new Button("Clear");
      
      RadioButton active = new RadioButton("Active");
      
     
      
      
      Label data = new Label(" ");
      Label space = new Label("                   ");
      
      Button first = new Button("<<");
      Button onebefore = new Button("<");
      Label records = new Label("");
      Button next = new Button(">");
      Button last = new Button(">>");
      Button add = new Button("+");
      
      HBox buttons = new HBox(first,onebefore,records,next,last,add);
      
      first.setVisible(false);
      onebefore.setVisible(false);
      records.setVisible(false);
      next.setVisible(false);
      last.setVisible(false);
      add.setVisible(false);
      
      
      
      //buttons to go through out th
      
      GridPane grid = new GridPane();
      
      grid.add(space,0,0,1,1);
      grid.add(buttons,4,13,1,1);
      
      grid.add(title,1,0,1,1);
      grid.add(titles,2,0,1,1);
      grid.add(titlelab,2,0,1,1);
      
      grid.add(fname,1,1,1,1);
      grid.add(fnames,2,1,1,1);
      grid.add(fnamelab,2,1,1,1);
      
      grid.add(lname,1,2,1,1);
      grid.add(lnames,2,2,1,1);
      grid.add(lnamelab,2,2,1,1);
      
      grid.add(address1,1,3,1,1);
      grid.add(addresses1,2,3,1,1);
      grid.add(address1lab,2,3,1,1);
      
      grid.add(address2,1,4,1,1);
      grid.add(addresses2,2,4,1,1);
      grid.add(address2lab,2,4,1,1);
      
      grid.add(city,1,5,1,1);
      grid.add(cities,2,5,1,1);
      grid.add(citylab,2,5,1,1);
      
      grid.add(state,1,6,1,1);
      grid.add(states,2,6,1,1);
      grid.add(statelab,2,6,1,1);
      
      grid.add(zip,1,7,1,1);
      grid.add(zips,2,7,1,1);
      grid.add(ziplab,2,7,1,1);
      
      grid.add(phone,1,8,1,1);
      grid.add(phones,2,8,1,1);
      grid.add(phonelab,2,8,1,1);
      
      grid.add(email,1,9,1,1);
      grid.add(emails,2,9,1,1);
      grid.add(emaillab,2,9,1,1);
      
      grid.add(date,1,10,1,1);
      grid.add(dates,2,10,1,1);
      grid.add(datelab,2,10,1,1);
      
      grid.add(clear,1,12,1,1);
      grid.add(submit,2,12,1,1);
       
      grid.add(active,1,11,1,1);
      
      
      grid.add(data,2,13,1,1);
      
      grid.setHgap(10);
      grid.setVgap(10);
      
      
      
      submit.setOnAction((event)-> {
         boolean act = false;
         if(active.isSelected()==false){
            act=false;
         }
         else{
            act=true;
         }
         //get all of the inputs
         String inputtitle=titles.getText();
         String inputfname=fnames.getText();
         String inputlname=lnames.getText();
         String inputaddress1=addresses1.getText();
         String inputaddress2=addresses2.getText();
         String inputcity=cities.getText();
         String inputzip=zips.getText();
         String inputphone=phones.getText();
         String inputemail=emails.getText();
         String inputdate=dates.getText();
         String inputstate=states.getText();
         
         //make sure all the required inputs are there
         if(inputtitle.equals(""))
         {
            data.setText("a title was not entered");
         }
         else if(inputfname.equals(""))
         {
            data.setText("first name was not entered");
         }
         else if(inputlname.equals(""))
         {
            data.setText("last name was not entered");
         }
         else if(inputaddress1.equals(""))
         {
            data.setText("an address was not entered");
         }
         else if(inputcity.equals(""))
         {
            data.setText("a city was not entered");
         }
         else if(inputstate.equals(""))
         {
            data.setText("a state was not entered");
         }
         else if(inputstate.length()!=2)
         {
            data.setText("enter a state in the XX format");
         }
         else if(inputzip.equals(""))
         {
            data.setText("a zip code was not entered");
         }
         else if(inputphone.equals(""))
         {
            data.setText("a phone number was not entered");
         }
         //check if the phone number is in the right phone number  goes here
         else if(inputphone.indexOf('-')!=3 || inputphone.length()!=12)
         {
            data.setText("enter a phone number in \nthe ###-###-#### format");
         }
         else if(inputemail.equals(""))
         {
            data.setText("an email was not entered");
         }
         else if(inputdate.equals(""))
         {
            data.setText("a date was not entered");
         }
         //check if data is in the right format  goes here
         else if(inputdate.indexOf("/")!=2 || inputdate.length()!=10)
         {
            data.setText("enter a date in the \nmm/dd/yyyy format");
         }
         
         
         else
         {
            data.setText("the data has been entered\ninto the database\npress + to sumbit more");
            submit.setVisible(false);
            
            try{
                final String DB_URL = "jdbc:sqlite:finaldb.sqlite";
                Connection conn= DriverManager.getConnection(DB_URL);
                Statement stmt = conn.createStatement();
            
               String sql=" INSERT INTO Credentials " + "(Title, FirstName, LastName, FirstAddress, SecondAddress, City, State, Zip, Phone, Email, Date, Active)"+"VALUES ('"+inputtitle+"','"+inputfname+"','"+inputlname+"','"+inputaddress1+"','"+inputaddress2+"','"+inputcity+"','"+inputstate+"','"+inputzip+"','"+inputphone+"','"+inputemail+"','"+inputdate+"','"+act+"')";
               stmt.executeUpdate(sql);
               
               count++;
                              
               records.setText(index+" of "+count);
               
               
               titlelab.setText(inputtitle);
               fnamelab.setText(inputfname);
               lnamelab.setText(inputlname);
               address1lab.setText(inputaddress1);
               address2lab.setText(inputaddress2);
               citylab.setText(inputcity);
               ziplab.setText(inputzip);
               phonelab.setText(inputphone);
               emaillab.setText(inputemail);
               datelab.setText(inputdate);
               statelab.setText(inputstate);
               
               titles.clear();
               fnames.clear();
               lnames.clear();
               addresses1.clear();
               addresses2.clear();
               cities.clear();
               zips.clear();
               phones.clear();
               emails.clear();
               dates.clear();
               states.clear();
               active.setSelected(false);
               active.setVisible(false);
               submit.setVisible(false);
               clear.setVisible(false);
               
               titles.setVisible(false);
               fnames.setVisible(false);
               lnames.setVisible(false);
               addresses1.setVisible(false);
               addresses2.setVisible(false);
               cities.setVisible(false);
               zips.setVisible(false);
               phones.setVisible(false);
               emails.setVisible(false);
               dates.setVisible(false);
               states.setVisible(false);
               
               first.setVisible(true);
               onebefore.setVisible(true);
               records.setVisible(true);
               next.setVisible(true);
               last.setVisible(true);
               add.setVisible(true);
               
              
               
            }
            catch(Exception ex){
               System.out.println("ERROR: " + ex.getMessage());
            }
   
         }
                          
      });
      
      add.setOnAction((event)->{
         titles.clear();
         fnames.clear();
         lnames.clear();
         addresses1.clear();
         addresses2.clear();
         cities.clear();
         zips.clear();
         phones.clear();
         emails.clear();
         dates.clear();
         states.clear();
         active.setSelected(false);
         submit.setVisible(true);
         clear.setVisible(true);
         active.setVisible(true);
         
         titlelab.setText("");
         fnamelab.setText("");
         lnamelab.setText("");
         address1lab.setText("");
         address2lab.setText("");
         citylab.setText("");
         ziplab.setText("");
         phonelab.setText("");
         emaillab.setText("");
         datelab.setText("");
         statelab.setText("");
         
         titles.setVisible(true);
         fnames.setVisible(true);
         lnames.setVisible(true);
         addresses1.setVisible(true);
         addresses2.setVisible(true);
         cities.setVisible(true);
         zips.setVisible(true);
         phones.setVisible(true);
         emails.setVisible(true);
         dates.setVisible(true);
         states.setVisible(true);
         
         first.setVisible(false);
         onebefore.setVisible(false);
         records.setVisible(false);
         next.setVisible(false);
         last.setVisible(false);
         add.setVisible(false);
         
         data.setText("");
      });
      //if the next button is hit
      next.setOnAction((event)->{
         
         if(index<count)
         {
            index++;
         }
         else
         {
            index=index;
         }
         
         records.setText(index+" of "+count);
         System.out.println(index);
         
         
         try{
            String findtitle="";
            String findfname="";
            String findlname="";
            String findaddress1="";
            String findaddress2="";
            String findcity="";
            String findzip="";
            String findphone="";
            String findemail="";
            String finddate="";
            String findstate="";
            
            final String DB_URL = "jdbc:sqlite:finaldb.sqlite";
            Connection conn= DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT * from Credentials where rowid = "+index;
            stmt.executeUpdate(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
               findtitle=rs.getString("Title");
               findfname=rs.getString("FirstName");
               findlname=rs.getString("LastName");
               findaddress1=rs.getString("FirstAddress");
               findaddress2=rs.getString("SecondAddress");
               findcity=rs.getString("City");
               findstate=rs.getString("State");
               findzip=rs.getString("Zip");
               findphone=rs.getString("Phone");
               findemail=rs.getString("Email");
               finddate=rs.getString("Date");
               
               titles.setVisible(false);
               fnames.setVisible(false);
               lnames.setVisible(false);
               addresses1.setVisible(false);
               addresses2.setVisible(false);
               cities.setVisible(false);
               zips.setVisible(false);
               phones.setVisible(false);
               emails.setVisible(false);
               dates.setVisible(false);
               states.setVisible(false);
               
               titlelab.setText(findtitle);
               fnamelab.setText(findfname);
               lnamelab.setText(findlname);
               address1lab.setText(findaddress1);
               address2lab.setText(findaddress2);
               citylab.setText(findcity);
               ziplab.setText(findzip);
               phonelab.setText(findphone);
               emaillab.setText(findemail);
               datelab.setText(finddate);
               statelab.setText(findstate);
               
               
            }
         }
         catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
         }
      
      });
      
      
      
      last.setOnAction((event)->{
         
         index=count;
         
         records.setText(index+" of "+count);
         System.out.println(index);
         
         
         try{
            String findtitle="";
            String findfname="";
            String findlname="";
            String findaddress1="";
            String findaddress2="";
            String findcity="";
            String findzip="";
            String findphone="";
            String findemail="";
            String finddate="";
            String findstate="";
            
            final String DB_URL = "jdbc:sqlite:finaldb.sqlite";
            Connection conn= DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT * from Credentials where rowid = "+index;
            stmt.executeUpdate(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
               findtitle=rs.getString("Title");
               findfname=rs.getString("FirstName");
               findlname=rs.getString("LastName");
               findaddress1=rs.getString("FirstAddress");
               findaddress2=rs.getString("SecondAddress");
               findcity=rs.getString("City");
               findstate=rs.getString("State");
               findzip=rs.getString("Zip");
               findphone=rs.getString("Phone");
               findemail=rs.getString("Email");
               finddate=rs.getString("Date");
               
               titles.setVisible(false);
               fnames.setVisible(false);
               lnames.setVisible(false);
               addresses1.setVisible(false);
               addresses2.setVisible(false);
               cities.setVisible(false);
               zips.setVisible(false);
               phones.setVisible(false);
               emails.setVisible(false);
               dates.setVisible(false);
               states.setVisible(false);
               
               titlelab.setText(findtitle);
               fnamelab.setText(findfname);
               lnamelab.setText(findlname);
               address1lab.setText(findaddress1);
               address2lab.setText(findaddress2);
               citylab.setText(findcity);
               ziplab.setText(findzip);
               phonelab.setText(findphone);
               emaillab.setText(findemail);
               datelab.setText(finddate);
               statelab.setText(findstate);
               
               
            }
         }
         catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
         }
      
      });
      
      
      first.setOnAction((event)->{
         
         index=1;
         
         records.setText(index+" of "+count);
         System.out.println(index);
         
         
         try{
            String findtitle="";
            String findfname="";
            String findlname="";
            String findaddress1="";
            String findaddress2="";
            String findcity="";
            String findzip="";
            String findphone="";
            String findemail="";
            String finddate="";
            String findstate="";
            
            final String DB_URL = "jdbc:sqlite:finaldb.sqlite";
            Connection conn= DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT * from Credentials where rowid = "+index;
            stmt.executeUpdate(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
               findtitle=rs.getString("Title");
               findfname=rs.getString("FirstName");
               findlname=rs.getString("LastName");
               findaddress1=rs.getString("FirstAddress");
               findaddress2=rs.getString("SecondAddress");
               findcity=rs.getString("City");
               findstate=rs.getString("State");
               findzip=rs.getString("Zip");
               findphone=rs.getString("Phone");
               findemail=rs.getString("Email");
               finddate=rs.getString("Date");
               
               titles.setVisible(false);
               fnames.setVisible(false);
               lnames.setVisible(false);
               addresses1.setVisible(false);
               addresses2.setVisible(false);
               cities.setVisible(false);
               zips.setVisible(false);
               phones.setVisible(false);
               emails.setVisible(false);
               dates.setVisible(false);
               states.setVisible(false);
               
               titlelab.setText(findtitle);
               fnamelab.setText(findfname);
               lnamelab.setText(findlname);
               address1lab.setText(findaddress1);
               address2lab.setText(findaddress2);
               citylab.setText(findcity);
               ziplab.setText(findzip);
               phonelab.setText(findphone);
               emaillab.setText(findemail);
               datelab.setText(finddate);
               statelab.setText(findstate);
               
               
            }
         }
         catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
         }
      
      });
      
      
      
      
      
      // if the one before button is pressed
      onebefore.setOnAction((event)->{
         
         if(index>=1)
         {
            index--;
         }
         else
         {
            index=index;
         }
         
         records.setText(index+" of "+count);
         
           try{
            String findtitle="";
            String findfname="";
            String findlname="";
            String findaddress1="";
            String findaddress2="";
            String findcity="";
            String findzip="";
            String findphone="";
            String findemail="";
            String finddate="";
            String findstate="";
            
            final String DB_URL = "jdbc:sqlite:finaldb.sqlite";
            Connection conn= DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT * from Credentials where rowid = "+index;
            stmt.executeUpdate(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
               findtitle=rs.getString("Title");
               findfname=rs.getString("FirstName");
               findlname=rs.getString("LastName");
               findaddress1=rs.getString("FirstAddress");
               findaddress2=rs.getString("SecondAddress");
               findcity=rs.getString("City");
               findstate=rs.getString("State");
               findzip=rs.getString("Zip");
               findphone=rs.getString("Phone");
               findemail=rs.getString("Email");
               finddate=rs.getString("Date");
               
               titles.setVisible(false);
               fnames.setVisible(false);
               lnames.setVisible(false);
               addresses1.setVisible(false);
               addresses2.setVisible(false);
               cities.setVisible(false);
               zips.setVisible(false);
               phones.setVisible(false);
               emails.setVisible(false);
               dates.setVisible(false);
               states.setVisible(false);
               
               titlelab.setText(findtitle);
               fnamelab.setText(findfname);
               lnamelab.setText(findlname);
               address1lab.setText(findaddress1);
               address2lab.setText(findaddress2);
               citylab.setText(findcity);
               ziplab.setText(findzip);
               phonelab.setText(findphone);
               emaillab.setText(findemail);
               datelab.setText(finddate);
               statelab.setText(findstate);
               
               
            }
         }
         catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
         }

      
      });
      
      clear.setOnAction((event)-> {
      
         titles.clear();
         fnames.clear();
         lnames.clear();
         addresses1.clear();
         addresses2.clear();
         cities.clear();
         zips.clear();
         phones.clear();
         emails.clear();
         dates.clear();
         states.clear();
         active.setSelected(false);
         
         
         data.setText(" ");
         submit.setVisible(true);
      });
      
      
      Scene scene = new Scene(grid, 670, 510);
      primaryStage.setScene(scene);
      primaryStage.show();
      
      
      
   }
   
   public static void main(String[] args) {
      
      Application.launch(args);
               
      
   }

}