package sk.vlcik.booky.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Book", schema="public")
public class Book implements Serializable {

    @Id
    @SequenceGenerator(name="book_seq", sequenceName="book_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_seq")
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne
    private Category category;

    @Column
    private Status status;
}
