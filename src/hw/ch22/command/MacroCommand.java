package hw.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>();

    private Deque<Command> commandsForRedo = new ArrayDeque<>();

    // 실행 
    @Override
    public void execute() {
        // execute commands in insertion order (oldest first)
        commands.descendingIterator().forEachRemaining(cmd -> cmd.execute());
    }

    // 추가 
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) {
            // pop the most recent command and save it for redo
            Command cmd = commands.pop();
            commandsForRedo.push(cmd);
        }
    }

    // redo: restore the most recently undone command
    public void redo() {
        if (!commandsForRedo.isEmpty()) {
            Command cmd = commandsForRedo.pop();
            commands.push(cmd);
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();
        commandsForRedo.clear();
    }
}
