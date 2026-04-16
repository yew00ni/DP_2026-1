package practice.ch11;

public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name; // 이름을 반환
    }

    @Override
    public int getSize() {
        return size; // 크기를 반환
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this); // prefix : 부모 디렉터리의 이름, this : 자기 자신 (toString() 호출) 표시
    }
}
