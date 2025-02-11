package fr.hb.color_run.controller;

import org.springframework.stereotype.Controller;

import fr.hb.color_run.service.ParcoursService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ParcoursController {
    private ParcoursService parcoursService;
}
