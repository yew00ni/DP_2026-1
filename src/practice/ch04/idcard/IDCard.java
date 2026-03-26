package practice.ch04.idcard;

import practice.ch04.framework.Product; // 다른 패키지에 있는 Product 클래스를 사용하기 위해 import

public class IDCard extends Product {
    private String owner; // 카드 소유자 이름

    IDCard(String owner) { // default로 간주되어 같은 패키지에서만 사용 가능
        // super(); // 객체가 생성될 때 기본적으로 부모의 인자 없는 생성자가 가장 먼저 호출됨
        System.out.println(owner + "의 카드를 만듭니다."); // "의 카드를 만듭니다"와 +를 보고 toString()이 자동으로 호출됨
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다."); // this는 이 객체 자신을 가리킴. toString()이 자동으로 호출됨
    }

    @Override
    // 이 객체의 문자열이 필요할 때 자동으로 호출되는 메소드
    //Object(최상위 클래스) 클래스의 toString() 메소드를 오버라이드
    public String toString() {
        return "[IDCard:" + owner + "]";
    }

    public String getOwner() { // 신분증의 소유자 이름을 반환
        return owner;
    }
}
