package fr.hb.color_run.service.impl;

import org.springframework.stereotype.Service;

import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.mapper.RoleMapper;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.model.Role;
import fr.hb.color_run.repository.ParticipantRepository;
import fr.hb.color_run.repository.RoleRepository;
import fr.hb.color_run.service.RoleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleMapper roleMapper;
    private RoleRepository roleRepository;
    private ParticipantRepository participantRepository;

    public RoleServiceImpl(RoleRepository roleRepository,
                            RoleMapper roleMapper,
                            ParticipantRepository participantRepository){
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.participantRepository = participantRepository;
    }

    @Override
    public Role saveRole(RoleDto roleDto) {
        Role role = roleMapper.toEntity(roleDto);
        if(roleDto.getParticipantId() != null &&
        roleDto.getParticipantId().isEmpty()){
            List<Participant> participants = participantRepository
            .findAllById(roleDto.getParticipantId());
            role.setParticipants(participants);
        }
        return roleRepository.save(role);
    }

    @Override
    public List<RoleDto> getAllRoles(){
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toDto)
        .collect(Collectors.toList());
    }

    @Override
    public RoleDto getRoleById(Long id){
        return roleRepository
        .findById(id).map(roleMapper::toDto)
        .orElse(null);
    }

    @Override
    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }

}
