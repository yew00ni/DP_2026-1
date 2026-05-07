package practice.ch17;

// 관찰자
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) { // 통지받는 메소드
        System.out.print("GraphObserver:");
        int count = generator.getNumber(); // 관찰 대상이 어떤 숫자를 만들었는지 취득

        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println(""); // 줄 바꿈

        try {
            Thread.sleep(100); // 0.1초 대기
        } catch (InterruptedException e) {
        }
    }
}
