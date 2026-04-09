package practice.ch10;

public interface Strategy {
    public abstract Hand nextHand(); // 다음 손을 결정할 때 호출
    public abstract void study(boolean win); // 이번에 이겼는지 졌는지 알려줌 -> 다음 승부에 사용될 전략을 준비시킴 : true이면 이김, false면 짐
}
