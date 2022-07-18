package ratanak.pek.moneyexpense.experiment.designpattern.singleton;

public class SingleThreadSafe {

    private static volatile SingleThreadSafe instance;

    public String value;

    private SingleThreadSafe(String value) {
        this.value = value;
    }

    public static SingleThreadSafe getInstance(String value) {
        // The approach taken here is called double-checked locking (DCL). It
        // exists to prevent race condition between multiple threads that may
        // attempt to get singleton instance at the same time, creating separate
        // instances as a result.
        //
        // It may seem that having the `result` variable here is completely
        // pointless. There is, however, a very important caveat when
        // implementing double-checked locking in Java, which is solved by
        // introducing this local variable.
        //
        // You can read more info DCL issues in Java here:
        // https://refactoring.guru/java-dcl-issue
        SingleThreadSafe result = instance;
        if (result != null) {
            return result;
        }
        synchronized(SingleThreadSafe.class) {
            if (instance == null) {
                instance = new SingleThreadSafe(value);
            }
            return instance;
        }
    }
}
