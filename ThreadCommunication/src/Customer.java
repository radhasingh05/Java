public class Customer {
    int amount = 10000;

    synchronized void withdraw(int amount){
        System.out.println("Going to withdraw .....");
        if(this.amount < amount){
            System.out.println("Less balance; waiting for deposit...");
            try{
                wait();
            }catch(Exception e){

            }
            this.amount-=amount;

        }
    }

    synchronized void deposit(int amount){
        System.out.println("going to deposit...");
        this.amount+=amount;
        System.out.println("deposit completed... ");
        notify();
    }

}
