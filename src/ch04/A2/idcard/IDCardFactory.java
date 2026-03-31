package ch04.A2.idcard;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ch04.A2.framework.Factory;
import ch04.A2.framework.Product;

public class IDCardFactory extends Factory {
    private int serial = 100; // 공장에서 serial 번호를 관리
    private final Map<Integer, String> ownerMap = new HashMap<>(); // Integer

    protected synchronized Product createProduct(String owner) {
        int assignedSerial = serial++;
        ownerMap.put(assignedSerial, owner);
        return new IDCard(owner, assignedSerial); // 처음에는 100번
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }

    public Map<Integer, String> getOwnerMap() {
        return Collections.unmodifiableMap(ownerMap);
    }
}
