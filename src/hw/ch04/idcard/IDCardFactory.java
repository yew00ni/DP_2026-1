package hw.ch04.idcard;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class IDCardFactory extends Factory {
    private int serial = 100; // 공장에서 serial 번호를 관리
    private final Map<Integer, String> ownerMap = new HashMap<>(); // Integer
    private String baseDate; // 카드 발급 기준 날짜

    public IDCardFactory(String baseDate) {
        this.baseDate = baseDate;
    }

    @Override
    protected Product createProduct(String owner) { // owner을 받아서 IDCard를 만듦, Factory에서 Product 타입을 반환하기 때문에 Product로 선언
        int assignedSerial = serial++;
        ownerMap.put(assignedSerial, owner); // ownerMap에 serial 번호와 owner 이름을 저장
        return new IDCard(owner, assignedSerial, baseDate); // baseDate를 사용하여 발급 날짜 설정
    }

    @Override
    protected void registerProduct(Product product) { // 제품을 등록하는 메소드. 여기서는 단순히 제품 정보를 출력
        System.out.println(product + "을 등록했습니다.");
    }

    public Map<Integer, String> getOwnerMap() {
        return Collections.unmodifiableMap(ownerMap);
    }
}
