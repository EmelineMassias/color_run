package fr.hb.color_run.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.mapper.CourseMapper;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.repository.CourseRepository;
import fr.hb.color_run.service.impl.CourseServiceImpl;
import jakarta.persistence.EntityNotFoundException;

//extension Mockito pour l'initialisation automatique des mocks
@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

  /*   //Création des mocks pour simuler les dépendances
    @Mock
    private CourseRepository courseRepository;

    @Mock
    private CourseMapper courseMapper;

    //Injection auto des mocks dans le service à tester
    @InjectMocks
    private CourseServiceImpl courseService;

    //Objets utilisés dans les mocks 
    private Course course;
    private CourseDto courseDto;

    //Méthode executée avant chaque test pour initialiser les données
    @BeforeEach
    void setUp() {
        //Création d'une course
        course = new Course();
        course.setId(1L);
        course.setDescription("Course test");
        course.setDistance(10.0f);
        course.setLieu("Paris");
        course.setNbMaxParticipants(100.0);
        course.setPrixCourse(20.0f);
        course.setDateHeureCourse(LocalDateTime.now());

        //Création d'un DTO
        courseDto = new CourseDto();
        courseDto.setId(1L);
        courseDto.setDescription("Course test");
        courseDto.setDistance(10.0f);
        courseDto.setLieu("Paris");
        courseDto.setNbMaxParticipants(100.0);
        courseDto.setPrixCourse(20.0f);
        courseDto.setDateHeureCourse(LocalDateTime.now());
    }

    //Test de la création d'une course
    @Test
    void whenCreateCourse_thenReturnCourseDTO() {
        // Config des comportements des mocks
        when(courseMapper.toEntity(any(CourseDto.class))).thenReturn(course);
        when(courseRepository.save(any(Course.class))).thenReturn(course);
        when(courseMapper.toDto(any(Course.class))).thenReturn(courseDto);

        //Méthode à tester
        Course result = courseService.saveCourse(courseDto);

        // Vérif des résultats
        assertNotNull(result);
        assertEquals(courseDto.getId(), result.getId());
        assertEquals(courseDto.getDescription(), result.getDescription());
        //verif si méthode bien appelée
        verify(courseRepository).save(any(Course.class));
    }

    //Test récupération d'une course par son ID
    @Test
    void whenGetCourseById_thenReturnCourseDTO() {
        // config mocks
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(courseMapper.toDto(course)).thenReturn(courseDto);

        // Exécution
        CourseDto result = courseService.getCourseById(1L);

        // Verif
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(courseRepository).findById(1L);
    }

    //Test de la gestion d'erreur pour un ID invalide
    @Test
    void whenGetCourseById_withInvalidId_thenThrowException() {
        // config mock pour simuler une course non trouvée
        Long invalidId = 999L;
        when(courseRepository.findById(invalidId))
        .thenReturn(Optional.empty());

        // vérif exception bien lancée
        assertThrows(EntityNotFoundException.class, () -> {
            courseService.getCourseById(invalidId);
        }, "Une EntityNotFoundException devrait être lancée pour un ID invalide");
    }

    //Test mise à jour d'une course
    @Test
    void whenUpdateCourse_thenReturnUpdatedCourseDTO() {
        // config mocks
        Long courseId = 1L;
        CourseDto courseDto = new CourseDto();
        Course course = new Course();

        when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));
        when(courseRepository.save(any(Course.class))).thenReturn(course);

        // Exécution
        Course updatedCourse = courseService.saveCourse(courseDto);

        // Vérif
        assertNotNull(updatedCourse);
        verify(courseRepository).save(any(Course.class));
    }

    //Test suppression d'une course
    @Test
    void whenDeleteCourse_thenVerifyDeletion() {
        // config mocks
        Long courseId = 1L;
        Course course = new Course();
        when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));

        // Exécution
        courseService.deleteCourse(courseId);

        // verif méthode delete appelée
        verify(courseRepository).deleteById(courseId);
    }
*/
}
