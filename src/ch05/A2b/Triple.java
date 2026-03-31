package ch05.A2b;

public enum Triple {
    ALPHA, BETA, GAMMA; // 상수 3개(각 상수에 Triple 인스턴스가 하나씩 자동으로 생성되어 저장됨)

    private Triple() {
        System.out.println("The instance " + this + " is created.");
    }

    public static Triple getInstance(String name) {
        return valueOf(name);
    }
}
