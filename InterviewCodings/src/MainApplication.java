import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MainApplication {
    public static void main(String[] args) {

        CustomSingleton customSingleton = CustomSingleton.getInstance();
        customSingleton.demoMethod();

        CustomSingleton customSingleton2 = CustomSingleton.getInstance();

        System.out.println("Singleton Test with equals method : "+customSingleton.equals(customSingleton2));

        //Instance 1
        EagerInitSingleton instance1 = EagerInitSingleton.getInstance();

        //Instance 2
        EagerInitSingleton instance2 = EagerInitSingleton.getInstance();

        //now lets check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode());
        System.out.println("Instance 2 hash:" + instance2.hashCode());

        //Instance 1
        LazyInitSingleton instance3 = LazyInitSingleton.getInstance();

        //Instance 2
        LazyInitSingleton instance4 = LazyInitSingleton.getInstance();

        //now lets check the hash key.
        System.out.println("Instance 3 hash:" + instance3.hashCode());
        System.out.println("Instance 4 hash:" + instance4.hashCode());

        System.out.println("Singleton with reflection");

        //Create the 1st instance
        CustomSingleton instance5 = CustomSingleton.getInstance();

        //Create 2nd instance using Java Reflection API.
        CustomSingleton instance6 = null;
        try {
            Class<CustomSingleton> clazz = CustomSingleton.class;
            Constructor<CustomSingleton> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            instance6 = cons.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        //now lets check the hash key.
        System.out.println("Instance 5 hash:" + instance5.hashCode());
        System.out.println("Instance 6 hash:" + instance6.hashCode());

        System.out.println("Singleton with reflection solution ");

        //Create the 1st instance
        SingletonWithReflectionSolution instance7 = SingletonWithReflectionSolution.getInstance();

        //Create 2nd instance using Java Reflection API.
        SingletonWithReflectionSolution instance8 = null;
        try {
            Class<SingletonWithReflectionSolution> clazz = SingletonWithReflectionSolution.class;
            Constructor<SingletonWithReflectionSolution> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            instance8 = cons.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        //now lets check the hash key.
        System.out.println("Instance 7 hash:" + instance7.hashCode());
        System.out.println("Instance 8 hash:" + instance8.hashCode());

    }
}
