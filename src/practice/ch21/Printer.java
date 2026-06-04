package practice.ch21;

// 본인
public class Printer implements Printable {
    private String name; // 이름 

    // 생성자 
    public Printer() {
        heavyJob("Printer 인스턴스 생성 중");
    }

    // 생성자(이름 지정)
    // 본인 객체는 생성될 때 시간이 오래 걸림
    public Printer(String name) {
        this.name = name;
        heavyJob("Printer 인스턴스(" + name + ") 생성 중");
    }

    // 이름 설정 
    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    // 이름 취득 
    @Override
    public String getPrinterName() {
        return name; // 이름을 반환
    }

    // 이름 붙여서 표시
    @Override
    public void print(String string) {
        System.out.println("=== " + name + " ==="); // 이름을 찍음
        System.out.println(string); // 인자로 들어온 string을 표시
    }

    // 무거운 작업이라고 가정
    // 시간이 오래 걸리는 작업
    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000); // CPU를 1초간 내놓음
            } catch (InterruptedException e) {
            }
            System.out.print("."); // 1초 쉬고 점을 하나 찍음
        }
        System.out.println("완료");
    }
}
