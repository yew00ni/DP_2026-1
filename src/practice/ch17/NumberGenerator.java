package practice.ch17;

import java.util.ArrayList;
import java.util.List;

// 관찰 대상
public abstract class NumberGenerator {
    // Observer를 저장한다
    // Observer : 부모 타입 => 모든 종류의 관찰자들을 저장할 수 있다.
    // 관찰 대상은 구체적으로 어떤 관찰자가 자기를 관찰하는지 모른다. 알 필요가 없다. => 느슨한 결합
    private List<Observer> observers = new ArrayList<>(); // 관찰자 리스트를 생성한다

    // Observer를 추가한다 
    public void addObserver(Observer observer) {
        observers.add(observer); // 리스트에 추가
    }

    // Observer를 제거한다 
    public void deleteObserver(Observer observer) {
        observers.remove(observer); // 리스트에서 제거
    }

    // Observer에 통지한다 
    public void notifyObservers() {
        for (Observer o: observers) { // (집합체 변수 : 집합체의 요소) : for문을 이용해서 관찰자 리스트에 있는 모든 관찰자에게 통지한다
            o.update(this); // 관찰자에게 통지(인자 : 자기 자신 == 관찰 대상)
        }
    }

    // 수를 취득한다 
    public abstract int getNumber();

    // 수를 생성한다 
    public abstract void execute();
}
