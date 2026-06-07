package hw.ch22.drawer;

import hw.ch22.command.Command;
import java.awt.Color;

public class ColorCommand implements Command {
    // 그리기 대상 
    protected Drawable drawable; // 도화지
    // 그리기 색 
    private Color color; // 색상 정보

    // 생성자 
    public ColorCommand(Drawable drawable, Color color) { // 어느 도화지에 어떤 색으로 그릴 것인지
        this.drawable = drawable;
        this.color = color;
    }

    // 실행 
    @Override
    public void execute() {
        drawable.setColor(color); // 도화지의 색상 설정
    }
}
