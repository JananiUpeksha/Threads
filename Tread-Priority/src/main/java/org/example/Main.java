package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread( /*Runnable obj1 =*/ () -> {
            for (int i = 1; i<=5; i++){
                System.out.println("One" + Thread.currentThread().getName() );
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
        },"Two");


        t1.start();
        t1.setName("Thread One - 01");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread Name: " + t1.getName());
        System.out.println("Thread Name: " + t2.getName());
        t2.start();

        t1.join();
        t2.join();

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Priority :" + t1.getPriority());
    }
}