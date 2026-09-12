package hr.java.jpa.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;


    @Getter @Setter
    @NonNull
    private String name;


    @OneToMany(mappedBy = "author")
    @Getter @Setter
    Set<Book> books = new HashSet<Book>();


}
