package com.company.Controller;

import com.company.Model.PhoneContact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookManagement {
    List<PhoneContact> listPhoneBooks = new ArrayList<>();

    public PhoneBookManagement() {
        File file = new File("contact.txt");
        if (file.exists()) {
            try {
                readFile("contact.txt");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayALL(){
        for (PhoneContact phoneBook: listPhoneBooks
             ) {
            System.out.println(phoneBook);
        }
    }

    public void addNewContact(PhoneContact phoneContact){
        listPhoneBooks.add(phoneContact);
    }

    public int getIndexByName(String contactName){
        int index = -1;
        for (int i = 0; i < listPhoneBooks.size(); i++) {
            if(listPhoneBooks.get(i).getContactName().equals(contactName)){
                index = i;
            }
        }
        return index;
    }
    
    public PhoneContact getInfoByName(String contactName){
        PhoneContact phoneContactGetByName = new PhoneContact();
        for (int i = 0; i < listPhoneBooks.size(); i++) {
            if(listPhoneBooks.get(i).getContactName().equals(contactName)){
                phoneContactGetByName = listPhoneBooks.get(i);
                break;
            }
        }
        return phoneContactGetByName;
    }

    public void updateContact(int index,PhoneContact changePhoneContact){
        listPhoneBooks.set(index, changePhoneContact);
    }

    public void deleteContact(int index){
        listPhoneBooks.remove(index);
    }

    public int getSize(){
        return listPhoneBooks.size();
    }

    public boolean checkExistByName(String checkName){
        boolean isExsit = false;
        for (int i = 0; i < listPhoneBooks.size(); i++) {
            if(listPhoneBooks.get(i).getContactName().equals(checkName)){
                isExsit = true;
                break;
            }
        }
        return isExsit;
    }

    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this.listPhoneBooks);
    }

    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.listPhoneBooks = (List<PhoneContact>) ois.readObject();
    }
}
