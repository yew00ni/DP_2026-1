package hw.ch12;

public class Main {
    public static void main(String[] args) {
        MultiStringDisplay md = new MultiStringDisplay();

        // [2-1] 원본 출력
        md.add("Hello, Java!");
        md.add("Decorator Pattern");
        md.add("is powerful.");
        md.show();

        // [2-2] NumberedBorder 단독 적용
        Display d1 = new NumberedBorder(md);
        d1.show();

        // [2-3] FullBorder + NumberedBorder 조합
        Display d2 = new FullBorder(new NumberedBorder(md));
        d2.show();

        // [2-4] SideBorder + NumberedBorder + FullBorder 3단 중첩
        Display d3 = new SideBorder(new NumberedBorder(new FullBorder(md)), '*');
        d3.show();
    }
}
