package org.example.app.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Entity
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 200)
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();

    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    public void setCreated() {
        this.created = LocalDateTime.now();
    }

    public void setUpdated() {
        this.updated = LocalDateTime.now();
    }
}