package hw.ch02;

// 어댑터
// 인터페이스를 implements로 구현하여 기존 클래스의 기능을 클라이언트가 기대하는 인터페이스에 맞게 변환
public class KoreanOutletAdapter implements Charger {
    private KoreanOutlet koreanOutlet;

    public KoreanOutletAdapter(KoreanOutlet koreanOutlet) {
        this.koreanOutlet = koreanOutlet;
    }

    @Override
    public int charge() {
        return koreanOutlet.provide();
    }
}
