package practice.ch05.ex;

public class Singleton {
    private static Singleton singleton = null; // 미리 생성하지 않고 null로 초기화

    private Singleton() {
        System.out.println("인스턴스가 생성되었습니다.");
        slowdown(); // 생성 시간이 오래 걸리도록 함
    }

    public static Singleton getInstance() {
        if (singleton == null) { // singleton이 아직 생성되지 않았다면(null이라면), 첫 번째 호출 시에만 인스턴스가 생성됨
            singleton = new Singleton();
        }
        return singleton; // 만든 것을 반환하거나 이미 만들어진 것을 반환
    }

    private void slowdown() {
        try {
            Thread.sleep(1000); // CPU를 내놓고 1초간 쉼
        } catch (InterruptedException e) {
        }
    }
}
