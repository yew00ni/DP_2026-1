package ch04.A2.idcard;


import ch04.A2.framework.Factory;
import ch04.A2.framework.Product;

public class IDCardFactory extends Factory {
    private int serial = 100; // 공장에서 serial 번호를 관리

    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++); // 처음에는 100번(뒤에 ++이 붙었기 때문에 다음에 생성되는 카드는 101번이 됨)
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
