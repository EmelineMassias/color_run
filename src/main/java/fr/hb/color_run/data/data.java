package fr.hb.color_run.data;

import lombok.AllArgsConstructor;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.dto.InscriptionDto;
import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.dto.ParticipantDto;
import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.service.CourseService;
import fr.hb.color_run.service.InscriptionService;
import fr.hb.color_run.service.ParcoursService;
import fr.hb.color_run.service.ParticipantService;
import fr.hb.color_run.service.RoleService;


import java.time.LocalDateTime;
import java.util.Arrays;


@Component
@AllArgsConstructor
public class data implements CommandLineRunner{
    
    private final RoleService roleService;
    private final ParticipantService participantService;
    private final CourseService courseService;
    private final InscriptionService inscriptionService;
    private final ParcoursService parcoursService;
    
    private void addRole(){
        RoleDto role1 = new RoleDto();
            role1.setLibelle("ROLE_ADMIN");
            roleService.saveRole(role1);

        RoleDto role2 = new RoleDto();
            role2.setLibelle("ROLE_CREATEUR");
            roleService.saveRole(role2);

        RoleDto role3 = new RoleDto();
            role3.setLibelle("ROLE_PARTICIPANT");
            roleService.saveRole(role3);

}

   /* private void addParticipant() {
        ParticipantDto admin= new ParticipantDto();
        admin.setEmail("admin@admin.com");
        admin.setMotDePasse("admin");
        admin.setNom("Rouve");
        admin.setPrenom("Jean-Paul");
        admin.setRole(roleService.getRoleById(1L));
        participantService.saveParticipant(admin);

        ParticipantDto createur = new ParticipantDto();
        createur.setEmail("createur@createur.com");
        createur.setMotDePasse("createur");
        createur.setNom("Bretelle");
        createur.setPrenom("Jeff");
        createur.setRole(roleService.getRoleById(2L));
        participantService.saveParticipant(createur);

        ParticipantDto participant1 = new ParticipantDto();
        participant1.setEmail("jhendrix@participant.com");
        participant1.setMotDePasse("participant");
        participant1.setNom("Hendrix");
        participant1.setPrenom("Jimmy");
        participant1.setRole(roleService.getRoleById(3L));
        participantService.saveParticipant(participant1);

        ParticipantDto participant2 = new ParticipantDto();
        participant2.setEmail("jjoplin@participant.com");
        participant2.setMotDePasse("participant");
        participant2.setNom("Joplin");
        participant2.setPrenom("Janis");
        participant2.setRole(roleService.getRoleById(3L));
        participantService.saveParticipant(participant2);

        ParticipantDto participant3 = new ParticipantDto();
        participant3.setEmail("jmorrisson@participant.com");
        participant3.setMotDePasse("participant");
        participant3.setNom("Morrisson");
        participant3.setPrenom("Jim");
        participant3.setRole(roleService.getRoleById(3L));
        participantService.saveParticipant(participant3);

        ParticipantDto participant4 = new ParticipantDto();
        participant4.setEmail("kcobain@participant.com");
        participant4.setMotDePasse("participant");
        participant4.setNom("Cobain");
        participant4.setPrenom("Kurt");
        participant4.setRole(roleService.getRoleById(3L));
        participantService.saveParticipant(participant4);
    }

    private void addParcours(){
        ParcoursDto parcours1 = new ParcoursDto();
        parcours1.setOrdre(1.0);
        parcours1.setCourseId(Arrays.asList(1L));
        parcours1.setLatitude(43.7102); // Nice coordinates
        parcours1.setLongitude(7.2620);
        parcoursService.saveParcours(parcours1);

        ParcoursDto parcours2 = new ParcoursDto();
        parcours2.setOrdre(2.0);
        parcours2.setCourseId(Arrays.asList(2L));
        parcours2.setLatitude(45.7640); // Lyon coordinates
        parcours2.setLongitude(4.8357);
        parcoursService.saveParcours(parcours2);

        ParcoursDto parcours3 = new ParcoursDto();
        parcours3.setOrdre(3.0);
        parcours3.setCourseId(Arrays.asList(3L));
        parcours3.setLatitude(45.1885); // Grenoble coordinates
        parcours3.setLongitude(5.7245);
        parcoursService.saveParcours(parcours3);

        ParcoursDto parcours4 = new ParcoursDto();
        parcours4.setOrdre(4.0);
        parcours4.setCourseId(Arrays.asList(4L));
        parcours4.setLatitude(31.7917); // Marrakech coordinates (closest major city to "Maroc")
        parcours4.setLongitude(-7.0926);
        parcoursService.saveParcours(parcours4);
    }

    private void addCourse(){
        CourseDto course1 = new CourseDto();
        course1.setDateHeureCourse(LocalDateTime.of(2025, 5, 20, 10, 0));
        course1.setDescription("Color Run en bord de mer");
        course1.setCauseSoutenue("Soutien aux enfants malades");
        course1.setLieu("Nice");
        course1.setDistance(5.0f);
        course1.setHaveObstacle(false);
        course1.setNbMaxParticipants(500.0);
        course1.setPrixCourse(25.0f);
        course1.setParcoursId(Arrays.asList(1L));
        course1.setInscriptionId(Arrays.asList(1L));
        courseService.saveCourse(course1);

        CourseDto course2 = new CourseDto();
        course2.setDateHeureCourse(LocalDateTime.of(2025, 6, 15, 9, 30));
        course2.setDescription("Course à obstacles urbaine");
        course2.setCauseSoutenue("Lutte contre le cancer");
        course2.setLieu("Lyon");
        course2.setDistance(8.0f);
        course2.setHaveObstacle(true);
        course2.setNbMaxParticipants(300.0);
        course2.setPrixCourse(30.0f);
        course2.setParcoursId(Arrays.asList(2L));
        course2.setInscriptionId(Arrays.asList(2L));
        courseService.saveCourse(course2);

        CourseDto course3 = new CourseDto();
        course3.setDateHeureCourse(LocalDateTime.of(2025, 7, 10, 18, 0));
        course3.setDescription("Trail nocturne en montagne");
        course3.setCauseSoutenue("Protection de l'environnement");
        course3.setLieu("Grenoble");
        course3.setDistance(12.0f);
        course3.setHaveObstacle(false);
        course3.setNbMaxParticipants(200.0);
        course3.setPrixCourse(35.0f);
        course3.setParcoursId(Arrays.asList(3L));
        course3.setInscriptionId(Arrays.asList(3L));
        courseService.saveCourse(course3);

        CourseDto course4 = new CourseDto();
        course4.setDateHeureCourse(LocalDateTime.of(2025, 8, 5, 7, 0));
        course4.setDescription("Ultra-marathon du désert");
        course4.setCauseSoutenue("Accès à l'eau potable");
        course4.setLieu("Maroc");
        course4.setDistance(42.195f);
        course4.setHaveObstacle(true);
        course4.setNbMaxParticipants(100.0);
        course4.setPrixCourse(50.0f);
        course4.setParcoursId(Arrays.asList(4L));
        course4.setInscriptionId(Arrays.asList(4L));
        courseService.saveCourse(course4);
    }

    private void addInscription(){
        InscriptionDto inscription1 = new InscriptionDto();
        inscription1.setParticipant(participantService.getParticipantById(3L));
        inscription1.setCourse(courseService.getCourseById(1L));
        inscriptionService.saveInscription(inscription1);

        InscriptionDto inscription2 = new InscriptionDto();
        inscription2.setParticipant(participantService.getParticipantById(4L));
        inscription2.setCourse(courseService.getCourseById(2L));
        inscriptionService.saveInscription(inscription2);

        InscriptionDto inscription3 = new InscriptionDto();
        inscription3.setParticipant(participantService.getParticipantById(2L));
        inscription3.setCourse(courseService.getCourseById(3L)); // Grenoble Night Trail
        inscriptionService.saveInscription(inscription3);

        InscriptionDto inscription4 = new InscriptionDto();
        inscription4.setParticipant(participantService.getParticipantById(1L));
        inscription4.setCourse(courseService.getCourseById(4L)); // Moroccan Desert Ultra-Marathon
        inscriptionService.saveInscription(inscription4);
    }*/ 

    @Override
    public void run(String... args) throws Exception {
        
        addRole();

        /*addParticipant();
        
        addParcours();        

        addCourse();

        addInscription();*/

    }
}
