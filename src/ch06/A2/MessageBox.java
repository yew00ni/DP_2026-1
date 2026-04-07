package ch06.A2;

import ch06.A2.framework.Product;

public class MessageBox implements Product {
    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    // 복사 생성자 
    public MessageBox(MessageBox prototype) { // 복사 생성자 : 자기 자신을 매개변수로 받음
        this.decochar = prototype.decochar; // 속성값을 복사하여 새로운 객체를 생성함
    }

    @Override
    public void use(String s) {
        int decolen = 1 + s.length() + 1;
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar);
        }
        System.out.println();
        System.out.println(decochar + s + decochar);
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        return new MessageBox(this); // 자기 복제 : 자기 자신을 매개변수로 해서 복사 생성자를 호출하여 새로운 객체를 생성하여 반환
    }
}
