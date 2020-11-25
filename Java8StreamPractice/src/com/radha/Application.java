package com.radha;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student(
                "Khyati",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student(
                "Jason",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));


        List<Student> students = Arrays.asList(student1, student2, student3);

        // 1.Get student with exact match name "jayesh"

        Optional<Student> studentOptional = students.stream().filter(student -> student.getName().equals("Jayesh")).findFirst();
        System.out.println(studentOptional);

        // 2. Get student with matching address "1235"

        System.out.println(students.stream().filter(student -> student.getAddress().getZipcode().equals("1235")).findFirst());

        // 3. Get all student having mobile numbers 3333

        List<Student> studentList = students.stream().filter(student -> student.getMobileNumbers().stream().anyMatch(x -> Objects.equals(x.getNumber(),"3333"))).collect(Collectors.toList());
        System.out.println(studentList);

        // 4. Convert List<Student> to List<String> of student name

        List<String> strings = students.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(strings);

        // 5. Convert List<students> to String

        String stud = students.stream().map(Student::toString).collect(Collectors.joining());
        System.out.println(stud);

        // 6. Sort List<String>

        List<String> namesList =
                Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");

        namesList.stream().sorted().forEach(s-> System.out.println(s));


    }
}
