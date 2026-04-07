package ch06.A1b;

import ch06.A1b.framework.ConcreteProduct;

public class UnderlinePen extends ConcreteProduct { // ConcreteProduct 클래스를 상속받은 클래스
    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int ulen = s.length();
        System.out.println(s);
        for (int i = 0; i < ulen; i++) {
            System.out.print(ulchar);
        }
        System.out.println();
    }
}
