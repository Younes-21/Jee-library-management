package library.project.model;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="Section")
public class Section {
    @Id
    @Column(name="id_section" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sectName;

    @OneToMany(mappedBy = "section", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Book> books;

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public Section(Long id, String sectName, Collection<Book> books) {
        this.id = id;
        this.sectName = sectName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSectName() {
        return sectName;
    }

    public void setSectName(String sectName) {
        this.sectName = sectName;
    }

    public Section() {
    }

    public Section(Long id, String sectName) {
        this.id = id;
        this.sectName = sectName;
    }
}
