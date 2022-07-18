package ratanak.pek.moneyexpense.designpattern.singleton;

import org.junit.Test;

import ratanak.pek.moneyexpense.experiment.designpattern.singleton.Database;
import ratanak.pek.moneyexpense.experiment.designpattern.singleton.SingleThreadSafe;
import ratanak.pek.moneyexpense.experiment.designpattern.singleton.Singleton;

public class SingletonUnitTest {
    @Test
    public void test() {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Database singleton = Database.getInstance("FOO");
        Database anotherSingleton = Database.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }

    @Test
    public void testSingletonWithThread(){
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        threadBar.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testSingletonWithThreadSafe(){
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(new ThreadFooSafe());

        Thread threadBar = new Thread(new ThreadBarSafe());
        threadFoo.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        threadBar.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    static class ThreadFooSafe implements Runnable {
        @Override
        public void run() {
            SingleThreadSafe singleton = SingleThreadSafe.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBarSafe implements Runnable {
        @Override
        public void run() {
            SingleThreadSafe singleton = SingleThreadSafe.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }



    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Database singleton = Database.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Database singleton = Database.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}
