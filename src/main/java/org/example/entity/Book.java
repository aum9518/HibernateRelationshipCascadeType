package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Genre;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_gen")
    @SequenceGenerator(name = "book_gen",sequenceName = "book_seq",allocationSize = 1)
    private  Long id;
    private String name;
    private String country;
    @Column(name = "publisher_year")
    private LocalDate publishedYear;
    private int price;
    @Enumerated (EnumType.STRING)
    private Genre genre;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH})
    private Publisher publisher;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH})
    private Author author;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH})
    private Reader reader;

    public Book(String name, String country, LocalDate publishedYear, int price, Genre genre, Publisher publisher, Author author, Reader reader) {
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
        this.publisher = publisher;
        this.author = author;
        this.reader = reader;
    }

    public Book(String name, String country, LocalDate publishedYear, int price, Genre genre) {
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", publishedYear=" + publishedYear +
                ", price=" + price +
                ", genre=" + genre +
              //  ", publisher=" + publisher +
                ", author=" + author +
              //  ", reader=" + reader +
                '}';
    }
}
