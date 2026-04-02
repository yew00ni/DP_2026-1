package hw.ch05;

public enum LoggerEnum {
    INSTANCE; // enum의 유일한 인스턴스(상수)

    private StringBuilder logBuffer;

    private LoggerEnum() {
        System.out.println("[LoggerEnum] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder(); // 로그를 저장할 StringBuilder 초기화
    }

    public void log(String message) {
        logBuffer.append("[").append(System.currentTimeMillis()).append("]")
            .append(message).append("\n");
        System.out.println("[LoggerEnum]" + message);
    }

    public String getLog() {
        return logBuffer.toString();
    }
}
