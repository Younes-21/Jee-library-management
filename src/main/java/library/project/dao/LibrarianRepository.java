package library.project.dao;
import library.project.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    List<Librarian> findByUsernameAndPassword(String username, String password);
}
