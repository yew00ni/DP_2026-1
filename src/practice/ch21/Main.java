package practice.ch21;

public class Main {
    public static void main(String[] args) {
        // 본인에게 일을 시킴
        // Printable p1 = new Printer("Alice"); // 생성될 때 너무 오래 걸림
        // p1.print("Hello world");

        // 대리인을 생성해서 일을 시킴
        Printable p2 = new PrinterProxy(); // 생성될 때는 빨리 끝남
        p2.setPrinterName("Bob");
        System.out.println(p2.getPrinterName());
        
        p2.print("Hello world."); // 이 때 '본인'이 생성됨
    }
}
