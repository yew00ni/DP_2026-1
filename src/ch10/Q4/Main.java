package ch10.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A"); // asList : 안에 원소들을 이용해서 List를 만들어주는 메소드

        // 사전순으로 작은 순서(오름차순)
        list.sort(new Comparator<String>() { // Stringㅌ 타입의 객체 비교(문자열 비교), Comparator는 인터페이스이기 때문에 new할 수 없지만 메소드를 안에서 구현해주면 new 사용 가능, Comparator : Functional Interface(compare 메서드 하나만 존재)
            @Override // Interface의 메소드인 compare를 구현
            public int compare(String s1, String s2) {
                return s1.compareTo(s2); // s1이 s2보다 사전순으로 작으면 음수, 같으면 0, 크면 양수 반환
            }
        }); // 오름차순을 위한 Comparator를 넣어줌
        System.out.println(list);

        list.sort((s1, s2) -> s1.compareTo(s2)); // 람다 표현식으로 간결하게 작성

        // 사전순으로 큰 순서(내림차순)
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1); // s2가 s1보다 사전순으로 작으면 음수, 같으면 0, 크면 양수 반환
            }
        }); // 내림차순을 위한 Comparator를 넣어줌
        System.out.println(list);
    }
}


/* 
1. Comparator<T> -> T : T 타입의 객체를 비교하는 데 사용되는 인터페이스(ex. Comparator<String> : String 타입의 객체를 비교함) 
2. compare(T o1, T o2) : 두 객체를 비교하여 정렬 순서를 결정하는 메소드 */
