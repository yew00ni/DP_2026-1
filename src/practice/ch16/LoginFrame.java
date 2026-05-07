package practice.ch16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator { // java.awt.Frame을 상속받고 ActionListener(버튼에서 발생하는 이벤트를 처리)와 Mediator 인터페이스를 구현
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // Colleague를 생성하고 배치한 후에 표시한다
    public LoginFrame(String title) {
        super(title); // title : GUI 프레임의 제목, 부모 생성자 호출(부모 생성자는 항상 생성자에서 맨 윗줄에 나와야 함)

        // 배경색을 설정한다
        setBackground(Color.lightGray); // 전체 프레임의 배경색을 연한 회색으로 설정

        // 레이아웃 매니저(GUI 컴포넌트들을 어떻게 배치할 것인지를 관리하는 객체)를 사용해 4×2 그리드를 만든다
        setLayout(new GridLayout(4, 2)); // 4행 2열

        // Colleague를 생성한다 => 생성했다고 해서 바로 보이는 것은 아님 => 반드시 배치해야 보임
        createColleagues();

        // 배치한다 
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        // 활성/비활성 초기 설정을 한다
        colleagueChanged(); // Colleague들이 상태가 변했을 때 중재자에게 통지하는 메서드(초기 설정을 위해 생성자에서 호출하게 되어 있음)

        // 표시한다 
        pack(); // 배치된 컴포넌트들을 정리시킴
        setVisible(true); // 정리한 걸 보이게 함
    }

    // Colleague를 생성한다
    @Override
    public void createColleagues() {
        // CheckBox
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true); // 같은 g를 전달했기 때문에 같은 그룹처럼 동작
        checkLogin = new ColleagueCheckbox("Login", g, false);

        // TextField
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*'); // 입력할 때마다 메시지 그대로 보이는 것이 아니라 '*'로 보이도록 설정

        // Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator를 설정한다 
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정(등록)
        checkGuest.addItemListener(checkGuest); // 자기자신이 리스너가 됨
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser); // 자기자신이 리스너가 됨
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this); // 중재자가 리스너가 됨
        buttonCancel.addActionListener(this);
    }

    // Colleage의 상태가 바뀌면 호출된다
    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) { // 게스트 로그인이면...
            // 게스트 로그인 
            textUser.setColleagueEnabled(false); // textUser는 비활성화
            textPass.setColleagueEnabled(false); // textPass는 비활성화
            buttonOk.setColleagueEnabled(true); // buttonOk는 활성화
        } else {
            // 사용자 로그인 
            textUser.setColleagueEnabled(true); // textUser는 활성화
            userpassChanged(); // textUser 또는 textPass의 변경이 있는 경우 처리하는 메소드를 따로 만들어 호출
        }
    }

    // textUser 또는 textPass의 변경이 있다 
    // 각 Colleage의 활성/비활성을 판정한다
    private void userpassChanged() {
        if (textUser.getText().length() >= 4) { // 사용자 이름이 입력이 된 경우, textUser가 비어 있지 않으면...
            textPass.setColleagueEnabled(true); // textPass는 활성화
            if (textPass.getText().length() >= 4) { // 비밀번호가 입력이 된 경우
                buttonOk.setColleagueEnabled(true); // buttonOk는 활성화
            } else { // 비밀번호가 입력이 안 된 경우
                buttonOk.setColleagueEnabled(false); // buttonOk는 비활성화
            }
        } else { // textUser가 비어 있으면...
            textPass.setColleagueEnabled(false); // textPass는 비활성화
            buttonOk.setColleagueEnabled(false); // buttonOk는 비활성화
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
