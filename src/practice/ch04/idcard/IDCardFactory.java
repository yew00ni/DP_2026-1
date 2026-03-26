package practice.ch04.idcard;

import practice.ch04.framework.Factory;
import practice.ch04.framework.Product;

public class IDCardFactory extends Factory {
    @Override
    protected Product createProduct(String owner) { // owner을 받아서 IDCard를 만듦, Factory에서 Product 타입을 반환하기 때문에 Product로 선언
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) { // 제품을 등록하는 메소드. 여기서는 단순히 제품 정보를 출력
        System.out.println(product + "을 등록했습니다.");
    }
}
