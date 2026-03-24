package ch03.A4;

public interface AbstractDisplay {
    public void open();
    public void print();
    public void close();

    public default void display() { // default 메소드 : 인터페이스에서 구현을 정의하는 메소드
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
