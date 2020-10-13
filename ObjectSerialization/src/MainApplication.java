
import java.io.*;

public class MainApplication {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Employee employee = new Employee();
        employee.setName("Radha");
        employee.setAge((byte)33);
        employee.setAddress("5250 Town and Country blvd, Frisco, TX, 75034");

        FileOutputStream fileOutputStream = new FileOutputStream("/Volumes/Radha-Home/Java8/employee.obj");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employee);
        objectOutputStream.close();
        System.out.println("Process Completed....");


        Employee employee1 = new Employee();
        FileInputStream fileInputStream = new FileInputStream("/Volumes/Radha-Home/Java8/employee.obj");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        employee1 = (Employee) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("employee reading from the file "+employee1);


    }
}
