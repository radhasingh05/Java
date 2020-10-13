public class LazyInitSingleton {
    private static LazyInitSingleton sSoleInstance;

    private LazyInitSingleton(){}  //private constructor.

    public static LazyInitSingleton getInstance(){
        if (sSoleInstance == null){ //if there is no instance available... create new one
            sSoleInstance = new LazyInitSingleton();
        }

        return sSoleInstance;
    }
}
