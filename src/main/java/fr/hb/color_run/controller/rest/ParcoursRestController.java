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

import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.model.Parcours;
import fr.hb.color_run.service.ParcoursService;
import jakarta.validation.Valid;


@RestController
@Validated
@RequestMapping("/parcours")
public class ParcoursRestController {

private ParcoursService parcoursService;
        public ParcoursRestController(ParcoursService parcoursService){
                this.parcoursService = parcoursService;
        }

        //Méthode Get #1
        @GetMapping("")
        public List<ParcoursDto> getAllParcours() {

                return parcoursService.getAllParcours();
        }

        //Méthode Get #2
        @GetMapping("/{id}")
        @ResponseStatus(code= HttpStatus.OK)
        public ParcoursDto getParcoursById(@PathVariable Long id) {

                return parcoursService.getParcoursById(id);
        }

        //Méthode Post
        @PostMapping("")
        @ResponseStatus(code=HttpStatus.CREATED)
        public Parcours saveParcours(@Valid @RequestBody ParcoursDto parcoursDto,
                               BindingResult result) {
            return parcoursService.saveParcours(parcoursDto);
        }

        //Méthode Delete
        @DeleteMapping("/{id}")
        @ResponseStatus(code=HttpStatus.NO_CONTENT)
        public void deleteParcours(@PathVariable Long id) {
            parcoursService.deleteParcours(id);
        }

        @PutMapping("/{id}")
        public Parcours updateParcours(@PathVariable Long id,
                                 @Valid @RequestBody ParcoursDto parcoursDto) {
                                    parcoursDto.setId(id);
                return parcoursService.saveParcours(parcoursDto);
        }

}
