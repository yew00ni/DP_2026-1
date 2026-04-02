package hw.ch05;

public class LoggerSynchronizedLazy {
    private static LoggerSynchronizedLazy instance = null; // 미리 생성하지 않고 null로 초기화

    private StringBuilder logBuffer;

    private LoggerSynchronizedLazy() {
        System.out.println("[LoggerSynchronizedLazy] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder(); // 로그를 저장할 StringBuilder 초기화
    }

    public static synchronized LoggerSynchronizedLazy getInstance() {
        if (instance == null) {
            instance = new LoggerSynchronizedLazy();
        }
        return instance;
    }

    public void log(String message) {
        logBuffer.append("[").append(System.currentTimeMillis()).append("]")
            .append(message).append("\n");
        System.out.println("[LoggerSynchronizedLazy]" + message);
    }

    public String getLog() {
        return logBuffer.toString();
    }
}
