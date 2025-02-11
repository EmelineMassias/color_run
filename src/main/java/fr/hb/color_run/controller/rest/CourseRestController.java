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

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.service.CourseService;
import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/courses")
public class CourseRestController {

private CourseService courseService;
        public CourseRestController(CourseService courseService){
                this.courseService = courseService;
        }

        //Méthode Get #1
        @GetMapping("")
        public List<CourseDto> getAllCourses() {

                return courseService.getAllCourses();
        }

        //Méthode Get #2
        @GetMapping("/{id}")
        @ResponseStatus(code= HttpStatus.OK)
        public CourseDto getCourseById(@PathVariable Long id) {

                return courseService.getCourseById(id);
        }

        //Méthode Post
        @PostMapping("")
        @ResponseStatus(code=HttpStatus.CREATED)
        public Course saveCourse(@Valid @RequestBody CourseDto courseDto,
                               BindingResult result) {
            return courseService.saveCourse(courseDto);
        }

        //Méthode Delete
        @DeleteMapping("/{id}")
        @ResponseStatus(code=HttpStatus.NO_CONTENT)
        public void deleteCourse(@PathVariable Long id) {
            courseService.deleteCourse(id);
        }

        @PutMapping("/{id}")
        public Course updateCourse(@PathVariable Long id,
                                 @Valid @RequestBody CourseDto courseDto) {
                                    courseDto.setId(id);
                return courseService.saveCourse(courseDto);
        }

}
