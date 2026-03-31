package hw.ch04.license;

import hw.ch04.framework.Product;

public class LicenseCard extends Product {
    String holder; // 운전자명
    int licenseNumber; // 면허번호
    String issuedDate; // 발급 날짜
    String expiryDate; // 만료 날짜

    LicenseCard(String holder, int licenseNumber, String issuedDate, String expiryDate) {
        this.holder = holder;
        this.licenseNumber = licenseNumber;
        this.issuedDate = issuedDate;
        this.expiryDate = expiryDate;
    }

    @Override
    public void use() {
        System.out.println("운전면허증을 사용합니다.");
    }

    @Override
    // 이 객체의 문자열이 필요할 때 자동으로 호출되는 메소드
    //Object(최상위 클래스) 클래스의 toString() 메소드를 오버라이드
    public String toString() {
        return "[LicenseCard:" + holder + "(" + licenseNumber + ")] - 유효기간:" + issuedDate + " ~ " + expiryDate;
    }
}
