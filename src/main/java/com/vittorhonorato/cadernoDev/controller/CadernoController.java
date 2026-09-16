package com.vittorhonorato.cadernoDev.controller;

import com.vittorhonorato.cadernoDev.dto.CadernoRequestDTO;
import com.vittorhonorato.cadernoDev.dto.CadernoResponseDTO;
import com.vittorhonorato.cadernoDev.service.CadernoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caderno")
public class CadernoController {
    private final CadernoService cadernoService;

    public CadernoController(CadernoService cadernoService) {
        this.cadernoService = cadernoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadernoResponseDTO> getCaderno(@PathVariable Long id) {
        CadernoResponseDTO response = cadernoService.getCaderno(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CadernoResponseDTO> postCaderno(@Valid @RequestBody CadernoRequestDTO cadernoRequestDTO) {
        CadernoResponseDTO response = cadernoService.postCaderno(cadernoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
