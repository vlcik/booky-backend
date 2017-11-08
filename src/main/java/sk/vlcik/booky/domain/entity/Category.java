package sk.vlcik.booky.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Category implements Serializable {

    @Id
    @SequenceGenerator(name="category_seq", sequenceName="category_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private int status;
}
