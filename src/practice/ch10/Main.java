package practice.ch10;

public class Main {
    public static void main(String[] args) {
        /* 
        Hand h1 = Hand.ROCK;
        Hand h2 = Hand.SCISSORS; // 가위

        if (h1.isStrongerThan(h2)) {
            System.out.println(h1 + "이 " + h2 + "보다 강하다.");
        } else if (h1.isWeakerThan(h2)) {
            System.out.println(h1 + "이 " + h2 + "보다 약하다.");
        } else {
            System.out.println(h1 + "과 " + h2 + "는 비겼다.");
        };
        */

        // 플레이어 2명 생성
        Player player1 = new Player("임예원", new WinningStrategy(314)); // 자식 strategy를 줘도 잘 작동(다형성)
        Player player2 = new Player("손흥민", new WinningStrategy(15));

        // 게임 시키기

        for (int i = 0; i < 10; i++) {
            Hand h1 = player1.nextHand(); // 손을 얻어옴
            Hand h2 = player2.nextHand();

            if (h1.isStrongerThan(h2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            } else if (h1.isWeakerThan(h2)) {
                System.out.println("Winner: " + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }
    }
}
