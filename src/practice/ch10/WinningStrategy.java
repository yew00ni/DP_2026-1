package practice.ch10;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random; // 난수를 발생시키는 Random 객체
    private boolean won = false; // 직전의 승부에서 이겼는지 여부를 나타내는 변수(false로 초기화)
    private Hand prevHand; // 이전에 낸 손

    public WinningStrategy(int seed) { // 생성자
        random = new Random(seed); // seed를 받아서 랜덤 생성자 초기화(seed에 따라서 다른 순서로 임의의 숫자가 만들어짐)
    }

    @Override
    public Hand nextHand() {
        if (!won) { // 이전에 졌다면...(won이 false라면)
            prevHand = Hand.getHand(random.nextInt(3)); // 0, 1, 2 중에서 난수를 발생시켜서 새로운 손을 만듦 => 랜덤으로 손을 낸다.
        }
        return prevHand; // 이전의 손을 고대로 return한다. => 이전에 이겼다면 같은 손을 낸다.
    }

    @Override
    public void study(boolean win) {
        won = win; // true or false
    }
}
