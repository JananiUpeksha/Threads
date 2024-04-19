package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Calculation c = new Calculation();
        /*c.increment();
        c.increment();*/
        Thread t1 = new Thread(() -> {
            for (int i=1 ; i<=1000; i++){
                c.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i=1 ; i<=1000; i++){
                c.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();//execution eka iwra wenkl inna sout eka print krnna klin meka nththn 0 print wenne execute wenna klin value eka
        t2.join();//join eka maddta enna ba ethkote leaner
        System.out.println("Count :" + c.num);
    }
}