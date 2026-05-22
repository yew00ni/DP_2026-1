package ch20.A1;

public class BigString {
    // 큰 문자의 배열 
    private BigChar[] bigchars;

    // 생성자(인수 없음, 공유한다)
    public BigString(String string) {
        initShared(string);
    }

    // 생성자(인수로 공유할지 말지 지정한다)
    public BigString(String string, boolean shared) {
        if (shared) { // shared가 true이면 BigChar를 공유
            initShared(string);
        } else { // shared가 false이면 BigChar를 공유하지 않고 새로 생성
            initUnshared(string);
        }
    }

    // 공유해서 초기화 
    private void initShared(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    // 공유하지 않고 초기화 
    private void initUnshared(String string) {
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = new BigChar(string.charAt(i)); // BigCharFactory를 사용하지 않고 BigChar 인스턴스를 새로 생성
        }
    }

    // 표시
    public void print() {
        for (BigChar bc: bigchars) {
            bc.print();
        }
    }
}
