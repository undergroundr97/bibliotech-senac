package com.senac.bibliotech.exemplar.api;


import com.senac.bibliotech.exemplar.api.request.ExemplarRequest;
import com.senac.bibliotech.exemplar.api.response.ExemplarResponse;
import com.senac.bibliotech.exemplar.model.Exemplar;
import com.senac.bibliotech.exemplar.service.ExemplarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/exemplar")
public class ExemplarController {

    private final ExemplarService exemplarService;

    public ExemplarController(ExemplarService exemplarService) {
        this.exemplarService = exemplarService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExemplarResponse> getExemplarById(@PathVariable Long id){
        return ResponseEntity.ok(exemplarService.findExemplarById(id));
    }

    @GetMapping
    public ResponseEntity<List<ExemplarResponse>> getAllExemplares(){
        return ResponseEntity.ok(exemplarService.findAllExemplar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExemplarById(@PathVariable Long id){
        exemplarService.deleteExemplarById(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ExemplarResponse> saveExemplar(
            @Valid
            @RequestBody
            ExemplarRequest exemplarRequest){

        ExemplarResponse exemplarResponse = exemplarService.save(exemplarRequest);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(exemplarResponse)
                .toUri();

        return ResponseEntity.created(uri).body(exemplarResponse);
    }



}
