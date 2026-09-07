package com.senac.bibliotech.secao.api;


import com.senac.bibliotech.secao.api.request.SecaoRequest;
import com.senac.bibliotech.secao.api.response.SecaoResponse;
import com.senac.bibliotech.secao.service.SecaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<SecaoResponse> postSecao(
            @Valid
            @RequestBody
            SecaoRequest secaoRequest
                                                    ){
        SecaoResponse secaoResponse = secaoService.postSecao(secaoRequest);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(secaoResponse.id())
                .toUri();
        return ResponseEntity.created(uri).body(secaoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSecaoById(@PathVariable Long id){
        secaoService.deleteSecaoById(id);
        return ResponseEntity.noContent().build();
    }

}
