package practice.ch10;

public class Player {
    private String name;
    private Strategy strategy; // 부모 타입으로 선언됨 => 모든 자식 전략 객체를 참조할 수 있다, 플레이어가 사용할 전략(strategy 타입의 속성을 가짐)
    private int wincount;
    private int losecount;
    private int gamecount;

    // 이름과 전략을 받아서 플레이어를 만든다 
    public Player(String name, Strategy strategy) { // strategy 변수가 부모 타입(어떤 자식 전략이든 받아서 보관 가능)
        this.name = name;
        this.strategy = strategy;
    }

    // 전략에 따라 다음 손을 결정한다
    public Hand nextHand() {
        return strategy.nextHand(); // 전략 객체에게 다음 손을 결정하도록 Strategy에게 위임한다.(player 자신이 결정하는 것이 아님) => 어떤 전략 객체인지에 따라서 다음 손이 결정
    }

    // 승리
    public void win() {
        strategy.study(true); // 이기면 true를 전달
        wincount++;
        gamecount++;
    }

    // 패배
    public void lose() {
        strategy.study(false); // 지면 false를 전달
        losecount++;
        gamecount++;
    }

    // 무승부 
    public void even() {
        gamecount++; // 비기면 gamecount만 증가
    }

    @Override
    public String toString() { // 몇번 이기고 졌는지 문자열로 출력
        return "["
            + name + ":"
            + gamecount + " games, "
            + wincount + " win, "
            + losecount + " lose"
            + "]";
    }
}
