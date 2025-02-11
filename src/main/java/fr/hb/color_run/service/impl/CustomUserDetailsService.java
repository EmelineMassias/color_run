package fr.hb.color_run.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.hb.color_run.model.Participant;
import fr.hb.color_run.model.Role;
import fr.hb.color_run.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private ParticipantRepository participantRepository;
    public CustomUserDetailsService(ParticipantRepository participantRepository){
        this.participantRepository = participantRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) 
    throws UsernameNotFoundException {
        Optional<Participant> participantResult = participantRepository.findByEmail(email);
        if(participantResult.isEmpty()){
            throw new UsernameNotFoundException(email + "not found.");
        }
        Participant participant = participantResult.get();
        return new User(participant.getEmail(), participant.getMotDePasse(), getRoles(participant.getRole()));
    }


    private List<GrantedAuthority>getRoles(Role role){
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + role));
        return roles;
    }
}
