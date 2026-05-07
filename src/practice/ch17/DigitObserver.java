package practice.ch17;

// 구체적인 관찰자
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) { // 통지받는 메소드

        System.out.println("DigitObserver:" + generator.getNumber()); // 관찰 대상이 어떤 숫자를 만들었는지 출력

        try {
            Thread.sleep(100); // 0.1초 대기
        } catch (InterruptedException e) {
        }
    }
}
