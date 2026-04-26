package hw.ch10;

public class CyclicStrategy implements Strategy {
    private int currentHand; // 현재 손 (0: 가위, 1: 바위, 2: 보)

    public CyclicStrategy() { // 생성자
        currentHand = 0; // 초기 손은 0(바위)로 시작
    }

    @Override
    public Hand nextHand() {
        Hand hand = Hand.getHand(currentHand); // 현재 손을 가져옴
        currentHand = (currentHand + 1) % 3; // 다음 손으로 변경 (0 -> 1 -> 2 -> 0)
        return hand;
    }

    @Override
    public void study(boolean win) { // 이 전략은 학습하지 않음 (순환만 수행)
    }
}
