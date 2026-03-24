package hw.ch03;

public class Main {
    public static void main(String[] args) {
        // [3-1] 기본 테스트
        AbstractDisplay d1 = new CharDisplay('H'); // 다형성 : 부모 클래스 타입으로 자식 클래스 객체를 참조
        AbstractDisplay d2 = new StringDisplay("Hello"); // 다형성 : 부모 클래스 타입으로 자식 클래스 객체를 참조
        d1.display();
        d2.display();

        // [3-2] Step 1 테스트 : 반복 횟수 제어
        // AbstractDisplay d1 = new CharDisplay('X', 3); // 3회
        // AbstractDisplay d2 = new StringDisplay("Test", 7); // 7회
        // d1.display();
        // d2.display();

        // [3-3] Step 2 테스트 : 새로운 Display
        // NumberDisplay
        // AbstractDisplay num = new NumberDisplay(42, 4);
        // num.display();
    }
}
