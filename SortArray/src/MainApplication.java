import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainApplication {
    public static void main(String[] args) {

        String[] names = new String[]{"Radha Singh","Adarsh Kumar","Sonu","Adi"};
        // Sort the array
        Arrays.stream(names).sorted().forEach(s -> System.out.println(s));

        System.out.println("sort based on last name");

        // sort the array based on last name
        Arrays.stream(names).map(s -> (s.substring(s.indexOf(" ")+1, s.length()))).sorted().forEach(s-> System.out.println(s));

    }
}
