package ch12.A2;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    // 표시 문자열 저장 장소
    private List<String> body = new ArrayList<>(); // String을 담는 List 하나를 만듦
    // 표시 문자열 최대 문자 수 
    private int columns = 0; // 현재 최대 문자 수

    // 문자열 추가 
    public void add(String msg) { // String 추가
        body.add(msg);
        if (columns < msg.length()) { // 입력으로 들어온 문자열이 최대 문자 수보다 길면
            // 최대 문자 수 갱신
            columns = msg.length();
        }
        updatePadding();
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size();
    }

    @Override
    public String getRowText(int row) {
        return body.get(row);
    }

    // 표시 문자열 오른쪽 끝에 채울 공백을 필요에 따라 늘린다
    private void updatePadding() {
        for (int row = 0; row < body.size(); row++) { // 리스트에 들어있는 문자열만큼 반복
            String line = body.get(row);
            int padding = columns - line.length(); // 채워야 할 빈칸 수
            if (padding > 0) {
                body.set(row, line + spaces(padding));
            }
        }
    }

    // count 수만큼의 공백을 만든다 
    private String spaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(' ');
        }
        return spaces.toString();
    }
}
