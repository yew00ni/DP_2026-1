package ch04.A2.idcard;

import ch04.A2.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int serial; // 신분증의 일련 번호를 저장하는 필드

    IDCard(String owner, int serial) {
        System.out.println(owner + "의 카드를 " + serial + "번으로 만듭니다.");
        this.owner = owner;
        this.serial = serial;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + "(" + serial + ")]";
    }

    public String getOwner() {
        return owner;
    }

    public int getSerial() {
        return serial;
    }
}
