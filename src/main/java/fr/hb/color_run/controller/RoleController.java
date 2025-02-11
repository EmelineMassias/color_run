package fr.hb.color_run.controller;

import org.springframework.stereotype.Controller;

import fr.hb.color_run.service.RoleService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RoleController {
    private RoleService roleService;
}
