package ch15.Sample;

import ch15.Sample.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
        // 퍼사드 이용
        PageMaker.makeWelcomePage("lyw@duksung.ac.kr", "welcome_yw.html"); // 메일 주소와 생성할 파일 이름 전달
    }
}
