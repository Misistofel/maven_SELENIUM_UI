package helpers;

public class Waiter {
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(){
     sleep(2);
    }
}
