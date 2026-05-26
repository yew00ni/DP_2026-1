package practice.ch22.command;

// 명령을 표현한 클래스
public interface Command {
    public abstract void execute(); // 이 명령이 하는 일(구현하느냐에 따라 다름)
}
