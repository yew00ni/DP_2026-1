package practice.ch04;

import practice.ch04.idcard.IDCardFactory;
import practice.ch04.framework.Product;
// import practice.ch04.idcard.IDCard;

public class Main {
    public static void main(String[] args) {
        // (1) IDCard를 직접 만들어 보자
        // IDCard c = new IDCard("임예원");
        // c.use();

        // (2) 공장을 통해서 id카드를 만들어 보자
        IDCardFactory f = new IDCardFactory();
        Product c = f.create("임예원"); // Product 타입으로 선언(Factory의 create 메소드는 Product 타입을 반환하기 때문에)
        c.use();
    }
}