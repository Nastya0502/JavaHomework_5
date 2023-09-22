package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    public static HashMap<String, ArrayList<String>> contacts = new HashMap<>();

    public static void addContact(String contactName, String contactNumber) {
        if (contacts.containsKey(contactName)){
            ArrayList phoneNumbers = contacts.get(contactName);
            phoneNumbers.add(contactNumber);
            contacts.put(contactName, phoneNumbers);
        }else{
            ArrayList<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(contactNumber);
            contacts.put(contactName, phoneNumbers);
        }
    }

    public static void PrintPhoneBook () {
        ArrayList<ArrayList<String>> printContacts = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> resultContacts = new ArrayList<ArrayList<String>>();
        Integer sizeBook = contacts.size();
        for (Map.Entry<String, ArrayList<String>> el : contacts.entrySet()) {
            printContacts.add(el.getValue());
        }

        while (resultContacts.size()<sizeBook){
            Integer maxInd = 0;
            Integer maxSize = 0;
            for (int i = 0; i < printContacts.size(); i++) {
                if (printContacts.get(i).size()>= maxSize) {
                    maxSize = printContacts.get(i).size();
                    maxInd = i;
                }
            }
            resultContacts.add(printContacts.get(maxInd));
            printContacts.remove(printContacts.get(maxInd));
        }

        for (ArrayList<String> el : resultContacts) {
            String name = null;
            for (Map.Entry<String, ArrayList<String>> cont : contacts.entrySet()) {

                if (cont.getValue().equals(el)){
                    name = cont.getKey();
                }
            }
            System.out.println(name+" : "+ el);
        }
    }




    public static void main(String[] args) {
        addContact("Nastya", "+375458788");
        addContact("Nastya", "+375458548");
        addContact("Andrew", "+375489757");
        addContact("Andrew", "+375465941");
        addContact("Sergei", "+375476478");
        addContact("Sergei", "+375654786");
        addContact("Sergei", "+375654759");

        PrintPhoneBook();
    }

}



