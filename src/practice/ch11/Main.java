package practice.ch11;

public class Main {
    public static void main(String[] args) {
        // 디렉터리 트리를 만든다
        Directory root = new Directory("root");
        // Entry root = new Directory("root");

        
        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");
        Directory usr = new Directory("usr");

        root.add(bin);
        root.add(tmp);
        root.add(usr);

        bin.add(new File("vi", 10000));
        bin.add(new File("latex", 20000));


        // 경로 출력
        root.printList();
    }
}
