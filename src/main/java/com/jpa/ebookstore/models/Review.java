package com.jpa.ebookstore.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_review")
public class Review implements Serializable {

     @Serial
     private static final long serialVersionUID = 1L;

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private UUID id;

     @Column(nullable = false)
     private String comment;

     @OneToOne
     @MapsId
     private Book book;

     public Review(UUID id, String comment, Book book) {
          this.id = id;
          this.comment = comment;
          this.book = book;
     }
}
