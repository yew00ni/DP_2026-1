package hw.ch04.idcard;

import hw.ch04.framework.Product; // 다른 패키지에 있는 Product 클래스를 사용하기 위해 import

public class IDCard extends Product {
    private String owner; // 카드 소유자 이름
    private int serial; // 신분증의 일련 번호를 저장하는 필드
    private String issuedDate; // 발급 날짜 (YYYY-MM-DD)

    IDCard(String owner, int serial) { // default
        System.out.println(owner + "의 카드를 " + serial + "번으로 만듭니다.");
        this.owner = owner;
        this.serial = serial;
    }

    IDCard(String owner, int serial, String issuedDate) {
        System.out.println(owner + "의 카드를 " + serial + "번으로 만듭니다.");
        this.owner = owner;
        this.serial = serial;
        this.issuedDate = issuedDate;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다."); // this는 이 객체 자신을 가리킴. toString()이 자동으로 호출됨
    }

    @Override
    // 이 객체의 문자열이 필요할 때 자동으로 호출되는 메소드
    //Object(최상위 클래스) 클래스의 toString() 메소드를 오버라이드
    public String toString() {
        return "[IDCard: owner=" + owner + ", serial=" + serial + ", issuedDate=" + issuedDate + "]";
    }

    public String getOwner() { // 신분증의 소유자 이름을 반환
        return owner;
    }

    public int getSerial() {
        return serial;
    }

    public String getIssuedDate() {
        return issuedDate;
    }
}
