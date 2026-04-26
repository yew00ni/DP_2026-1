package hw.ch10;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random; // 난수를 발생시키는 Random 객체
    private int prevHandValue = 0; // 직전에 낸 손의 값
    private int currentHandValue = 0; // 이번에 낼 손의 값(가장 최근에 낸 손의 값)
    private int[][] history = { // 2차원 배열
        { 1, 1, 1, },
        { 1, 1, 1, },
        { 1, 1, 1, },
    };

    public ProbStrategy(int seed) {
        random = new Random(seed); // seed를 받아서 랜덤 생성자 초기화(seed에 따라서 다른 순서로 임의의 숫자가 만들어짐)
    }

    @Override
    public Hand nextHand() { // 다음에 낼 손을 결정하는 메소드
        int bet = random.nextInt(getSum(currentHandValue));
        int handvalue = 0;
        if (bet < history[currentHandValue][0]) { // 보다 작으면 = 속하면
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handvalue = 1;
        } else {
            handvalue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHand(handvalue);
    }

    private int getSum(int handvalue) { // 행의 합을 구한다
        int sum = 0; // 로컬 변수(초기화되지 않기 때문에 초기화 필요)
        for (int i = 0; i < 3; i++) {
            sum += history[handvalue][i]; // 행 번호는 고정, 열 번호는 0, 1, 2로 변화한다 => 그 행의 모든 열을 더한다.
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[prevHandValue][currentHandValue]++; // history 업데이트(이긴 손에 +1)
        } else {
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
