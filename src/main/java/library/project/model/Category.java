package library.project.model;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="Category")
public class Category {
    @Id
    @Column(name="id_category" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category" , fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Book> books;

    public Category(Long id, String categoryName, Collection<Book> books) {
        this.id = id;
        this.categoryName = categoryName;
        this.books = books;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}
