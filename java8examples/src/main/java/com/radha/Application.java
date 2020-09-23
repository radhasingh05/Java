package com.radha;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        // join() method in String class
        String join = String.join(" & ", "Radha", "Adarsh","Singh");
        System.out.println(join);

        String ids = String.join(", ", ZoneId.getAvailableZoneIds());
        System.out.println(ids);

        // Java 8 Time API , Joda library is added in the java
        // difference between two dates
        LocalDate DOB = LocalDate.of(1983,9,13);
        LocalDate currentDate = LocalDate.now();

        Period diff = Period.between(DOB,currentDate);
        System.out.println(diff);
        System.out.println(diff.getYears()+" years and "+diff.getMonths()+" months "+diff.getDays()+" days old");

        // ChronoUint to know the difference in the days, months and year  (java.time.temporal.ChronoUnit)
        long inYears = ChronoUnit.YEARS.between(DOB,currentDate);
        System.out.println(inYears);
        long inMonths = ChronoUnit.MONTHS.between(DOB,currentDate);
        System.out.println(inMonths);
        long inDays = ChronoUnit.DAYS.between(DOB,currentDate);
        System.out.println(inDays);
        System.out.println(ChronoUnit.DECADES.between(DOB,currentDate));

        // For Time difference
        long inSecond = ChronoUnit.SECONDS.between(DOB.atTime(12,1),currentDate.atTime(12,1));
        System.out.println(inSecond);
        System.out.println(DOB.atTime(23,01,05));

        // java.time.Duration  to know the difference in millis/seconds/minutes etc
        LocalDateTime date = LocalDateTime.of(1986,4,5,0,0);
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(Duration.between(date,currentTime).getSeconds());
        System.out.println(Duration.between(date,currentTime).getNano());
        System.out.println(Duration.between(date,currentTime).toMinutes());

        // Convert RegExp to Predicate

        Predicate<String> emailFilter = Pattern
                                        .compile("@gmail.com$")
                                        .asPredicate();

        List<String> list = Arrays.asList("abc@gmail.com","abc@Yahoo.com","xyz@gmail.co.in","radha@gmail.com");

        List<String> emails = list.stream().filter(emailFilter).collect(Collectors.toList());
        emails.forEach(System.out::println);

        // Method Reference -- static Method
        List<Integer> integerList = Arrays.asList(10,290,890,3587);
        Optional<Integer> max = integerList.stream().reduce(Math::max);
        max.ifPresent(value -> System.out.println("max value "+value));

        // Method Reference -- Instance method  ClassInstance::instanceMethodName
        List<Integer> integerList1 = Arrays.asList(6,12,456,98,-1);
        Optional<Integer> min = integerList1.stream().reduce(Math::min);
        min.ifPresent(System.out::println);  // Instance method

        // Method Reference -- Instance method Class::instanceMethodName
        List<String> stringList = Arrays.asList("Radha","Singh","Adarsh","Kumar");
        List<String> sortedList = stringList.stream()
                .sorted((s1,s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());
        System.out.println(sortedList);

        List<String> sortedList2 = stringList.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(sortedList2);

        //Reference to constructor  Class::new
        List<Integer> integers = IntStream.range(1,100).boxed().collect(Collectors.toCollection(ArrayList::new));
        Optional<Integer> maxValue = integers.stream().reduce(Math::max);
        maxValue.ifPresent(value -> System.out.println(value));

        // Streams
        // Difference ways to create Streams
        // Using Stream.of
        System.out.println("**************** Stream ***************");
        Stream<Integer> integerStream = Stream.of(2,4,6,8,10);
        integerStream.forEach(System.out::println);

        // Using String.of(Array of Elements)
        Stream<String> stringStream = Stream.of(new String[] {"abc","xyz","pqr"});
        stringStream.forEach(System.out::println);

        //Using stream method from collection
        List<String> list1 = new ArrayList<>();
        list1.add("Sonu");
        list1.add("Adi");
        list1.add("adarsh");

        list1.stream().forEach(System.out::println);

        // Converting Stream to other data structure
        // Stream.collect(Collectors.toList()) or toSet() or toMap()
        System.out.println("******************** convert streams to collection *****************");
        List<String> strings = new ArrayList<>();
        strings.add("Radha");
        strings.add("Adarsh");
        strings.add("Singh");
        strings.add("Kumar");

        List<String> sortedString = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(sortedString);

        List<Integer> integers1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> evenNumbers = integers1.stream().filter((i) -> i%2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        // Convert stream to Array
        System.out.println("***************** Convert Stream to Array  using toArray() *****************");
        Integer[] array = {1,2,3,4,5,6,7,8,9};
        Integer[] oddNumbers = Arrays.stream(array).filter(i -> i%2 == 1).toArray(Integer[]::new);
        for(Integer num : oddNumbers){
            System.out.println(" odd Numbers "+ num);
        }

        // Core Operations
        // Intermediate and Terminal Operations
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        // filter()
        System.out.println("*********** Intermediate operation  Filter Method ************** ");
        memberNames.stream().filter(s->s.startsWith("A")).forEach(System.out::println);

        // map()
        System.out.println("*********** Intermediate operation map Method ************** ");
        memberNames.stream().map(String::toUpperCase).forEach(s-> System.out.println(s));

        //flatMap()  Stream + String[] + flatMap
        System.out.println("************ flatMap **************");
        String[][] data = new String[][]{{"Radha","Singh"},{"Adarsh","Kumar"},{"Sonu","Singh"}};
        Stream<String[]> arrayStringStream = Arrays.stream(data);
        Stream<String> stringStream1 = arrayStringStream.flatMap(s->Arrays.stream(s));
        stringStream1.forEach(s->System.out.println(s));

        //flatMap() Stream + Set + flatMap
        System.out.println("*********** Stream + Set + flatMap ************ ");
        Student obj1 = new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        List<Student> list2 = new ArrayList<>();
        list2.add(obj1);
        list2.add(obj2);

        List<String> bookList = list2.stream().map(x -> x.getBook()).flatMap(s->s.stream()).collect(Collectors.toList());
        bookList.forEach(System.out::println);

        // Stream + Primitive + flatMapToInt
        System.out.println("********** Stream + Primitive + flatMapToInt ************");
        int[] intArray = {1,2,3,4,5,6};
        Stream<int[]> streamArray = Stream.of(intArray);
        IntStream intStream = streamArray.flatMapToInt(x->Arrays.stream(x));
        intStream.forEach(s->System.out.println(s));

        // sorted()
        System.out.println("*********** Intermediate operation sorted Method ************** ");
        memberNames.stream().sorted().map(String::toUpperCase).forEach(s-> System.out.println(s));

        // forEach()
        System.out.println("*********** Intermediate operation forEach Method ************** ");
        memberNames.stream().forEach(s-> System.out.println(s));

        // collect()
        System.out.println("*********** Intermediate operation collect Method ************** ");
        System.out.println(memberNames.stream().collect(Collectors.toList()));

        // match() allMatch() anyMatch() allMatch() it will take predicate and return boolean
        System.out.println("anyMatch "+memberNames.stream().anyMatch(s->s.startsWith("A")));
        System.out.println("allMatch "+memberNames.stream().allMatch(s->s.startsWith("A")));
        System.out.println("noneMatch "+memberNames.stream().noneMatch(s->s.startsWith("A")));

         // count()
        // Count is a terminal operation returning the number of elements in the stream as a long value
        System.out.println("count "+memberNames.stream().count());

        //reduce()
        System.out.println(memberNames.stream().reduce((s1,s2) -> s1 + " & "+ s2 ));

        // Group by , count and sort
        //3 apple, 2 banana, others 1
        System.out.println("************** groupingBy ************* ");
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(result);

        System.out.println("*************** Use Supplier to reuse the stream ************ ");
        String[] stringArray = {"a", "b", "c", "d", "e"};

        Supplier<Stream<String>> streamSupplier = () -> Stream.of(stringArray);

        //get new stream
        streamSupplier.get().forEach(x -> System.out.println(x));

        //get another new stream
        long count = streamSupplier.get().filter(x -> "b".equals(x)).count();
        System.out.println(count);

        // New Method in Java 8







    }
}
