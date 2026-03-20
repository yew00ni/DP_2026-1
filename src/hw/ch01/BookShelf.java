package hw.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }

    // 지정한 장르의 책만 순회하는 Iterator
    public Iterator<Book> iteratorByGenre(String genre) {
        return new GenreIterator(this, genre);
    }

    // 최신 책부터 오래된 책 순서로 순회하는 Iterator
    public Iterator<Book> iteratorByYear() {
        return new YearDescIterator(this);
    }

}
