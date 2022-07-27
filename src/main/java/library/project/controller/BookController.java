package library.project.controller;
import library.project.dao.SectionRepository;
import library.project.dao.CategoryRepository;
import library.project.model.*;
import library.project.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import library.project.model.Librarian;
import library.project.dao.LibrarianRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    LibrarianRepository librarianRepository;
    // Get all books
    @GetMapping(path="/books")
    public String books(Model model){
        List<Book> books=bookRepository.findAll();
        model.addAttribute("listBooks", books);
        return "books";
    }
    //it sends you to the create book form
    @GetMapping(path ="/createbook")
    public String create(Model model){

        List <Category> categories = categoryRepository.findAll();
        model.addAttribute("categories",categories);
        List <Section> sections = sectionRepository.findAll();
        model.addAttribute("sections",sections);
        List <Librarian> librarians = librarianRepository.findAll();
        model.addAttribute("librarians",librarians);

        return "createbook";
    }

    // to save a created book in the database
    @PostMapping("/createdbook")
    public String saveBook(Book book){
        bookRepository.save(book);
        return "redirect:/books";
    }

    //Get books data to update it
    @GetMapping("/editbook")
    public String edit( Model model , Long id){
        List <Category> categories = categoryRepository.findAll();
        model.addAttribute("categories",categories);
        List <Section> sections = sectionRepository.findAll();
        model.addAttribute("sections",sections);
        List <Librarian> librarians = librarianRepository.findAll();
        model.addAttribute("librarians",librarians);
        Optional<Book> book = bookRepository.findById(id);
        model.addAttribute("book", book);
        return "editbook";
    }
    //to delete a client
    @GetMapping("/deletebook")
    public String delete(Long id){
        bookRepository.deleteById(id);
        return "redirect:/books";
    }

}
