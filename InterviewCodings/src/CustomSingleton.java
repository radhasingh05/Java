public class CustomSingleton {
    private static CustomSingleton customSingleton = new CustomSingleton();

    private CustomSingleton(){
    }

    public static CustomSingleton getInstance(){
        return customSingleton;
    }

    protected static void demoMethod( ) {
        System.out.println("demoMethod for singleton");
    }

}
