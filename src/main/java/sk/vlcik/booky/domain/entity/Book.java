package sk.vlcik.booky.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Book", schema="public")
public class Book implements Serializable {

    @Id
    @SequenceGenerator(name="book_seq", sequenceName="book_id_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_seq")
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", updatable = false, insertable = false, nullable=false)
    private Author author;

    @OneToOne
    private Category category;

    @Column
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author.getName() +
                ", category=" + category.getName() +
                ", status=" + status +
                '}';
    }
}
