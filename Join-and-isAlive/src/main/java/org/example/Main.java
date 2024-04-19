package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread( /*Runnable obj1 =*/ () -> {
            for (int i = 1; i<=5; i++){
                System.out.println("One");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread( () -> {
            for (int i = 1; i<=5; i++){
                System.out.println("Two");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread one status ; " + t1.isAlive());
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Thread one status ; " + t1.isAlive()); //task eka iwra unma thread eka claso wenwa  methna false pennanne ekai

        System.out.println("BYE");
    }
}