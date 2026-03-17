package practice.ch02.inheritance;

// 이미 제공되는 클래스, vendor 클래스, 수정 불가
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() { // 괄호로 감싸서 출력
        System.out.println("(" + string + ")");
    }

    public void showWithAster() { // 별로 감싸서 출력
        System.out.println("*" + string + "*");
    }
}
