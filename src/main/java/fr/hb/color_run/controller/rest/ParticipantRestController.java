package fr.hb.color_run.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.hb.color_run.dto.ParticipantDto;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.service.ParticipantService;
import jakarta.validation.Valid;


@RestController
@Validated
@RequestMapping("/participants")
public class ParticipantRestController {


    private ParticipantService participantService;
        public ParticipantRestController(ParticipantService participantService){
                this.participantService = participantService;
        }

        //Méthode Get #1
        @GetMapping("")
        public List<ParticipantDto> getAllParticipants() {

                return participantService.getAllParticipants();
        }

        //Méthode Get #2
        @GetMapping("/{id}")
        @ResponseStatus(code= HttpStatus.OK)
        public ParticipantDto getParticipantById(@PathVariable Long id) {

                return participantService.getParticipantById(id);
        }

        //Méthode Post
        @PostMapping("")
        @ResponseStatus(code=HttpStatus.CREATED)
        public Participant saveParticipant(@Valid @RequestBody ParticipantDto participantDto,
                               BindingResult result) {
            return participantService.saveParticipant(participantDto);
        }

        //Méthode Delete
        @DeleteMapping("/{id}")
        @ResponseStatus(code=HttpStatus.NO_CONTENT)
        public void deleteParticipant(@PathVariable Long id) {
            participantService.deleteParticipant(id);
        }

        @PutMapping("/{id}")
        public Participant updateParticipant(@PathVariable Long id,
                                 @Valid @RequestBody ParticipantDto participantDto) {
                                    participantDto.setId(id);
                return participantService.saveParticipant(participantDto);
        }
}
