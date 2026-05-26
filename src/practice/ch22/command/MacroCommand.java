package practice.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;

// 여러 개의 명령을 모아서 관리하는 클래스
public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>(); // Deque : 양쪽에서 삽입과 삭제가 가능한 자료구조, 원소가 Command가 들어가는 배열

    // 실행 
    @Override
    public void execute() {
        for (Command cmd: commands) { // Command에 있는 명령을 하나씩 꺼내서 실행한다.
            cmd.execute(); // 리커시브 호출(재귀적 호출)
        }
    }

    // 추가 
    public void append(Command cmd) {
        if (cmd == this) { // 자기 자신을 추가하려고 하면 무한 루프가 발생할 수 있기 때문에 예외를 던진다.
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop(); // 나중에 들어온 명령을 꺼내라.
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear(); // 원소 다 삭제
    }
}
