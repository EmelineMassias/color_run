package fr.hb.color_run.controller;

import org.springframework.stereotype.Controller;

import fr.hb.color_run.service.ParticipantService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ParticipantController {
    private ParticipantService participantService;
}
