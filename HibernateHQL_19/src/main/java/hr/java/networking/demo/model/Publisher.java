package hr.java.networking.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor

public class Publisher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;


    @Getter
    @Setter
    @NonNull
    private String name;


    @Getter
    @Setter
    @ManyToMany(mappedBy = "publishers")
    Set<Book> books = new HashSet<Book>();


    public void addBook(Book book) {
        books.add(book);
        book.getPublishers().add(this);
    }



}
