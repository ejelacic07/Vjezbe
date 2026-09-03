package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter @Setter
    private LocalDate startDate;
    @Getter @Setter
    private int duration;
    @Getter @Setter
    private BigDecimal payment;


    @ManyToMany(mappedBy = "contracts")
    @Getter @Setter
    private Set<Person> employees = new HashSet<Person>();

    @ManyToMany(mappedBy = "contracts")
    @Getter @Setter
    private Set<Company> companies = new HashSet<Company>();


}
