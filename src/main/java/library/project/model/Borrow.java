package library.project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="Borrow")

public class Borrow  {
    @Id
    @Column(name="id_borrow" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_book")
    private Book book;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_client")
    private Client client;

    private Date dateBegin;


    private Date dateEnd;

    private boolean returned = false;

    public Borrow() {
    }

    public Borrow(Long id, Book book, Client client, Date dateBegin, Date dateEnd, boolean returned) {
        this.id = id;
        this.book = book;
        this.client = client;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.returned = returned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", book=" + book +
                ", client=" + client +
                ", dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", returned=" + returned +
                '}';
    }
}
