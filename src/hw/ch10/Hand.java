package hw.ch10;

// enum : 상수를 만들 때 사용(가위, 바위, 보를 각각 상수로 만듦)
public enum Hand {
    // 가위 바위 보를 나타내는 세 개의 enum 상수
    // 각 상수는 Hand 타입의 객체로 생성된다. => 생성자를 호출
    // 프로그램 전체를 통해서 손은 단 3개만 생성됨
    ROCK("바위", 0), // 하나하나가 Hand 객체
    SCISSORS("가위", 1),
    PAPER("보", 2);

    // enum이 가진 필드 
    private String name; // 가위 바위 보 손의 이름
    private int handvalue; // 가위 바위 보 손의 값 

    // 손의 값으로 상수를 얻기 위한 배열
    private static Hand[] hands = { // 클래스에 하나 존재하는 배열(손 세 개를 보관)
        ROCK, SCISSORS, PAPER
    };

    // 생성자 
    private Hand(String name, int handvalue) { // handvalue : 손의 값
        this.name = name;
        this.handvalue = handvalue;
    }

    // 손의 값으로 enum 상수를 가져온다 
    public static Hand getHand(int handvalue) {
        return hands[handvalue]; // hands 배열에서 handvalue에 해당하는 Hand 객체를 반환한다. => 손의 값으로 손 객체를 얻는다.
    }

    // this가 h보다 강할 때 true(현재 손과 인자로 들어오는 손을 비교)
    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1; // 1이면 true -> 현재 손이 더 강하다
    }

    // this가 h보다 약할 때 true(현재 손과 인자로 들어오는 손을 비교)
    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1; // -1이면 true -> 현재 손이 더 약하다
    }

    // 무승부는 0, this가 이기면 1, h가 이기면 -1
    private int fight(Hand h) {
        if (this == h) {
            return 0;
        } else if ((this.handvalue + 1) % 3 == h.handvalue) { //(현재 손 + 1) % 3이 입력받은 손과 같아지면 현재 손이 이김
            return 1;
        } else {
            return -1;
        }
    }

    // 가위 바위 보의 문자열 표현
    @Override
    public String toString() {
        return name; // 가위바위보 손의 이름 반환
    }
}
