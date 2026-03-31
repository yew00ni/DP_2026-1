package ch05.A2a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Triple {
    // 클래스 로드시 실행
    private static Map<String,Triple> map = new HashMap<>();
    static {
        String[] names = { "ALPHA", "BETA", "GAMMA" };
        // names 배열의 각 요소에 대해 Triple 인스턴스를 생성하여 map에 저장
        Arrays.stream(names).forEach(s -> map.put(s, new Triple(s))); // stream : 시냇물(원소가 하나씩 떠다님)
    }

    private String name;

    private Triple(String name) {
        System.out.println("The instance " + name + " is created.");
        this.name = name;
    }

    public static Triple getInstance(String name) {
        return map.get(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
