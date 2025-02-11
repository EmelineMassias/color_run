package fr.hb.color_run.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.model.Role;

@Service
public interface RoleService {

    Role saveRole(RoleDto roleDto);
    
    List<RoleDto> getAllRoles();

    RoleDto getRoleById(Long id);

    void deleteRole(Long id);

}
