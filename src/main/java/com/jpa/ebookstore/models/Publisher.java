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
@Table(name = "TB_PUBLISHER")
public class Publisher implements Serializable {

     @Serial
     private static final long serialVersionUID = 1L;

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private UUID id;

     @Column(nullable = false, unique = true)
     private String nome;

     @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
     private Set<Book> books = new HashSet<>();

     public Publisher(UUID id, String nome) {
          this.id = id;
          this.nome = nome;
     }
}
