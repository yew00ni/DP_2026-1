package practice.ch05;

// 싱글톤 패턴 적용하기
public class Singleton {
    // (3) Singleton 객체를 미리 하나 만들어서 static 변수에 저장해 놓는다.
    // 클래스 로드 시 실행됨
    private static Singleton singleton = new Singleton(); // 미리 하나 만들어서 클래서에 저장해 놓음
    
    // (1) 생성자를 private으로 한다.
    private Singleton() {
        System.out.println("Singleton 객체가 생성됩니다.");
    }

    // (2) Singleton 객체를 얻어가는 메소드를 정의한다.
    public static Singleton getInstance() { // Singleton 객체가 생성되기 전에 getInstance()가 먼저 호출되어야 하기 때문에 static으로 선언
        return singleton; // 미리 만들어놓은 singleton을 반환
    }
}
