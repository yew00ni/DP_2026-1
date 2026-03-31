package practice.ch05;

public class Main {
    public static void main(String[] args) {
        // Singleton s1 = new Singleton(); // 컴파일 에러 : Singleton() has private access in Singleton
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        System.out.println("s2 : " + s2);
        System.out.println("s3 : " + s3);

        if (s2 == s3) { // s2와 s3가 같은 객체를 참조하는지 비교
            System.out.println("s2와 s3는 같은 Singleton 객체입니다.");
        } else {
            System.out.println("s2와 s3는 다른 Singleton 객체입니다.");
        }

        Singleton2 s4 = Singleton2.INSTANCE; // 인스턴스 상수
        s4.hello();
    }
}
