package practice.ch22.drawer;

import practice.ch22.command.MacroCommand;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DrawCanvas extends Canvas implements Drawable {
    // 그리는 색 
    private Color color = Color.red; // default로 빨간색을 지정
    // 그리는 점의 반지름 
    private int radius = 6;
    // 이력 
    private MacroCommand history;

    // 생성자 
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    // 이력 전체 다시 그리기 
    @Override
    public void paint(Graphics g) { // 그래픽스 객체를 이용해서 그리는 것, repaint()가 호출되면 자동으로 호출됨
        history.execute();
    }

    // 그리기 
    @Override
    public void draw(int x, int y) { // x, y 좌표에 점을 그림
        Graphics g = getGraphics(); // 그래픽스 객체를 얻어옴
        g.setColor(color); // 색상 지정
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2); // fillOval : 채워진 원을 그림, 인자는 4개 필요
    }
}
