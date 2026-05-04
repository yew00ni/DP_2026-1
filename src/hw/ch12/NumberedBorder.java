package hw.ch12;

public class NumberedBorder extends Border {
    public NumberedBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        return display.getColumns() + 4; // 번호와 구분자 추가로 4칸 늘어남
    }

    @Override
    public int getRows() {
        return display.getRows(); // 행 수는 원본과 동일
    }

    @Override
    public String getRowText(int row) {
        return String.format("%2d| ", row + 1) + display.getRowText(row); // format을 사용하여 번호와 구분자 추가
    }
}