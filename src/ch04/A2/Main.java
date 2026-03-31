package ch04.A2;

import ch04.A2.framework.Product;
import ch04.A2.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        IDCardFactory factory = new IDCardFactory();
        Product card1 = factory.create("Youngjin Kim");
        Product card2 = factory.create("Heungmin Son");
        Product card3 = factory.create("Kane");

        card1.use();
        card2.use();
        card3.use();

        testOwnerMap(factory);
    }

    private static void testOwnerMap(IDCardFactory factory) {
        System.out.println("생성된 시리얼-오너 맵 테스트 결과:");
        factory.getOwnerMap().forEach((serial, owner) -> // 람다 함수
            System.out.println("시리얼 " + serial + "번 -> " + owner)
        );
    }
}
