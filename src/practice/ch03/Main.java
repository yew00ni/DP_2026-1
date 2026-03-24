package practice.ch03;

public class Main {
    public static void main(String[] args) {
        // CharDisplay d1 = new CharDisplay('H'); // 'H' : 문자 / "H" : 문자열
        AbstractDisplay d1 = new CharDisplay('H'); // 다형성 : 부모 클래스 타입으로 자식 클래스 객체를 참조
        d1.display();

        // StringDisplay d2 = new StringDisplay("Hello, world."); // "Hello, world." : 문자열 / 'Hello, world.' : 문자
        AbstractDisplay d2 = new StringDisplay("Hello, world."); // 다형성 : 부모 클래스 타입으로 자식 클래스 객체를 참조
        d2.display();

        // 부모 타입으로 선언하면 자식을 모두 가리킬 수 있으므로 자식1, 자식2 모두 가리킬 수 있음 -> LSP 원칙

         // AbstractDisplay d3 = new AbstractDisplay(); // 추상 클래스는 인스턴스를 생성할 수 없음 -> 컴파일 에러
    }
}
