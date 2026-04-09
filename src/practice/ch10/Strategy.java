package practice.ch10;

public interface Strategy {
    public abstract Hand nextHand(); // 다음 손을 결정할 때 호출
    public abstract void study(boolean win); // 다음 승부에 사용될 전략을 준비(공부) : true이면 이김, false면 짐
}
