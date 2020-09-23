package com.radha;


import java.util.*;

public class Application {
    public static void main(String[] args) {

        //Lambda Expression
        // Sort without lambda expression
        List<Student> studentList = getDevelopers();
        System.out.println("before sorting");
        for(Student student : studentList){
            System.out.println(student);
        }

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getFirstName().compareTo(o1.getFirstName());
            }
        });

        System.out.println("after sorting ");

        for(Student student : studentList){
            System.out.println(student);
        }

        // sort with lambda expression
        System.out.println("sort with lambda expression");

        studentList = getDevelopers();

        studentList.sort((Student s1,Student s2) -> s1.getFirstName().compareTo(s2.getFirstName()));
        studentList.forEach((student) -> System.out.println(student));


        // ******************************************************** /

        Map<Integer,String> map = new HashMap();

        map.put(1,"radha");
        map.put(2,"singh");
        map.put(3,"adarsh");
        map.put(4,"kumar");

        // Normal for loop
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println("Key "+ entry.getKey() +" Value "+entry.getValue());
        }

        // With forEach loop from java 8
        System.out.println("java 8 forEach loop");
        map.forEach((k,v) -> System.out.println("key "+k+" value "+v));

        System.out.println("filter the data with java 8 forEach loop");
        map.forEach(
                (k,v) -> {
                    if (v.equals("radha")) System.out.println(" value "+v);
                }
        );

        // ************************************************************************ /

        //forEach and List
        List<String> list = new ArrayList();
        list.add("abcd");
        list.add("pqr");
        list.add("abc12");
        list.add("xyzzzz");


        // with Normal for loop
        for(String s : list){
            System.out.println(s);
        }

        // with List forEach loop
        System.out.println("with List forEach loop");
        list.forEach((s) -> System.out.println(s));

        // **************************************************************** /

        //with List forEach loop with filter the data
        System.out.println("with List forEach loop and sort the data");
        list.stream().filter(s->s.startsWith("a")).forEach(s-> System.out.println(s));

        System.out.println("print the length of each string");
        list.stream().mapToInt(s->s.length()).forEach(s-> System.out.println(s));


    }


    private static List<Student> getDevelopers() {

        List<Student> result = new ArrayList<Student>();

        result.add(new Student(101,"radha","singh"));
        result.add(new Student(101,"adarsh","kumar"));
        result.add(new Student(101,"Adi","singh"));

        return result;

    }
}
