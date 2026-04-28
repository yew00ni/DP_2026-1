package ch12.Sample;

public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, world."); // 중심 객체
        Display b2 = new SideBorder(b1, '#'); // 첫 번째 장식한 결과물
        Display b3 = new FullBorder(b2); // 두 번째 장식(첫 번째 장식한 결과물이 인자로 들어감)

        b1.show(); // 출력
        b2.show();
        b3.show();

        Display b4 =
                    new SideBorder(
                        new FullBorder(
                            new FullBorder(
                                new SideBorder(
                                    new FullBorder(
                                        new StringDisplay("Hello, world.")
                                    ),
                                    '*'
                                )
                            )
                        ),
                        '/'
                    );
        b4.show();
    }
}
