package hw.ch10;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private Random random;

    public RandomStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public void study(boolean win) { // 이 전략은 학습하지 않기 때문에 아무것도 하지 않는다.(이전 승부는 필요 없기 때문에 비어 있음)
    }

    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3)); // 0, 1, 2 중에서 난수를 발생시켜서 손을 낸다 => 완전히 랜덤한 전략
    }
}
