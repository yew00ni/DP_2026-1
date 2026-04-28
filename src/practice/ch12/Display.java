package practice.ch12;

// 장식 대상을 나타냄
public abstract class Display {
    public abstract int getColumns();           	// 가로 문자 수를 얻는다
    public abstract int getRows();              	// 세로 행수를 얻는다
    public abstract String getRowText(int row); 	// row행째 문자열을 얻는다

    // 모든 행을 표시한다(템플릿 메소드)
    public void show() { // Template Method
        for (int i = 0; i < getRows(); i++) { // 세로 행의 개수만큼 반복
            System.out.println(getRowText(i)); // i번째 행의 문자열을 표시 => 모든 문자열 표시
        }
    }
}
