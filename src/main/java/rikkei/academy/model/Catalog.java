package rikkei.academy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "catalog")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idC;
    private String nameC;

    @OneToMany(mappedBy = "catalog",targetEntity = Blog.class)
    private Set<Blog> blogs;

    public Catalog() {
    }

    public Catalog(Long idC, String nameC) {
        this.idC = idC;
        this.nameC = nameC;
    }

    public Long getIdC() {
        return idC;
    }

    public void setIdC(Long idC) {
        this.idC = idC;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }
}
