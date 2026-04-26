package hw.ch10;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번 : 20240823 / 이름 : 임예원");
        System.out.println();

        System.out.println("===== RandomStrategy =====");
        Player player1 = new Player("Taro", new RandomStrategy(0));

        System.out.println("===== CyclicStrategy =====");
        Player player2 = new Player("Bob", new CyclicStrategy());

        // CyclicStrategy 테스트 : 순환 확인
        System.out.println("CyclicStrategy 의 손가락 순환 : ");
        Strategy cyclic = new CyclicStrategy();
        for (int i=0 ; i<9; i++) {
            Hand hand = cyclic.nextHand();
            System.out.println(((i+1) + "번째 : " + hand));
            cyclic.study(false); // study 호출해도 영향 없음
        }

        // 게임 진행 코드
        // payer1과 player2를 10번 게임을 진행시킴
        System.out.println("\n===== 게임 진행 =====");
        for (int i=0; i<10; i++) {
            Hand hand1 = player1.nextHand();
            Hand hand2 = player2.nextHand();

            System.out.println("게임 " + (i+1) + ": " + player1 + " vs " + player2);
            System.out.println("손: " + hand1 + " vs " + hand2);

            if (hand1.isStrongerThan(hand2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            } else if (hand1.isWeakerThan(hand2)) {
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
