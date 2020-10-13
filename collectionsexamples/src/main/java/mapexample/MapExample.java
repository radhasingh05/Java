package mapexample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {

    private HashMap<Integer,String> hashMap = new HashMap<>();

    public void addElement(Integer key, String value){
        hashMap.put(key,value);
    }

    public void getElements(){

        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public void getElementsByOrder(){

    }

}
