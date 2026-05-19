package practice.ch20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    // 문자의 이름 
    private char charname;
    // 큰 문자를 표현하는 문자열('#' '.' '\n'으로 이루어진 열)
    private String fontdata;

    // 생성자 
    public BigChar(char charname) { // '3'이라고 가정
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt";

            StringBuilder sb = new StringBuilder(); // String을 만들 때 내용이 자꾸 바뀌는 경우에 String을 하나 구축(mutable)
            
            // 읽어온 것을 한줄씩 꺼내서 무언가를 함
            for (String line: Files.readAllLines(Path.of(filename))) { // Files : 파일이나 디렉토리에 동작하는 static method를 제공하는 클래스 / readAllLines : 파일의 모든 라인을 읽어서 List<String>으로 반환하는 static method
                // of를 이용하면 객체가 만들어짐 / Path : 파일 시스템의 경로를 나타내는 클래스 -> 경로를 나타내는 경로 객체가 만들어짐
                sb.append(line); // StringBuilder에 추가
                sb.append("\n");
            }
            this.fontdata = sb.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    // 큰 문자를 표시한다
    public void print() {
        System.out.print(fontdata);
    }
}
