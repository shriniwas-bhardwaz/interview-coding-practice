package LowLevelDesign.ThreadDesign.HashTableImpl;

import java.util.Hashtable;

public class HashTableImplementation {


    public static void main(String[] args) {

        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put("add",1);

        Object l1 = new Object();
        synchronized (l1) {

        }
    }
}
