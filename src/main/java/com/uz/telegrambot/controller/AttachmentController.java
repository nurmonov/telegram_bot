package com.uz.telegrambot.controller;

import com.uz.telegrambot.dto.AttachmentDTO;
import com.uz.telegrambot.service.AttachmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attachments")
public class AttachmentController {

    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping
    public ResponseEntity<List<AttachmentDTO>> getAllAttachments() {
        return ResponseEntity.ok(attachmentService.getAllAttachments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttachmentDTO> getAttachmentById(@PathVariable Integer id) {
        AttachmentDTO attachmentDTO = attachmentService.getAttachmentById(id);
        return attachmentDTO != null ? ResponseEntity.ok(attachmentDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AttachmentDTO> createAttachment(@RequestBody AttachmentDTO attachmentDTO) {
        return ResponseEntity.ok(attachmentService.createAttachment(attachmentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttachmentDTO> updateAttachment(@PathVariable Integer id, @RequestBody AttachmentDTO attachmentDTO) {
        AttachmentDTO updatedAttachment = attachmentService.updateAttachment(id, attachmentDTO);
        return updatedAttachment != null ? ResponseEntity.ok(updatedAttachment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable Integer id) {
        attachmentService.deleteAttachment(id);
        return ResponseEntity.noContent().build();
    }
}


