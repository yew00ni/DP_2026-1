package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenreIterator implements Iterator<Book> {
    private BookShelf bookShelf; // 탐색할 책꽂이
    private String genre; // 탐색할 장르
    private int index; // 다음에 꺼내 올 책의 위치를 저장하는 필드

    public GenreIterator(BookShelf bookShelf, String genre) { // 생성자
        this.bookShelf = bookShelf;
        this.genre = genre;
        this.index = 0; // 처음에는 책꽂이의 맨 앞에서 시작
    }

    @Override
    public boolean hasNext() {
        while (index < bookShelf.getLength()) {
            if (bookShelf.getBookAt(index).getGenre().equals(genre)) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
    
}
