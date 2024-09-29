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

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_publisher")
public class Publisher implements Serializable {

     @Serial
     private static final long serialVersionUID = 1L;

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     private String nome;

     @OneToMany(mappedBy = "publisher")
     private Set<Book> books = new HashSet<>();

     public Publisher(Long id, String nome) {
          this.id = id;
          this.nome = nome;
     }
}
