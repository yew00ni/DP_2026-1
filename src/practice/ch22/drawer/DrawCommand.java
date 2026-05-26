package practice.ch22.drawer;

import practice.ch22.command.Command;
import java.awt.Point;

// 점을 그리는 명령 클래스
public class DrawCommand implements Command {
    // 그리는 대상 
    protected Drawable drawable; // 그리는 대상을 보관(포함)

    // 그리는 위치 
    private Point position;

    // 생성자 
    public DrawCommand(Drawable drawable, Point position) { // 명령이 만들어짐
        this.drawable = drawable; // 어느 도화지에
        this.position = position; // 어느 좌표에 그릴 것인지 설정
    }

    // 실행
    @Override
    public void execute() { // 명령이 실행됨
        drawable.draw(position.x, position.y); // 점을 그리는 메서드 호출(도화지에 그려라)
    }
}
