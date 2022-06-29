package models;

import java.util.ArrayList;

public class ContactManager {

    ArrayList<Contact> contacts;



    public ContactManager(){
        this.contacts = new ArrayList<Contact>();
    }

    public Contact getContact(int index){
        return new Contact(contacts.get(index));
    }

    public void setContact(Contact contact , int index){  // To update any contact at a requested index
        contacts.set(index, new Contact(contact));
    }



    public void addContact(Contact contact){
        contacts.add(new Contact(contact));
    }

    public void removeContact(String contactName){

        if (contacts.isEmpty()){
            throw new IllegalStateException("Can't remove as it has already been removed before");
        }
        for (int i = 0; i <contacts.size() ; i++) {
            if (contacts.get(i).getName().equals(contactName)){
                contacts.remove(i);
            }

        }
    }


    public String toString(){
        String temp = "";
        for (int i=0;i< contacts.size();i++){
            temp += contacts.get(i).toString();
            temp+="\n\n";
        }
        return temp;
    }


}
