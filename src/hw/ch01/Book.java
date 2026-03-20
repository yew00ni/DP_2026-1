package hw.ch01;

public class Book {
    private String name;
    private String genre; // 장르: "소설", "과학", "역사", "기술" 등
    private int year; // 출판연도 (예: 2008)
    private double price; // 가격 (단위: 원, 예: 30000.0)

    public Book(String name) { // 기존 생성자
        this.name = name;
    }

    public Book(String name, String genre, int year, double price) { // 생성자 오버로딩
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }
}
