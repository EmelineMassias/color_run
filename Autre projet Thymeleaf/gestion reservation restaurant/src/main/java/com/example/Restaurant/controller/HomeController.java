package com.example.Restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Restaurant.service.TableService;
import com.example.Restaurant.service.ClientService;
import com.example.Restaurant.service.ReservationService;


@Controller
public class HomeController {

    private final ReservationService reservationService;
    private final ClientService clientService;
    private final TableService tableService;

    public HomeController(ReservationService reservationService, ClientService clientService, TableService tableService) {
        this.reservationService = reservationService;
        this.clientService = clientService;
        this.tableService = tableService;
    }

    @GetMapping("/")
    public String home(Model model) {
    
        model.addAttribute("totalTables", tableService.findAll().size());
        model.addAttribute("totalClients", clientService.findAll().size());
        model.addAttribute("totalReservations", reservationService.findAll().size());
        model.addAttribute("reservationOfTheDay", reservationService.reservationOfTheDay(reservationService.findAll()));
        model.addAttribute("availableTables", tableService.availableTables(tableService.findAll()).size());
        return "home";
    }

    

}

