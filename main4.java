package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class main4 {

    static ContactManager manager = new ContactManager();



    public static void main(String[] args) {

        try {
            loadContacts("C:\\Users\\aniru\\IdeaProjects\\javanotes\\Names.txt");
            System.out.println("Contact loaded \n\n");
            System.out.println(manager);
            manageContact();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }



    }








//        try {




//            Contact contact = new Contact("Aniruddh", "7975676030", "07/04/2002");
//            Contact contact2 = new Contact(contact);  // this goes to the copy constructor while debugging , one by one copying every value from the source object
//            contact.setBirthdate("07/04/2002");
//            System.out.println(contact);
//
//            ContactManager manager = new ContactManager();
//            manager.addContact(new Contact("Ryan", "6135012424", "11/11/1992"));
//            manager.addContact(new Contact("Gio", "6477123456" , "11/11/1993"));
//            manager.addContact(new Contact("Thomas", "6477092322" , "11/11/1994"));
//
//            manager.removeContact("Gio");
//
//            System.out.println(manager);
//
//
//        } catch (ParseException e){
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println("Process complete");
//        }
//
//    }






    // To access the names from a text file and load it into the contacts


    public static void loadContacts(String fileName ) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner sc = new Scanner(fis);
        while (sc.hasNextLine()) {
            try {
                Contact contact = new Contact(sc.next(), sc.next() , sc.next());  // Format of text in Names.xt
                manager.addContact(contact);
            }catch (ParseException e){
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }

    // To manage all of our contacts

    public static void manageContact(){

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Would you like to \n \t a) add another contact\n \t b) remove a contact \n \t c) exit");
           String response = sc.nextLine();
           if (response.equals("a")){
               System.out.print("\tName: ");
               String name = sc.nextLine();

               System.out.print("\tPhone Number: ");
               String phonenumber = sc.nextLine();
               System.out.print("\tBirth Date: ");
               String birthdate = sc.nextLine();



               // Making code free of invalid inputs
               if ((name.isEmpty())||(phonenumber.isEmpty())||(birthdate.isEmpty()) || phonenumber.length()<10){
                   System.out.println("Input is invalid , registration not possible");
               }
               else{
                   try {
                       manager.addContact(new Contact(name , phonenumber , birthdate));
                   }catch (ParseException e ){
                       System.out.println(e.getMessage());
                   }finally {
                       System.out.println(" CONTACT UPDATED \n\n" + manager);
                   }

               }

           }

           else if (response.equals("b")){
               System.out.println("Which contact would you like to remove ?");
               manager.removeContact(sc.nextLine());
               System.out.println("CONTACT REMOVED \n\n " + manager);
           }
           else{
               break;
           }
        }
        sc.close();


    }




}
