package library.project.controller;

import library.project.dao.SectionRepository;
import library.project.model.Client;
import library.project.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class SectionController {

    @Autowired
    SectionRepository sectionRepository;

    // Get all sections
    @GetMapping(path="/sections")
    public String sections(Model model){
        List<Section> sections=sectionRepository.findAll();
        model.addAttribute("listSections", sections);
        return "sections";
    }
    //it sends you to the create section form
    @GetMapping(path ="/createsection")
    public String create(){
        return "createsection";
    }

    // to save a created section in the database
    @PostMapping("/createdsec")
    public String saveSection(Section section){
        sectionRepository.save(section);
        return "redirect:/sections";
    }
    //Get section data to update it
    @GetMapping("/editsect")
    public String edit( Model model , Long id){
        Optional<Section> section = sectionRepository.findById(id);
        model.addAttribute("section", section);
        return "editsection";
    }


    //to delete a category
    @GetMapping("/deletesect")
    public String delete(Long id){
        sectionRepository.deleteById(id);
        return "redirect:/sections";
    }


}
