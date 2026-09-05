package com.senac.bibliotech.secao.api;


import com.senac.bibliotech.secao.api.dto.response.SecaoResponse;
import com.senac.bibliotech.secao.domain.Secao;
import com.senac.bibliotech.secao.service.SecaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secao")
public class SecaoController {

    private final SecaoService secaoService;

    public SecaoController(SecaoService secaoService) {
        this.secaoService = secaoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SecaoResponse> findAllSecoes(@PathVariable Long id){
        return ResponseEntity.ok(secaoService.findSecaoById(id));
    }

    @GetMapping
    public ResponseEntity<List<SecaoResponse>> findAllSecao(){
        return ResponseEntity.ok(secaoService.findAllSecao());
    }

}
