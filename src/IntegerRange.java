import java.util.Iterator;

public class IntegerRange implements Iterable <Integer> {

    private Integer lowerNumber;
    private Integer higherNumber;


    public IntegerRange(Integer lowerNumber, Integer higherNumber){
        this.lowerNumber = lowerNumber;
        this.higherNumber = higherNumber;

    }

    public Integer getLowerNumber() {
        return lowerNumber;

    }

    public Integer getHigherNumber() {
        return higherNumber;

    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeInterater();


    }


    public class RangeInterater implements Iterator<Integer> {

        private int counter = lowerNumber;

        @Override
        public boolean hasNext() {
            //return counter < higherNumber;
            if (counter > higherNumber){
                return false;
            }
            return true;
        }

        @Override
        public Integer next() {
            return counter++;
        }
    }
}
