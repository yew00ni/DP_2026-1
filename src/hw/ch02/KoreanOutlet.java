package hw.ch02;

// 이미 제공되는 수정 불가능한 기존 클래스(Adaptee)
public class KoreanOutlet {
    // 한국 표준 전원: 220V AC
    public int provide() {
        System.out.println("한국 콘센트에서 220V AC를 제공합니다.");
        return 220; // 220V
    }
}
