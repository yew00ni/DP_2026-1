package hw.ch19;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번 : 20240823 / 이름 : 임예원");
        System.out.println();

        SafeFrame frame = new SafeFrame("State Sample");
        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);   // 시간 설정 
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
