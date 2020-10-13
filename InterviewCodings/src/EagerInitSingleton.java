public class EagerInitSingleton {
    private static volatile EagerInitSingleton sSoleInstance = new EagerInitSingleton();

    //private constructor.
    private EagerInitSingleton(){}

    public static EagerInitSingleton getInstance() {
        return sSoleInstance;
    }
}
