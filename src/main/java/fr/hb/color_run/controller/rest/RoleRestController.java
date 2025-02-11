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

import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.model.Role;
import fr.hb.color_run.service.RoleService;
import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/roles")
public class RoleRestController {

private RoleService roleService;
        public RoleRestController(RoleService roleService){
                this.roleService = roleService;
        }

        //Méthode Get #1
        @GetMapping("")
        public List<RoleDto> getAllRoles() {

                return roleService.getAllRoles();
        }

        //Méthode Get #2
        @GetMapping("/{id}")
        @ResponseStatus(code= HttpStatus.OK)
        public RoleDto getRoleById(@PathVariable Long id) {

                return roleService.getRoleById(id);
        }

        //Méthode Post
        @PostMapping("")
        @ResponseStatus(code=HttpStatus.CREATED)
        public Role saveRole(@Valid @RequestBody RoleDto roleDto,
                               BindingResult result) {
            return roleService.saveRole(roleDto);
        }

        //Méthode Delete
        @DeleteMapping("/{id}")
        @ResponseStatus(code=HttpStatus.NO_CONTENT)
        public void deleteRole(@PathVariable Long id) {
            roleService.deleteRole(id);
        }

        @PutMapping("/{id}")
        public Role updateRole(@PathVariable Long id,
                                 @Valid @RequestBody RoleDto roleDto) {
                                    roleDto.setId(id);
                return roleService.saveRole(roleDto);
        }

}
