package hw.ch20;

import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    // 이미 만든 BigChar 인스턴스를 관리 
    private Map<String,BigChar> pool = new HashMap<>(); // 키(String), 값(BigChar)으로 이루어진 Map

    // Singleton 패턴 
    private static BigCharFactory singleton = new BigCharFactory(); // factory는 전체에서 하나만 팔요하기 때문에 singleton으로 생성

    // 생성자 
    private BigCharFactory() {
    }

    // 유일한 인스턴스를 얻는다
    public static BigCharFactory getInstance() {
        return singleton;
    }

    // BigChar 인스턴스 생성(공유)
    public synchronized BigChar getBigChar(char charname) { // '3'이 들어왔다고 가정
        // 이미 만들어진 BigChar 인스턴스가 있는지 검색
        BigChar bc = pool.get(String.valueOf(charname)); // 3을 String으로 바꿈 -> pool.get("3")

        if (bc == null) { // 이미 만들어진 BigChar 인스턴스가 없다면
            // 여기서 BigChar 인스턴스를 생성
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc);
        }
        return bc;
    }
}
