package hw.ch03;

public class NumberDisplay extends AbstractDisplay {
    private int number; // 표시해야 하는 숫자

    public NumberDisplay(int number, int repeatCount) {
        super(repeatCount); // 부모 클래스의 생성자를 호출하여 반복 횟수를 설정(부모 생성자에게 반복 횟수를 전달)
        this.number = number; // 생성자에서 숫자를 초기화
    }

    @Override
    public void open() {
        System.out.println("<<Number>>");
    }

    @Override
    public void print() {
        System.out.println(number);
    }

    @Override
    public void close() {
        System.out.println("<<Number>>");
    }
}