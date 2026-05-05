package practice.ch16;

// 중재자를 위한 인터페이스
public interface Mediator {
    // Colleague를 생성한다(각 동료들을 생성) 
    public abstract void createColleagues();

    // Colleage의 상태가 변화했을 때 호출된다(이 메소드를 통해 중재자에게 알림)
    public abstract void colleagueChanged();
}
