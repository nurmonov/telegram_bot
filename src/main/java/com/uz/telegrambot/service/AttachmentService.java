package com.uz.telegrambot.service;

import com.uz.telegrambot.dto.AttachmentDTO;
import com.uz.telegrambot.entity.Attachment;
import com.uz.telegrambot.mapper.AttachmentMapper;
import com.uz.telegrambot.repo.AttachmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentMapper attachmentMapper;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
        this.attachmentMapper = AttachmentMapper.INSTANCE;
    }

    public List<AttachmentDTO> getAllAttachments() {
        return attachmentRepository.findAll().stream()
                .map(attachmentMapper::toAttachmentDTO)
                .collect(Collectors.toList());
    }

    public AttachmentDTO getAttachmentById(Integer id) {
        Optional<Attachment> attachment = attachmentRepository.findById(id);
        return attachment.map(attachmentMapper::toAttachmentDTO).orElse(null);
    }

    public AttachmentDTO createAttachment(AttachmentDTO attachmentDTO) {
        Attachment attachment = attachmentMapper.toAttachment(attachmentDTO);
        attachment = attachmentRepository.save(attachment);
        return attachmentMapper.toAttachmentDTO(attachment);
    }

    public AttachmentDTO updateAttachment(Integer id, AttachmentDTO attachmentDTO) {
        if (!attachmentRepository.existsById(id)) {
            return null;
        }
        Attachment attachment = attachmentMapper.toAttachment(attachmentDTO);
        attachment.setId(id);
        attachment = attachmentRepository.save(attachment);
        return attachmentMapper.toAttachmentDTO(attachment);
    }

    public void deleteAttachment(Integer id) {
        attachmentRepository.deleteById(id);
    }
}


