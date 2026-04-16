package practice.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>(); // 컬렉션, 자식(엔트리)을 보관할 리스트, Entry : 부모 타입(디렉터리와 파일 모두 저장 가능)

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() { // 자기 자식들의 크기를 모두 더함(directory 변수에 모두 있음)
        int size = 0;
        for (Entry entry: directory) { // 형식 for(확장된 for문), (원소타입 변수 : 컬렉션)
            size += entry.getSize(); // 자식 엔트리의 크기를 얻어서 size에 더한다
        }
        return size;
    }

    @Override
    protected void printList(String prefix) { // prefix : 상위 디렉터리까지의 경로
        System.out.println(prefix + "/" + this); // 자기 출력
        for (Entry entry: directory) { // 자식에 대해서
            entry.printList(prefix + "/" + name); // 이전 경로에 자기 이름을 붙임
        }
    }

    // 디렉터리 엔트리를 디렉터리에 추가한다
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}
