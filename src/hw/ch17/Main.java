package hw.ch17;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번 : 20240823 / 이름 : 임예원");
        System.out.println();

        NumberGenerator generator = new EvenNumberGenerator(0, 30); // 새로운 관찰 대상 생성

        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        Observer observer3 = new RangeObserver();

        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.addObserver(observer3);

        generator.execute();
    }
}
