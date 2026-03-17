package practice.Ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> { // Iterable은 Java.lang 패키지에 선언되어 있는데 Java.lang 패키지는 import할 필요 없음
// public class BookShelf {
    private Book[] books; // 책 타입의 책 배열(배열에 의해 관리됨)
    private int last = 0;

    public BookShelf(int maxsize) { // 생성자(책꽂이의 최대 크기)
        this.books = new Book[maxsize]; // 책을 maxsize만큼 가짐
    }

    public Book getBookAt(int index) { // 책을 꺼내오는 메소드
        return books[index]; // index에 해당하는 책을 반환
    }

    public void appendBook(Book book) { // 책을 꽂는 메소드
        this.books[last] = book; // last에 꽂음(직전에 꽃은 위치 + 1)
        last++;
    }

    public int getLength() { // 책이 현재 몇 권 꽂혀있는지
        return last; // last를 반환
    }

    @Override
    public Iterator<Book> iterator() {
       return new BookShelfIterator(this); // 인자를 현재 책꽂이 자신으로 넘겨줌
    }
}
