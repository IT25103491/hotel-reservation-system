package com.hotel.reservation.roomcategory;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class RoomCategoryController {

    private final RoomCategoryService service;

    public RoomCategoryController(RoomCategoryService service) {
        this.service = service;
    }

    // READ — show the list
    @GetMapping
    public String list(Model model) {
        model.addAttribute("categories", service.getAll());
        return "category/list";
    }

    // CREATE — show the empty form
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("category", new RoomCategory());
        return "category/form";
    }

    // CREATE / UPDATE — handle form submission
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("category") RoomCategory category,
                       BindingResult result) {
        if (result.hasErrors()) {
            return "category/form";
        }
        service.save(category);
        return "redirect:/categories";
    }

    // UPDATE — show the form pre-filled with existing data
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("category", service.getById(id));
        return "category/form";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/categories";
    }
}