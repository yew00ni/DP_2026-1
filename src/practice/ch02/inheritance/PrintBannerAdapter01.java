package practice.ch02.inheritance;

// 어댑터
public class PrintBannerAdapter01 extends Banner implements Print {
    // (1) 인자가 없는 생성자는 자동으로 만들어짐
    // (2) 생성자는 상속되지 않는다.

    public PrintBannerAdapter01(String string) {
        super(string); // super : 부모 생성자(Banner)를 호출함
    }

    @Override
    public void printWeak() {
        showWithParen(); // 객체.메소드() 형태로 호출(없으면 앞에 this.가 생략된 것)
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
    
}
