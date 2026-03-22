package hw.ch02;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번 : 20240823 / 이름 : 임예원");
        System.out.println();

        // 기존 한국 콘센트 객체 생성
        KoreanOutlet koreanOutlet = new KoreanOutlet();
        
        // 콘센트를 어댑터에 연결
        Charger koreanOutletAdapter = new KoreanOutletAdapter(koreanOutlet);
        
        // 어댑터를 사용하는 스마트폰 생성
        Smartphone smartphone = new Smartphone(koreanOutletAdapter);
        
        // 충전 시작
        System.out.println("--- 충전을 시작합니다 ---");
        smartphone.charge();
    }
}
