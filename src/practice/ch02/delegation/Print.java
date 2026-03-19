package practice.ch02.delegation;

// 클라이언트가 원하는 인터페이스, 필요로 하는 인터페이스, Target 인터페이스 <= 추상 클래스
public abstract class Print { // 추상 클래스
    public abstract void printWeak(); // 추상 메소드로 나타나 있음
    public abstract void printStrong();
}
