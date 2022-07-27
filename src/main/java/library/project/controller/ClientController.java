package library.project.controller;

import library.project.model.Client;
import library.project.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class ClientController {

    @Autowired
    ClientRepository clientRepository;
    // Get all clients
    @GetMapping(path="/clients")
    public String clients(Model model){
        List<Client> clients=clientRepository.findAll();
        model.addAttribute("listClients", clients);
        return "clients";
    }
    //it sends you to the create client form
    @GetMapping(path ="/createclient")
    public String create(){
        return "createclient";
    }

    // to save a created client in the database
    @PostMapping("/createdclient")
    public String saveClient(Client client){
        clientRepository.save(client);
        return "redirect:/clients";
    }
    //Get client data to update it
    @GetMapping("/editclient")
    public String edit( Model model , Long id){
        Optional<Client> client = clientRepository.findById(id);
        model.addAttribute("client", client);
        return "editclient";
    }
    //to delete a client
    @GetMapping("/deleteclient")
    public String delete(Long id){
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }

}
