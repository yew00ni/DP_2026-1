package ch05.A1;

public class TicketMaker {
    private int ticket = 1000;
    private static TicketMaker singleton = new TicketMaker(); // 클래스 로드 시점에 객체가 하나 만들어짐

    private TicketMaker() { // 생성자를 private으로 만듦
    }

    public static TicketMaker getInstance() {
        return singleton; // 객체가 하나만 계속 리턴
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}
