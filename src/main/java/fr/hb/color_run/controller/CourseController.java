package fr.hb.color_run.controller;

import org.springframework.stereotype.Controller;

import fr.hb.color_run.service.CourseService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CourseController {
    private CourseService courseService;
}
