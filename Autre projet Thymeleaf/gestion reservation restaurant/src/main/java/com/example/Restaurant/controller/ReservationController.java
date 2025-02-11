package com.example.Restaurant.controller;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.Restaurant.model.Reservation;
import com.example.Restaurant.service.ClientService;
import com.example.Restaurant.service.ReservationService;
import com.example.Restaurant.service.TableService;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private final ReservationService reservationService;
    @Autowired
    private final TableService tableService;
    @Autowired
    private final ClientService clientService;

    public ReservationController(ReservationService reservationService, TableService tableService, ClientService clientService) {
        this.reservationService = reservationService;
        this.tableService = tableService;
        this.clientService = clientService;
    }

    @GetMapping
    public String listReservations(Model model) {
        model.addAttribute("reservations", reservationService.findAll());
        return "reservation/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("isEditMode", false);
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("tables", tableService.findAll());
        model.addAttribute("clients", clientService.findAll());
        return "contract/form";
    }

    @PostMapping("/save")
    public String saveReservation(@Valid @ModelAttribute("reservation") Reservation reservation, BindingResult result) {
        if (result.hasErrors()) {
            return "reservation/form";
        }
        reservationService.save(reservation, null, null);;
        return "redirect:/reservations";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, Model model) {
        Reservation r = reservationService.findById(id);
        if (r== null) {
            return "redirect:/reservations";
        }
        model.addAttribute("isEditMode", false);
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("tables", tableService.findAll());
        model.addAttribute("clients", clientService.findAll());
        return "reservation/form";
    }


    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Integer id) {
        reservationService.delete(id);
        return "redirect:/reservations";
    }
}

