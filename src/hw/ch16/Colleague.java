package hw.ch16;

// 멤버(동료)를 위한 인터페이스
public interface Colleague {
    // Mediator를 설정한다 
    public abstract void setMediator(Mediator mediator); // 자기 중재자가 누군지 설정

    // Mediator에서 활성/비활성을 지시한다
    public abstract void setColleagueEnabled(boolean enabled); // true이면 활성화, false이면 비활성화
}
