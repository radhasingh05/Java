public class SingletonWithReflectionSolution {

    private static SingletonWithReflectionSolution sSoleInstance;

    //private constructor.
    private SingletonWithReflectionSolution(){

        //Prevent form the reflection api.
        if (sSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonWithReflectionSolution getInstance(){
        if (sSoleInstance == null){ //if there is no instance available... create new one
            sSoleInstance = new SingletonWithReflectionSolution();
        }

        return sSoleInstance;
    }
}
