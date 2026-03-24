package hw.ch03;

public class StringDisplay extends AbstractDisplay { // 문자열을 출력
    private String string;  // 표시해야 하는 문자열 
    private int width;      // 문자열의 길이

    // 생성자 
    public StringDisplay(String string) {
        this.string = string;
        this.width = string.length(); // 문자열 길이를 담음
    }

    // 생성자 확장 : 반복 횟수를 인자로 받는 생성자 추가
    public StringDisplay(String string, int repeatCount) {
        super(repeatCount); // 부모 클래스의 생성자를 호출하여 반복 횟수를 설정
        this.string = string; // 생성자에서 문자열을 초기화
        this.width = string.length(); // 문자열 길이를 담음
    }

    @Override
    public void open() {
        printLine();
    }

    @Override // 골뱅이(@) : 어노테이션 -> 해당 메소드가 상위 메소드나 인터페이스에서 선언되었고 그것을 하위 메소드에서 오버라이드한다는 뜻
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    // open과 close에서 호출되어 "+----+" 문자열을 표시하는 메소드
    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-"); // 하이픈을 문자열 길이만큼 표시
        }
        System.out.println("+");
    }
}
