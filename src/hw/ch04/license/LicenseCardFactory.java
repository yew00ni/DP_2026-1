package hw.ch04.license;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class LicenseCardFactory extends Factory {
    int licenseCounter; // 면허번호 카운터(100부터 시작)
    String baseDate; // 발급 기준 날짜

    public LicenseCardFactory(String baseDate) { // 생성자에서 발급 기준 날짜를 받아서 초기화
        this.baseDate = baseDate;
        this.licenseCounter = 100; // 면허번호는 100부터 시작
    }

    @Override
    protected Product createProduct(String holder) { // 운전자명을 받아서 LicenseCard를 만듦, Factory에서 Product 타입을 반환하기 때문에 Product로 선언
        int licenseNumber = licenseCounter++;
        String expiryDate = calculateExpiryDate(baseDate);
        return new LicenseCard(holder, licenseNumber, baseDate, expiryDate);
    }

    @Override
    protected void registerProduct(Product product) { // 제품을 등록하는 메소드. 여기서는 단순히 제품 정보를 출력
        System.out.println(product + "을 등록했습니다.");
    }

    private String calculateExpiryDate(String issuedDate) { // 발급 날짜로부터 1년 후의 날짜를 계산하는 메소드
        String[] parts = issuedDate.split("-");
        int year = Integer.parseInt(parts[0]) + 5; // 발급 날짜로부터 5년 후가 만료 날짜
        return year + "-" + parts[1] + "-" + parts[2];
    }
}
