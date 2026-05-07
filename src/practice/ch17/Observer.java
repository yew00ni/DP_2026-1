package practice.ch17;

// 관찰자
public interface Observer {
    public abstract void update(NumberGenerator generator); // 통지받을 때 호출되는 메서드(관찰자를 인자로 받아서 수행)
}
