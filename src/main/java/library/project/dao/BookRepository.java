package library.project.dao;
import library.project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface BookRepository extends JpaRepository<Book, Long>{

}
