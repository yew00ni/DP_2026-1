package practice.ch06.framework;

// Product 인터페이스를 구현한 클래스는 clone() 메소드를 제공함
public interface Product extends Cloneable { // Cloneable : 인터페이스(인터페이스끼리는 상속 가능)
    public abstract void use(String s);
    public abstract Product createCopy(); // 복제 메소드
}
