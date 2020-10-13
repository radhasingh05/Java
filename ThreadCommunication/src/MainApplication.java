public class MainApplication {
    public static void main(String[] args) {

        final Customer c=new Customer();
        new Thread(){
            public void run(){c.withdraw(30000);}
        }.start();
        new Thread(){
            public void run(){c.deposit(10000);}
        }.start();

    }
}
