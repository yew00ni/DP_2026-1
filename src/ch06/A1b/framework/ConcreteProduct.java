package ch06.A1b.framework;

public abstract class ConcreteProduct implements Product { // Product 인터페이스를 구현한 클래스
    @Override
    public Product createCopy() { // createCopy()를 구현
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
