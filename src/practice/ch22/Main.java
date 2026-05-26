package practice.ch22;

import practice.ch22.command.*;
import practice.ch22.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements MouseMotionListener, WindowListener { // JFrame : 창을 생성하는 클래스, MouseMotionListener : 마우스 움직임을 감지하는 인터페이스, WindowListener : 창의 상태 변화(확대, 숨기기 등)를 감지하는 인터페이스
    // 그리기 이력 
    private MacroCommand history = new MacroCommand(); // 명령을 모아서 관리하는 클래스

    // 그리는 영역 
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);

    // 삭제 버튼
    private JButton clearButton  = new JButton("clear"); // javax.swing 패키지의 JButton 클래스, 버튼을 생성하는 클래스

    // 생성자 
    public Main(String title) {
        super(title);

        this.addWindowListener(this); // 창의 상태 변화(확대, 숨기기 등)를 감지하는 인터페이스를 구현한 객체를 등록(this는 Main 객체를 가리킴, Main이 Listener의 역할을 함)

        canvas.addMouseMotionListener(this); // 마우스 움직임을 감지하는 인터페이스를 구현한 객체를 등록(this는 Main 객체를 가리킴, Main이 Listener의 역할을 함)

        clearButton.addActionListener(e -> { // 람다식, 버튼이 클릭되었을 때 실행되는 코드 블록, ActionListener 인터페이스의 actionPerformed 메서드를 구현한 것
            history.clear(); // clear 메서드를 호출하여 명령 이력을 삭제
            canvas.repaint(); // 아무것도 그리지 않은 상태로 그림
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS); // 가로 배치
        buttonBox.add(clearButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS); // 세로 배치
        mainBox.add(buttonBox); // mainbox에 추가
        mainBox.add(canvas);

        getContentPane().add(mainBox); // 창의 내용 영역에 mainBox를 추가

        pack();
        setVisible(true); // 창을 보이게 함
    }

    // MouseMotionListener용
    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouseMoved: " + e.getPoint());
    }

    // 커맨드 패턴의 핵심
    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("mouseDragged: " + e.getPoint());
        Command cmd = new DrawCommand(canvas, e.getPoint()); // 명령어 객체가 생성됨
        history.append(cmd); // 명령어 객체를 이력에 추가함
        cmd.execute(); // 명령어 객체를 실행함
    }

    // WindowListener용 
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample"); // Main 객체가 생성되고 생성자에서 창이 보이게 됨
    }
}
