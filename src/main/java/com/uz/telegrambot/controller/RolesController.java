package com.uz.telegrambot.controller;


import com.uz.telegrambot.dto.RolesDTO;
import com.uz.telegrambot.service.RolesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping
    public ResponseEntity<List<RolesDTO>> getAllRoles() {
        return ResponseEntity.ok(rolesService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesDTO> getRoleById(@PathVariable Integer id) {
        RolesDTO rolesDTO = rolesService.getRoleById(id);
        return rolesDTO != null ? ResponseEntity.ok(rolesDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RolesDTO> createRole(@RequestBody RolesDTO rolesDTO) {
        return ResponseEntity.ok(rolesService.createRole(rolesDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesDTO> updateRole(@PathVariable Integer id, @RequestBody RolesDTO rolesDTO) {
        RolesDTO updatedRole = rolesService.updateRole(id, rolesDTO);
        return updatedRole != null ? ResponseEntity.ok(updatedRole) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        rolesService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}

