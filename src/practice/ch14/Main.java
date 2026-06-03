package practice.ch14;

public class Main {
    public static void main(String[] args) {
        // 해결자 생성
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new OddSupport("Diana");

        // 사슬 형성
        alice.setNext(bob).setNext(charlie).setNext(diana); // alice -> bob -> charlie -> diana

        // 첫 해결자에게 트러블을 던져줌
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }

        // alice.support(new Trouble(100));
    }
}
