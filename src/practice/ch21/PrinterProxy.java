package practice.ch21;
public class PrinterProxy implements Printable {
    private String name;	// 이름

    private Printer real;	// '본인'(본인을 대신해서 일을 하다가 수행하지 못할 것 같으면 본인에게 일을 시켜야 하기 때문에 항상 가리키고 있어야 함)

    // 생성자 
    public PrinterProxy() {
        this.name = "No Name";
        this.real = null;
    }

    // 생성자(이름 지정)
    public PrinterProxy(String name) {
        this.name = name;
        this.real = null;
    }

    // 이름 설정 
    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) { // '본인'이 이미 존재한다면
            // '본인'에게도 설정한다
            real.setPrinterName(name);
        }
        this.name = name;
    }

    // 이름 취득 
    @Override
    public String getPrinterName() {
        return name;
    }

    // 표시 
    @Override
    public void print(String string) {
        realize(); // 본인을 생성한다(생성되어 있지 않으면)
        real.print(string); // 본인에게 요청
    }

    // 본인 생성 
    private synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }
}
