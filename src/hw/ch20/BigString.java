package hw.ch20;

public class BigString {
    // '큰 문자'의 배열
    private BigChar[] bigchars;

    // 생성자 
    public BigString(String string) { // "1212123"이 들어왔다고 가정
        BigCharFactory factory = BigCharFactory.getInstance();

        bigchars = new BigChar[string.length()];

        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i)); // string.charAt(i) : string에서 i번째 문자를 반환하는 method -> '1', '2', '1', '2', '1', '2', '3'이 차례로 들어감
        }
    }

    // 표시
    public void print() {
        for (BigChar bc: bigchars) {
            bc.print();
        }
    }

    // 색상 배열과 함께 표시
    public void print(String[] colors) {
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i].print(colors[i]);
        }
    }
}
