package practice.ch12;

// 중심 컴포넌트("Hello, world." 같은 문자열을 표시하는 클래스)
public class StringDisplay extends Display {
    private String string; // 표시할 문자열 

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() { // 문자열의 길이를 return
        return string.length();
    }

    @Override
    public int getRows() {
        return 1; // 행수는 1
    }

    @Override
    public String getRowText(int row) {
        if (row != 0) { // 한 줄밖에 없기 때문에 0번째 Row밖에 없음
            throw new IndexOutOfBoundsException(); // 0이 아닌 다른 값이라면 잘못된 것
        }
        return string; // 0번째 행
    }
}
