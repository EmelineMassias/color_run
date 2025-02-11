package com.example.Restaurant.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.Restaurant.model.Table;
import com.example.Restaurant.service.TableService;



@Controller
@RequestMapping("/tables")
public class TableController {

    private final TableService tableService;
   
  

    public TableController(TableService tableService) {
        this.tableService = tableService;
        
    }

    @GetMapping
    public String listTables(Model model) {
        model.addAttribute("tables", tableService.findAll());
        return "table/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("table", new Table());
        return "table/form";
    }

    @PostMapping("/save")
    public String saveTable(@Valid @ModelAttribute("table") Table table, 
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("tables", tableService.findAll());
            return "table/form";
        }
        tableService.save(table);
        return "redirect:/tables";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Table t = tableService.findById(id);
        if (t == null) {
            return "redirect:/tables";
        }
        model.addAttribute("table", t);
        model.addAttribute("tables", tableService.findAll());

        return "table/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTable(@PathVariable Integer id) {
        tableService.delete(id);
        return "redirect:/tables";
    }
}

