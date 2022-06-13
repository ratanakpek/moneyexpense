package ratanak.pek.moneyexpense.generic;

import java.util.ArrayList;

//T extends Number
//All the class that extend to Number, will can use this class (only subclass can use)
//String is not extend to Number
public class MyCustomListJava<T extends Number> {
    ArrayList<T> list = new ArrayList<>();

    public void addElement(T element) {
        list.add(element);
    }

    public void removeElement(T element) {
        list.remove(element);
    }

    public String toString() {
        return list.toString();
    }

    public T get(int index) {
        return list.get(index);
    }
}