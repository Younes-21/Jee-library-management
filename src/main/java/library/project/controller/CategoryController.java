package library.project.controller;
import library.project.model.Category;
import library.project.dao.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    // Get all categories
    @GetMapping(path="/categories")
    public String categories(Model model){
        List<Category> categories=categoryRepository.findAll();
        model.addAttribute("listCategories", categories);
        return "categories";
    }
    //it sends you to the create category form
    @GetMapping(path ="/createcategory")
    public String create(){
        return "createcategory";
    }

    // to save a created category in the database
    @PostMapping("/createdcat")
    public String saveCategory(Category category){
        categoryRepository.save(category);
        return "redirect:/categories";
    }
    //Get librarian data to update it
    @GetMapping("/editcat")
    public String edit( Model model , Long id){
        Optional<Category> category = categoryRepository.findById(id);
        model.addAttribute("category", category);
        return "editcategory";
    }

   /* @PutMapping("/category/{id}")
    public String updateCategory(Category category , Long id){
        categoryRepository.findById(id).map(x->{
            x.setCategoryName(category.getCategoryName());
        });
        return "redirect:/categories";
    }*/

    //to delete a category
    @GetMapping("/deletecat")
    public String delete(Long id){
        categoryRepository.deleteById(id);
        return "redirect:/categories";
    }



}
