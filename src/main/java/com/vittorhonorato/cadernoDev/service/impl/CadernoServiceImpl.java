package com.vittorhonorato.cadernoDev.service.impl;

import com.vittorhonorato.cadernoDev.dto.CadernoRequestDTO;
import com.vittorhonorato.cadernoDev.dto.CadernoResponseDTO;
import com.vittorhonorato.cadernoDev.entity.Caderno;
import com.vittorhonorato.cadernoDev.repository.CadernoRepository;
import com.vittorhonorato.cadernoDev.service.CadernoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadernoServiceImpl implements CadernoService {
    private final CadernoRepository cadernoRepository;

    public CadernoServiceImpl(CadernoRepository cadernoRepository) {
        this.cadernoRepository = cadernoRepository;
    }

    @Override
    public CadernoResponseDTO getCaderno(Long id) {
        Caderno caderno = cadernoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Caderno not found with id: " + id));

        return new CadernoResponseDTO(caderno.getId(), caderno.getNome(), caderno.getResumo());
    }

    @Override
    public List<CadernoResponseDTO> getAllCaderno() {
        return cadernoRepository.findAll().stream()
                .map(caderno -> new CadernoResponseDTO(caderno.getId(), caderno.getNome(), caderno.getResumo()))
                .toList();
    }

    @Override
    public CadernoResponseDTO postCaderno(CadernoRequestDTO cadernoRequestDTO) {
        Caderno caderno = new Caderno();

        caderno.setNome(cadernoRequestDTO.nome());
        caderno.setResumo(cadernoRequestDTO.resumo());

        cadernoRepository.save(caderno);

        return new CadernoResponseDTO(caderno.getId(), caderno.getNome(), caderno.getResumo());
    }
}
