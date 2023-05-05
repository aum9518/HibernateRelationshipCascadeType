package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.entity.Reader;
import org.example.enums.Gender;
import org.example.enums.Genre;
import org.example.service.serviceImpl.AuthorServiceImpl;
import org.example.service.serviceImpl.BookServiceImpl;
import org.example.service.serviceImpl.PublisherServiceImpl;
import org.example.service.serviceImpl.ReaderServiceImpl;
import org.example.util.Util;

import java.time.LocalDate;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        Util.getEntityManager();
        AuthorServiceImpl author = new AuthorServiceImpl();
        BookServiceImpl book = new BookServiceImpl();
        PublisherServiceImpl publisher = new PublisherServiceImpl();
        ReaderServiceImpl reader = new ReaderServiceImpl();

//        System.out.println(publisher.savePublisher(new Publisher("Erkindik", "Jah gvardia 112")));
//        System.out.println(publisher.getPublisherById(1L));
//        System.out.println(publisher.getAllPublishersBySortedName());
//        System.out.println(publisher.updatePublisher(1L, new Publisher("Jahtyk", "Chuy 57")));
//        System.out.println(publisher.deletePublisherByName("Jahtyk"));

//        System.out.println(author.saveAuthor(new Author("Manas", "Abdugani uulu", "manas@gmail.com", LocalDate.of(1995, 1, 1), "Bishkek", Gender.MALE)));
//        System.out.println(author.updateAuthor(1L, new Author("Bek", "Jumabekov", "bek@gmail.com", LocalDate.of(1995, 1, 1), "Bishkek", Gender.MALE)));
//        System.out.println(author.getAuthorById(1L));
//        System.out.println(author.getAuthorsByPublisherId(1L));
//        System.out.println(author.assignAuthorToPublisher(1L, 1L));
//        System.out.println(author.deleteAuthorById(1L));

//        System.out.println(book.saveBook(new Book("Asman", "KG", LocalDate.of(2022, 1, 1), 500, Genre.ROMANTIC,new Publisher("Bulak","Kiev 23"),new Author("Nur","Jumabekov","nur@gmail.com",LocalDate.of(2001,1,1),"Bishkek",Gender.MALE),new Reader("Tilek",23,"tilek@gmail.com"))));
//        System.out.println(book.updateBookAuthor(2L, 1L));
//        System.out.println(book.getBookAndPublisherByBookId(3L));
//        System.out.println(book.deleteBookByAuthorId(2L));

//        System.out.println(reader.saveReader(new Reader("Bolot", 21, "bolot@gmail.com",new Book("Jash","KG",LocalDate.of(2021,1,1),600,Genre.PSYCHOLOGY))));
//        System.out.println(reader.updateReader(1L, new Reader("Juma", 24, "juma@gmail.com")));
//        System.out.println(reader.getReaderByBookId(7L));
        System.out.println(reader.getReadersByAuthorId(5L));

    }
}
