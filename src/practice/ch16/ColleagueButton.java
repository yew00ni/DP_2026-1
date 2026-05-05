package practice.ch16;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague { // java.awt.Button을 상속받고 Colleague 인터페이스를 구현
    private Mediator mediator;

    public ColleagueButton(String caption) { // caption : 버튼에 나타나는 글자
        super(caption); // 부모 생성자 호출
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator; // mediator를 받아서 자신의 mediator에 저장
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled); // 부모인 Button의 setEnabled 메소드를 호출하여 버튼의 활성/비활성 상태를 설정
    }
}
