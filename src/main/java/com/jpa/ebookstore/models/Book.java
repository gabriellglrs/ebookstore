package com.jpa.ebookstore.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_book")
public class Book implements Serializable {

     @Serial
     private static final long serialVersionUID = 1L;

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private UUID id;

     @Column(nullable = false, unique = true)
     private String title;

     @ManyToOne
     @JoinColumn(name = "publisher_id")
     private Publisher publisher;

     @ManyToMany
     @JoinTable(name = "tb_book_author",
             joinColumns = @JoinColumn(name = "book_id"),
             inverseJoinColumns = @JoinColumn(name = "author_id")
     )
     private Set<Author> authors = new HashSet<>();

     @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
     private Review review;


     public Book(UUID id, String title, Publisher publisher, Review review) {
          this.id = id;
          this.title = title;
          this.publisher = publisher;
          this.review = review;
     }
}
