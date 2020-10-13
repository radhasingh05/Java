package mapexample;

import java.util.*;
import java.util.stream.Collectors;

public class MainApplication {

    private static MapExample mapExample = new MapExample();


    public static void main(String[] args) {

        mapExample.addElement(1,"radha");
        mapExample.addElement(2,"singh");
        mapExample.addElement(3,"adarsh");
        mapExample.addElement(4,"kumar");

        mapExample.getElements();

        // ******************************************** /

        Map<Integer,String> map = new HashMap<>();
        map.put(101,"Radha");
        map.put(102,"Adarsh");
        map.put(103,"Singh");
        map.put(100,"kumar");

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();

        System.out.println("Map retrieval using while");
        while(iterator.hasNext()){
           // System.out.println(" map " +iterator.next());
            Map.Entry<Integer,String> entry = (Map.Entry<Integer, String>) iterator.next();
            System.out.println("Key "+entry.getKey()+" value "+entry.getValue());
        }

        // get key and values

        System.out.println("Map retrieval using for loop");
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println("Key "+entry.getKey()+" Value "+entry.getValue());
        }

        // get all the keys
        System.out.println("Retrieve all the Keys from Map");
        Set<Integer> keySet = map.keySet();
        for(Integer k : keySet){
            System.out.println(k);
        }

        //get all the values
        System.out.println("Retrieve all the values from map");
        Collection<String> valueSet = map.values();
        for(String v : valueSet){
            System.out.println(v);
        }

        System.out.println("Map retrieval using forEach loop");
        map.forEach((k,v) -> System.out.println("Key " + k + " value "+ v));

        // ****************************************** /

        Map<Integer, String> result = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Map<Integer, String> result2 = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        System.out.println(" sorted data from map using stream ");
        System.out.println(result);
        System.out.println("***********************************");
        System.out.println(result2);

        // ************************************************* /



    }
}
