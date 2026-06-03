package practice.ch14;

public class LimitSupport extends Support {
    private int limit; // 이 번호 미만이면 해결할 수 있다

    public LimitSupport(String name, int limit) {
        super(name); // 해결자 이름을 받아서 부모 생성자 호출
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit) { // 자신이 가지고 있는 limit보다 작으면 해결 가능
            return true;
        } else {
            return false;
        }
    }
}
