package hw.ch06;

import hw.ch06.framework.Product;

public class BorderLine implements Product {
    private char borderChar;

    // 1. 생성자: 경계 문자를 인자로 받음
    public BorderLine(char borderChar) {
        this.borderChar = borderChar;
    }

    // 2. use() 메소드 구현
    @Override
    public void use(String s) {
        int blen = s.length();
        for (int i = 0; i < blen; i++) {
            System.out.print(borderChar);
        }
        System.out.println();
        System.out.println(s);
        for (int i = 0; i < blen; i++) {
            System.out.print(borderChar);
        }
        System.out.println();
    }

    // 3. createCopy() 메소드 구현(clone() 활용)
    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
