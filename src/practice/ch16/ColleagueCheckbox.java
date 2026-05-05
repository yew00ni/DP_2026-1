package practice.ch16;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague { // java.awt.Checkbox를 상속받고 ItemListener와 Colleague 인터페이스를 구현(자기 자신이 리스너가 됨)
    private Mediator mediator;

    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
        super(caption, group, state); // caption : 체크박스에 나타나는 글자, group : 체크박스 그룹, state : 체크박스의 초기 상태(true이면 체크된 상태, false이면 체크되지 않은 상태)
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다(중재자가 지시 내릴 때 사용)
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled); // 부모인 Checkbox의 setEnabled 메소드를 호출하여 체크박스의 활성/비활성 상태를 설정
    }

    @Override
    public void itemStateChanged(ItemEvent e) { // item 이벤트가 발생할 때마다 호출됨
        // 상태가 변화하면 Mediator에 알린다
        mediator.colleagueChanged();
    }
}
