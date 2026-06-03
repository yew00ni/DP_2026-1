package practice.ch14;

public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 1) { // 홀수인 경우 해결 가능(나머지가 1인 경우)
            return true;
        } else {
            return false;
        }
    }
}
