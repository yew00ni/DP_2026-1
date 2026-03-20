package hw.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번 : 20240823 / 이름 : 임예원");
        System.out.println();

        BookShelf bookShelf = new BookShelf(10);
        bookShelf.appendBook(new Book("클린코드", "기술", 2008, 30000));
        bookShelf.appendBook(new Book("해리포터와 마법사의 돌", "소설", 1997, 15000));
        bookShelf.appendBook(new Book("사피엔스", "역사", 2011, 18000));
        bookShelf.appendBook(new Book("이펙티브 자바", "기술", 2018, 36000));
        bookShelf.appendBook(new Book("객체지향의 사실과 오해", "기술", 2015, 20000));
        bookShelf.appendBook(new Book("레미제라블", "소설", 1862, 12000));
        bookShelf.appendBook(new Book("총균쇠", "역사", 1997, 22000));
        bookShelf.appendBook(new Book("리팩터링", "기술", 2018, 34000));
        bookShelf.appendBook(new Book("로마인 이야기", "역사", 1992, 25000));
        bookShelf.appendBook(new Book("어린왕자", "소설", 1943, 9000));

        /*  명시적으로 Iterator를 사용하는 방법 
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        System.out.println();

        // 확장 for문을 사용하는 방법 
        for (Book book: bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println(); */

        // 장르가 소설인 책만 순회하는 Iterator
        Iterator<Book> novelIterator = bookShelf.iteratorByGenre("소설");
        System.out.println("<장르가 '소설'인 책들>");
        while (novelIterator.hasNext()) {
            Book book = novelIterator.next();
            System.out.println(book.getName() + "(" + book.getYear() + ")" + " - " + book.getGenre() + " - " + book.getPrice() + "원");
        }
        System.out.println();

        // 출판 연도 역순 순회 Iterator
        Iterator<Book> yearDescIterator = bookShelf.iteratorByYear();
        System.out.println("<출판 연도 최신순부터 출력>");
        while (yearDescIterator.hasNext()) {
            Book book = yearDescIterator.next();
            System.out.println(book.getName() + "(" + book.getYear() + ")" + " - " + book.getGenre() + " - " + book.getPrice() + "원");
        }
        System.out.println();

        // 출판 연도 역순 순회 Iterator(장르가 '소설'인 책만)
        Iterator<Book> yearGenreIterator = bookShelf.iteratorByYear();
        System.out.println("<장르가 '소설'인 책들을 출판 연도 최신순부터 출력>");
        while (yearGenreIterator.hasNext()) {
            Book book = yearGenreIterator.next();

            if (book.getGenre().equals("소설")) {
                System.out.println(book.getName() + "(" + book.getYear() + ")" + " - " + book.getGenre() + " - " + book.getPrice() + "원");
            }
        }
    }
}
