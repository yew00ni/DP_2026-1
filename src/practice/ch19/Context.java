package practice.ch19;

public interface Context {
    public abstract void setClock(int hour); // 시간 설정

    public abstract void changeState(State state); // 상태 변화(부모 타입으로 받기 때문에 DayState, NightState 모두 받을 수 있음)
     
    public abstract void callSecurityCenter(String msg); // 경비 센터 경비원 호출
    public abstract void recordLog(String msg);	// 경비 센터 기록 
}
