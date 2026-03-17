package ch01.A1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Iterable<Book> {
    private List<Book> books; // List는 인터페이스

    public BookShelf(int initialsize) {
        this.books = new ArrayList<>(initialsize); // 기본적으로 10개 원소로 만들어지는 ArrayList를 초기 크기 initialsize로 생성하여 책을 관리
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book); // List 인터페이스의 add 메서드를 사용하여 책을 추가 
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
