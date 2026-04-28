package practice.ch12;

// 장식자 1 : 내용물의 양쪽에 테두리를 붙이는 장식자
public class SideBorder extends Border {
    private char borderChar;  // 장식 문자(어떤 장식 문자로 장식할 것인지 지정)

    // 내용물이 될 Display와 장식 문자를 지정
    public SideBorder(Display display, char ch) { // 첫 번째 인자 : 장식 대상 
        super(display); // 부모 생성자(Border) 호출
        this.borderChar = ch;
    }

    // 예 : "Hello, workd." => "|Hello, world.|"
    @Override
    public int getColumns() {
        // 문자 수는 내용물의 양쪽에 장식 문자만큼 더한 것
        return 1 + display.getColumns() + 1; // 양쪽에 1씩 더해서 총 2를 더함
    }

    @Override
    public int getRows() {
        // 행수는 내용물의 행수와 같다 
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        // 지정 행의 내용은 내용물의 지정 행 양쪽에 장식 문자를 붙인 것
        return borderChar + display.getRowText(row) + borderChar;
    }
}
