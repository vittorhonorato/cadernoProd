package com.vittorhonorato.cadernoDev.service;

import com.vittorhonorato.cadernoDev.dto.CadernoRequestDTO;
import com.vittorhonorato.cadernoDev.dto.CadernoResponseDTO;

import java.util.List;

public interface CadernoService {
    CadernoResponseDTO getCaderno(Long id);
    List<CadernoResponseDTO> getAllCaderno();
    CadernoResponseDTO postCaderno(CadernoRequestDTO cadernoRequestDTO);
}
