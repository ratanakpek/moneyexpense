package ratanak.pek.moneyexpense.generic.javageneric;

import org.junit.Test;

public class ChapterOneTypeEraserTest {

    @Test
    public void typeEraser() {
        assert containsElement(new Integer[]{1, 2, 3}, 3);
        assert containsElement(new Integer[]{1, 2, 3}, 6) == false;

        assert containsElementReplaceWithObject(new Integer[]{1, 2, 3}, 1);
    }

    public <E> boolean containsElement(E[] elements, E element) {
        for (E e : elements) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsElementReplaceWithObject(Object[] elements, Object element) {
        for (Object e : elements) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }

}
