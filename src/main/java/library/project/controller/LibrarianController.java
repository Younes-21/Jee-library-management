package library.project.controller;

import library.project.model.Librarian;
import library.project.dao.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class LibrarianController {

    @Autowired
     LibrarianRepository librarianRepository;
// Get all librarians
    @GetMapping(path="/librarians")
    public String librarians(Model model){
        List<Librarian> librarians=librarianRepository.findAll();
        model.addAttribute("listLibrarians", librarians);
        return "librarians";
    }
//it sends you to the create librarian form
    @GetMapping(path ="/createlibrarian")
    public String create(){
        return "createlibrarian";
    }


// to save a created librarian in the database
    @PostMapping("/created")
    public String saveLibrarian(Librarian librarian){
         librarianRepository.save(librarian);
         return "redirect:/librarians";
    }

 // update librarian
   @GetMapping("/edit")
    public String edit(  Model model , Long id ){
        Optional<Librarian> librarian = librarianRepository.findById(id);
        model.addAttribute("librarian",librarian);
        return "editlibrarian";

    }
   /* @PostMapping("/save")
    public String savelibrarian(@ModelAttribute("librarian") Librarian librarian) {
        // save the book
        librarianRepository.save(librarian);
        // use a redirect to prevent duplicate submissions
        return "redirect:/librarians";
    }*/
    //to delete a librarian
    @GetMapping("/delete")
    public String delete(Long id){
        librarianRepository.deleteById(id);
        return "redirect:/librarians";
    }



}
