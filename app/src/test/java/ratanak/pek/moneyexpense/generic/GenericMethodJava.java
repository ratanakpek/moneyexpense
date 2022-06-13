package ratanak.pek.moneyexpense.generic;

import java.util.List;

public class GenericMethodJava {

    public static <X> X doubleValue(X value) {
        return value;
    }

    public static <X extends List> void duplicate(X value) {
        value.addAll(value);
    }

    //upper bound wild card
    public static double sumOfNumberList(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }


    //lower bound wild card
    public static void sumOfNumberListSuper(List<? super Number> numbers) {
        numbers.add(1);
        numbers.add(1.0);
        numbers.add(1.0f);
        numbers.add(1l);
    }

//    static <X super String> void duplicateSuper(X value){
//        value.addAll(value);
//    }
}
