package hw.ch17;

public class EvenNumberGenerator extends NumberGenerator {
    private int number;
    private int start;
    private int end;
    private int inc;

    public EvenNumberGenerator(int start, int end) {
        if (start % 2 != 0) {
            throw new IllegalArgumentException("start 값은 짝수여야 합니다.");
        }
        this.start = start;
        this.end = end;
        this.inc = 2;
        this.number = start;
    }
    
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = start; i < end; i += inc) {
            number = i;
            notifyObservers();
        }
    }
}
