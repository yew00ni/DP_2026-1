package hw.ch03;

public class CharDisplay extends AbstractDisplay {
    private char ch; // 표시해야 하는 문자 

    // 생성자 
    public CharDisplay(char ch) {
        this.ch = ch;
    }

    // 생성자 확장 : 반복 횟수를 인자로 받는 생성자 추가
    public CharDisplay(char ch, int repeatCount) {
        super(repeatCount); // 부모 클래스의 생성자를 호출하여 반복 횟수를 설정
        this.ch = ch; // 생성자에서 문자를 초기화
    }

    @Override
    public void open() {
        // 시작 문자열 "<<"를 표시한다
        System.out.print("<<");
    }

    @Override
    public void print() {
        // 필드에 기억해 둔 문자를 1회 표시한다 
        System.out.print(ch);
    }

    @Override
    public void close() {
        // 종료 문자열 ">>"를 표시한다 
        System.out.println(">>");
    }
}
