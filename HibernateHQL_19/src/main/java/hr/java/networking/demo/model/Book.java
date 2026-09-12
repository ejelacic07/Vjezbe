package hr.java.networking.demo.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NonNull
    private String title;


    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "publisher_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id"))
    Set<Publisher> publishers = new HashSet<>();


}
