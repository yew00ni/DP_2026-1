package practice.ch14;

// 트러블 해결자
public abstract class Support { // 추상 클래스
    private String name;    // 이 트러블 해결자 이름
    private Support next;   // 떠넘길 곳(Support : 부모 타입 => 모든 종류의 트러블 해결자를 가리킬 수 있음)

    public Support(String name) {
        this.name = name;
        this.next = null; // 뒷사람은 아직 없음
    }

    // 떠넘길 곳을 설정한다
    public Support setNext(Support next) { // Support : 부모 타입 => 모든 종류의 트러블 해결자를 가리킬 수 있음
        this.next = next;
        return next;
    }

    // 트러블 해결을 요청하는 메서드(클라이언트가 해당 문제를 해결해달라고 요청할 때 호출하는 메서드)
    public void support(Trouble trouble) {
        if (resolve(trouble)) { // resolve : 해결하는 메서드, 자기가 해결하려고 함
            done(trouble); // 성공하면 해결했다고 선언
        } else if (next != null) { // 자기가 해결 못 했는데 뒷 사람이 있으면, 즉 떠넘길 곳이 있는지 확인
            next.support(trouble); // 뒷사람에게 해결을 떠넘김
        } else { // 자기도 해결 못 했고, 뒷사람도 없으면...
            fail(trouble); // 해결 못했다고 선언
        }
    }

    // 트러블 해결자의 문자열 표현
    @Override
    public String toString() {
        return "[" + name + "]"; // 해결자의 이름을 보내줌
    }

    // 해결하려고 한다
    protected abstract boolean resolve(Trouble trouble); // 추상 메서드 => 자식들이 해결하는 방법을 결정(구현)

    // 해결했다 
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + "."); // 해결했다고 출력
    }

    // 해결되지 않았다 
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved."); // 해결 못했다고 출력
    }
}
