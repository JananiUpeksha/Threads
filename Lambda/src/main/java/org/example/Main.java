package org.example;

public class Main {
    public static void main(String[] args) {
       /* One obj1 = new One();
        Two obj2 = new Two();*/

        //klin wge clz ekak na kiyla adhas wen na anonimus clz ekak hdenwa implemet wenwa
        Runnable obj1 = () -> {
            for (int i = 1; i<=5; i++){
                System.out.println("One");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        /*Runnable obj1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i<=5; i++){
                    System.out.println("One");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Runnable obj2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i<=5; i++){
                    System.out.println("Two");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };*/

        Thread t1 = new Thread(obj1);

        Thread t2 = new Thread( /*Runnable obj2 = */() -> {
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
        t2.start();
    }
}