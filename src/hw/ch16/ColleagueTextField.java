package hw.ch16;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague { // java.awt.TextField를 상속받고 TextListener와 Colleague 인터페이스를 구현(TextField가 TextListener의 역할을 하면서 자기 자신이 리스너가 되는 구조)
    private Mediator mediator;

    public ColleagueTextField(String text, int columns) {
        super(text, columns); // text : default text, columns : 몇 columns로 할 것인지 설정
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled); // 부모로부터 물려받은 메소드를 호출
        // 활성/비활성에 맞게 배경색을 변경한다
        setBackground(enabled ? Color.white : Color.lightGray); // 부모인 TextField로부터 물려받은 메소드(true이면 배경색이 흰색, false이면 회색)
    }

    @Override
    public void textValueChanged(TextEvent e) { // 리스너 역할을 하기 위해 메소드를 구현, 텍스트가 하나씩 입력될 때마다 호출됨
        // 문자열이 변화했으면 Mediator에 알린다
        mediator.colleagueChanged();
    }
}
