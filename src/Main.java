import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        IntegerRange range = new IntegerRange(1, 100);

        Iterator it = range.iterator();

        Box<String> stringBox = new Box<>();
        Box<IntegerRange> integerRangeBox = new Box<>();
        integerRangeBox.setData(range);

        /*while (it.hasNext()) {
            System.out.println(it.next());

        }

         */

        for (Integer i : range) {
            System.out.println(i);
        }
    }
}
