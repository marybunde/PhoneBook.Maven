package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private List<String> list = new ArrayList<>();

    private final Map<String, List<String>> phonebook;


    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {phonebook = new LinkedHashMap<String, List<String>>();
    }

    public void add(String name, String phoneNumber) {
        list.add(phoneNumber);
        phonebook.put(name,list);
    }

    public void addAll(String name, String... phoneNumbers) {
        for (String string: phoneNumbers){
            list.add(string);
        }
        phonebook.put(name,list);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name) || list.contains(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String result = "";
        for (Map.Entry<String,List<String>> entry: phonebook.entrySet()){
            result = entry.getKey();
        }

        return result;
    }

    public List<String> getAllContactNames() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String,List<String>> entry: phonebook.entrySet()) {
            result.add(entry.getKey());
        }
        return result;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
