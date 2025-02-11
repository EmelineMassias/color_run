package fr.hb.color_run.controller;

import org.springframework.stereotype.Controller;

import fr.hb.color_run.service.InscriptionService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class InscriptionController {
    private InscriptionService inscriptionService;
}
