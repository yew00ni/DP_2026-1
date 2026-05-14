package practice.ch19;

// 주간 상태를 나타내는 클래스
public class DayState implements State {
    private static DayState singleton = new DayState(); // static singleton

    private DayState() {
    }

    public static State getInstance() { // singleton 객체를 얻는 메소드
        return singleton; // 이미 만들어놓은 것을 return
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || 17 <= hour) { // 야간 시간이 되면...(야간 시간에 해당되는지 검사)
            context.changeState(NightState.getInstance()); // 야간 상태로 전환(싱글턴 패턴이 적용되었기 때문에 NightState 객체를 얻어서 메소드 호출)
        }
    }

    @Override
    public void doUse(Context context) { // context를 인자로 받음
        context.recordLog("금고사용(주간)"); // 금고 사용 기록을 남김
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 통화(주간)");
    }

    @Override
    public String toString() {
        return "[주간]";
    }
}
