package practice.ch06;

import practice.ch06.framework.Manager;

public class Main {
    public static void main(String[] args) {
        /*
        // 원본을 이용
        MessageBox mbox1 = new MessageBox('*');
        mbox1.use("Hello, world.");

        UnderlinePen upen1 = new UnderlinePen('-');
        upen1.use("Hello, World");

        // 복제 객체를 이용
        mbox1.createCopy().use("Hello, world.");
        upen1.createCopy().use("Hello, World.");
        */

        // Manager를 이용

        // 준비
        Manager manager = new Manager();

        // 원본 객체 생성 및 등록
        MessageBox mbox1 = new MessageBox('*');
        manager.register("star box", mbox1);

        UnderlinePen upen1 = new UnderlinePen('-');
        manager.register("underline pen", upen1);

        MessageBox mbox2 = new MessageBox('/');
        manager.register("slash box", mbox2);

        // 복제 객체를 얻어와서 사용
        manager.create("star box").use("Hello, world.");
        manager.create("underline pen").use("Hello, world.");
        manager.create("slash box").use("Hello, world.");
    }
}
