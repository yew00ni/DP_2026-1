package hw.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry: directory) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    public Entry add(Entry entry) { // 자식 객체 추가 시에 자식 객체의 부모를 설정한다
        directory.add(entry);
        entry.setParent(this);
        return this;
    }

    @Override
    public List<Entry> search(String keyword) {
        List<Entry> result = new ArrayList<>();
        // 자신의 이름이 keyword를 포함하면 추가
        if (name.contains(keyword)) {
            result.add(this);
        }
        // 모든 자식의 search 결과를 병합
        for (Entry entry : directory) {
            result.addAll(entry.search(keyword));
        }
        return result;
    }
}
