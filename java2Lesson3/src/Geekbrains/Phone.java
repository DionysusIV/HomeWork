package Geekbrains;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phone {
    private Map<String, Set<String>>  phonebook = new HashMap<>();

    public void add(String name,String phone){
        Set<String> tell = phonebook.getOrDefault(name, new HashSet<>());
        tell.add(phone);
        phonebook.put(name,tell);
    }

    public  Set<String> get(String name) {
        return phonebook.get(name);
    }
}
