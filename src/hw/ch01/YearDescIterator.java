package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class YearDescIterator implements Iterator<Book> {
    private BookShelf bookShelf; // 탐색할 책꽂이
    private boolean[] visited; // 이미 출력한 책인지 체크
    private int count = 0; // 지금까지 출력한 책의 수

    public YearDescIterator(BookShelf bookShelf) { // 생성자
        this.bookShelf = bookShelf; // 탐색할 책꽂이를 저장하는 필드
        this.visited = new boolean[bookShelf.getLength()]; // 책꽂이에 있는 책의 수만큼 체크 배열 생성
    }

    @Override
    public boolean hasNext() { // 다음에 꺼내 올 책이 있는지 여부를 반환하는 메서드
        if (count < bookShelf.getLength()) { // 아직 출력하지 않은 책이 남아 있으면
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() { // 다음 책을 반환하는 메서드
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int latestIndex = -1; // 가장 최신 책의 인덱스를 저장하는 변수
        int maxYear = -1; // 가장 최신 책의 출판 연도를 저장하는 변수

        for (int i = 0; i < bookShelf.getLength(); i++) { // 아직 방문하지 않은 책들 중에서 가장 연도가 큰 책의 인덱스 찾기
            if (!visited[i]) {
                Book currentBook = bookShelf.getBookAt(i);
                if (currentBook.getYear() > maxYear) { // 현재 책의 연도가 지금까지 찾은 가장 최신 책의 연도보다 크면
                    maxYear = currentBook.getYear();
                    latestIndex = i;
                }
            }
        }

        // 찾은 책을 방문 처리하고 카운트 증가
        if (latestIndex != -1) { // 최신 책이 하나라도 있으면
            visited[latestIndex] = true;
            count++;
            return bookShelf.getBookAt(latestIndex);
        }

        throw new NoSuchElementException(); // 최신 책이 하나도 없으면 예외 발생
    }
}