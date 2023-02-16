import java.nio.CharBuffer;

public final class RandomWordAdapter extends RandomWord implements Readable {

    private int countOfStrings;

    public int getCountOfStrings() {
        return countOfStrings;
    }

    public void setCountOfStrings(int countOfStrings) {
        this.countOfStrings = countOfStrings;
    }

    public RandomWordAdapter(int pole, int countOfStrings) {
        super(pole);
        this.countOfStrings = countOfStrings;
    }

    public int read(CharBuffer cb) {
        if (--countOfStrings >= 0) {
            cb.append(this.rand()).append(" ");
            return this.getPole() + 1;
        }
        else {
            return -1;
        }
    }
}

