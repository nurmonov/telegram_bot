package com.uz.telegrambot.service;

import com.uz.telegrambot.dto.RolesDTO;
import com.uz.telegrambot.entity.Roles;
import com.uz.telegrambot.mapper.RolesMapper;
import com.uz.telegrambot.repo.RolesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolesService {

    private final RolesRepository rolesRepository;
    private final RolesMapper rolesMapper;

    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
        this.rolesMapper = RolesMapper.INSTANCE;
    }

    public List<RolesDTO> getAllRoles() {
        return rolesRepository.findAll().stream()
                .map(rolesMapper::toRolesDTO)
                .collect(Collectors.toList());
    }

    public RolesDTO getRoleById(Integer id) {
        Optional<Roles> role = rolesRepository.findById(id);
        return role.map(rolesMapper::toRolesDTO).orElse(null);
    }

    public RolesDTO createRole(RolesDTO rolesDTO) {
        Roles role = rolesMapper.toRoles(rolesDTO);
        role = rolesRepository.save(role);
        return rolesMapper.toRolesDTO(role);
    }

    public RolesDTO updateRole(Integer id, RolesDTO rolesDTO) {
        if (!rolesRepository.existsById(id)) {
            return null;
        }
        Roles role = rolesMapper.toRoles(rolesDTO);
        role.setId(id);
        role = rolesRepository.save(role);
        return rolesMapper.toRolesDTO(role);
    }

    public void deleteRole(Integer id) {
        rolesRepository.deleteById(id);
    }
}


