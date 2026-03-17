package practice.Ch01;

import java.util.Iterator; // Java.util은 Java가 기본으로 제공하는 패키지, Iterator라는 인터페이스를 import하여 사용, 제너릭
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookShelf; // Iterator가 책꽂이를 알고 있어야 책을 꺼낼 수 있음
    private int index; // 다음에 꺼내 올 책의 위치를 저장하는 필드

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf; // 자기가 돌아다닐 책꽂이를 저장하는 필드
        this.index = 0;
    }

    @Override // 위에서 물려받은 메소드를 재정의(Override)한다는 표시
    public boolean hasNext() { // 다음 요소(책)가 있는지 여부를 반환하는 메서드
        if (index < bookShelf.getLength()) {
            return true; // 꺼내 올 책이 남아 있음
        } else {
            return false; // 꺼내 올 책이 더 이상 없음
        }
    }

    @Override
    public Book next() { // 다음 책을 반환하는 메서드
        if (!hasNext()) { // 다음에 꺼내 올 책이 없는 경우
            throw new NoSuchElementException(); // throw : 예외를 생성(NoSuchElementException : JDK에 선언되어 있는 예외)
        }
        Book book = bookShelf.getBookAt(index); // index에 해당하는 책을 꺼내옴(반복자가 책꽂이에 접근)
        index++;
        return book;
    }
}
