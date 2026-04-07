package ch06.A1a.framework;

public abstract class Product implements Cloneable { // 추상클래스(인터페이스가 아님)
    public abstract void use(String s);

    public Product createCopy() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
