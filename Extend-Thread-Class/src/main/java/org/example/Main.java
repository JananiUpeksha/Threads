package org.example;

public class Main {
    public static void main(String[] args) {
        One obj1 = new One();
        Two obj2 = new Two();

        obj1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //methna try catch eka nathuwath hriyta one two one two wdihta print wenwa
        obj2.start();

       /* obj1.whichThread();
        obj2.whichThread();*/
        //leaner programming one 5k print wela thma two 5k print wenne
    }
}