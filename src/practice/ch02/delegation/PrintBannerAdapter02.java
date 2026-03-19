package practice.ch02.delegation;

// 어댑터
// 자바에서는 다중 상속이 불가능함(부모가 둘 이상은 허용이 안됨)
public class PrintBannerAdapter02 extends Print { // 추상 클래스는 implements가 안됨
    private Banner banner; // Banner 클래스의 인스턴스를 참조하는 필드

    public PrintBannerAdapter02(String text) { // 생성될 때 텍스트를 받음
        this.banner = new Banner(text); // Banner 클래스의 인스턴스를 생성하여 필드에 할당
    }

    @Override
    public void printWeak() {
        banner.showWithParen(); // Banner 클래스의 showWithParen() 메소드를 호출하여 약하게 출력(기능을 수행, 배너에게 위임)
    }

    @Override
    public void printStrong() {
        banner.showWithAster(); // Banner 클래스의 showWithAster() 메소드를 호출하여 강하게 출력(기능을 수행, 배너에게 위임)
    }
}
