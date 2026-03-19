package practice.ch02.delegation;

public class Main {
    public static void main(String[] args) {
        Print print = new PrintBannerAdapter02("Hello World"); // 어댑터 생성
        print.printWeak();
        print.printStrong();
    }
}
