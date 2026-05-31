package hw.ch20;

public class Main {
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        System.out.println("학번 : 20240823 / 이름 : 임예원");
        System.out.println();

        // 메모리를 많이 차지함(가정)
        BigChar bigChar = new BigChar('1');
        bigChar.print();

        // 공장을 통해서 BigChar 인스턴스를 얻는다
        BigCharFactory factory = BigCharFactory.getInstance();

        BigChar bigChar2 = factory.getBigChar('1');
        bigChar2.print();

        BigChar bigChar3 = factory.getBigChar('1');
        bigChar3.print();

        if (bigChar2 == bigChar3) {
            System.out.println("bigChar2와 bigChar3는 같은 인스턴스입니다.");
        } else {
            System.out.println("bigChar2와 bigChar3는 다른 인스턴스입니다.");
        }

        // BigString을 이용
        BigString bigString = new BigString("1212123");
        bigString.print();

        // 색상 배열과 함께 출력
        String[] colors = {RED, BLUE, GREEN, MAGENTA, CYAN, YELLOW, BLUE};
        bigString.print(colors);
    }
}
