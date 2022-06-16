package ratanak.pek.moneyexpense.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericPartTwoTest {


    //==========================================
    @Test
    public void isObjectEqualUnknownType(){
        List<Object> objectList = new ArrayList<>();
        printListObject(objectList);
        printListWildCard(objectList);

        List<Integer> integerList = new ArrayList<>();
       // printListObject(integerList); //compile time error
        printListWildCard(integerList);

        // ?   =  List<? extends Object>   -> same

    }


//    public static void printListWildCard(List<? extends Object> list){
//        for (Object element: list) {
//            System.out.print(element + " ");
//        }
//    }


    public static void printListObject(List<Object> list) {
        for (Object element : list) {
            System.out.print(element + " ");
        }
    }

    public static void printListWildCard(List<?> list) {
        for (Object element: list) {
            System.out.print(element + " ");
        }
    }

    //==========================================

    @Test
    public void issueWithoutUseGeneric(){
        List<Integer> iList = new ArrayList<>();
        iList.add(1);
       //
        // iList.add("a_string"); // compile time error

        for (int i = 0; i < iList.size(); i++) {
            int x = iList.get(i);
        }
    }



}
