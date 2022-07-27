package library.project.controller;

import library.project.model.Book;
import library.project.model.Borrow;
import library.project.dao.BorrowRepository;
import library.project.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import library.project.dao.BookRepository;
import library.project.dao.ClientRepository;


import java.util.List;
import java.util.Optional;

@Controller
public class BorrowController {
    @Autowired
    BorrowRepository borrowRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ClientRepository clientRepository;
    // Get all borrows
    @GetMapping(path="/borrows")
    public String borrows(Model model){
        List<Borrow> borrows=borrowRepository.findAll();
        model.addAttribute("listBorrows", borrows);
        return "borrows";
    }
    //it sends you to the add borrow form
    @GetMapping(path ="/addborrow")
    public String add(Model model){
        List<Book> books=bookRepository.findAll();
        model.addAttribute("books", books);
        List<Client> clients=clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "addborrow";
    }

    // to save an added borrow in the database
    @PostMapping("/addedborrow")
    public String saveBorrow(Borrow borrow){
        System.out.println("icii");
        borrowRepository.save(borrow);
        return "redirect:/borrows";
    }
    //Get borrow's data to update it
    @GetMapping("/editborrow")
    public String edit( Model model , Long id){
        List<Book> books=bookRepository.findAll();
        model.addAttribute("books", books);
        List<Client> clients=clientRepository.findAll();
        model.addAttribute("clients", clients);
        Optional<Borrow> borrow = borrowRepository.findById(id);
        model.addAttribute("borrow", borrow);
        return "editborrow";
    }
    //to delete a client
    @GetMapping("/deleteborrow")
    public String delete(Long id){
        borrowRepository.deleteById(id);
        return "redirect:/borrows";
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/borrows";
    }
}
