package ch15.Sample.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// 퍼사드 클래스
public class PageMaker {
    private PageMaker() { // 생성자를 private으로 선언하여 인스턴스 생성을 막는다
    }

    public static void makeWelcomePage(String mailaddr, String filename) { // 퍼사드는 보통 static 메소드를 제공
        try {
            Properties mailprop = Database.getProperties("maildata");

            String username = mailprop.getProperty(mailaddr); // 이메일 주소(키)로 사용자 이름을 얻는다
            
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));

            // 웰컴페이지를 작성하는 부분
            writer.title(username + "'s web page");
            writer.paragraph("Welcome to " + username + "'s web page!");
            writer.paragraph("Nice to meet you!");
            writer.mailto(mailaddr, username);
            writer.close();
            
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
