package library.project.model;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="Book")
public class Book {
    @Id
    @Column(name="id_book" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_librarian")
    private Librarian librarian;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_category")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_section")
    private Section section;

    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Borrow> borrows;

    public Book(Long id, String title, String author, Librarian librarian, Category category, Section section, Collection<Borrow> borrows) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.librarian = librarian;
        this.category = category;
        this.section = section;
        this.borrows = borrows;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Collection<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(Collection<Borrow> borrows) {
        this.borrows = borrows;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", librarian=" + librarian +
                ", category=" + category +
                ", section=" + section +
                ", borrows=" + borrows +
                '}';
    }
}
