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

import fr.hb.color_run.dto.InscriptionDto;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.service.InscriptionService;
import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/inscriptions")
public class InscriptionRestController {
    private InscriptionService inscriptionService;
        public InscriptionRestController(InscriptionService inscriptionService){
                this.inscriptionService = inscriptionService;
        }

        //Méthode Get #1
        @GetMapping("")
        public List<InscriptionDto> getAllInscriptions() {

                return inscriptionService.getAllInscriptions();
        }

        //Méthode Get #2
        @GetMapping("/{id}")
        @ResponseStatus(code= HttpStatus.OK)
        public InscriptionDto getInscriptionById(@PathVariable Long id) {

                return inscriptionService.getInscriptionById(id);
        }

        //Méthode Post
        @PostMapping("")
        @ResponseStatus(code=HttpStatus.CREATED)
        public Inscription saveInscription(@Valid @RequestBody InscriptionDto inscriptionDto,
                               BindingResult result) {
            return inscriptionService.saveInscription(inscriptionDto);
        }

        //Méthode Delete
        @DeleteMapping("/{id}")
        @ResponseStatus(code=HttpStatus.NO_CONTENT)
        public void deleteInscription(@PathVariable Long id) {
            inscriptionService.deleteInscription(id);
        }

        @PutMapping("/{id}")
        public Inscription updateInscription(@PathVariable Long id,
                                 @Valid @RequestBody InscriptionDto inscriptionDto) {
                inscriptionDto.setId(id);
                return inscriptionService.saveInscription(inscriptionDto);
        }

}
