package com.example.Restaurant.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.Restaurant.model.Client;
import com.example.Restaurant.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "client/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("client", new Client());
        return "client/form";
    }

    @PostMapping("/save")
    public String saveClient(@Valid @ModelAttribute("client") Client client, 
                             BindingResult result) {
        if (result.hasErrors()) {
            return "client/form";
        }
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Client cl = clientService.findById(id);
        if (cl == null) {
            return "redirect:/clients";
        }
        model.addAttribute("client", cl);
        return "client/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}

