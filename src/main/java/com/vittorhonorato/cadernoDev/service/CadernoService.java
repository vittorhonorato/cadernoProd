package com.vittorhonorato.cadernoDev.service;

import com.vittorhonorato.cadernoDev.dto.CadernoRequestDTO;
import com.vittorhonorato.cadernoDev.dto.CadernoResponseDTO;

public interface CadernoService {
    CadernoResponseDTO getCaderno(Long id);
    CadernoResponseDTO postCaderno(CadernoRequestDTO cadernoRequestDTO);
}
