package com.senac.bibliotech.exemplar.service;


import com.senac.bibliotech.exemplar.api.request.ExemplarRequest;
import com.senac.bibliotech.exemplar.api.response.ExemplarResponse;
import com.senac.bibliotech.exemplar.mapper.ExemplarMapper;
import com.senac.bibliotech.exemplar.model.Disponibilidade;
import com.senac.bibliotech.exemplar.model.Exemplar;
import com.senac.bibliotech.exemplar.repository.ExemplarRepository;
import com.senac.bibliotech.livro.domain.Livro;
import com.senac.bibliotech.livro.repository.LivroRepository;
import com.senac.bibliotech.livro.service.LivroService;
import com.senac.bibliotech.secao.domain.Secao;
import com.senac.bibliotech.secao.service.SecaoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExemplarService {

    private final ExemplarRepository exemplarRepository;
    private final ExemplarMapper exemplarMapper;
    private final LivroService livroService;
    private final SecaoService secaoService;


    public ExemplarService(ExemplarRepository exemplarRepository, ExemplarMapper exemplarMapper, LivroRepository livroRepository, LivroService livroService, SecaoService secaoService) {
        this.exemplarRepository = exemplarRepository;
        this.exemplarMapper = exemplarMapper;
        this.livroService = livroService;
        this.secaoService = secaoService;
    }


    protected Exemplar findExemplarEntityById(Long id){
        return exemplarRepository.findById(id)
                .orElseThrow();
    }


    public ExemplarResponse findExemplarById(Long id){
        Exemplar exemplar = findExemplarEntityById(id);
        return exemplarMapper.toResponse(exemplar);
    }

    public List<ExemplarResponse> findAllExemplar(){
        return exemplarRepository.findAll()
                .stream()
                .map(exemplarMapper::toResponse)
                .toList();
    }

    public ExemplarResponse save(ExemplarRequest exemplarRequest){

        Exemplar exemplar = exemplarMapper.createExemplar(exemplarRequest);

        Livro livro = livroService.findLivroEntityById(exemplarRequest.livroId());
        Secao secao = secaoService.findSecaoEntityById(exemplarRequest.secaoId());

        exemplar.setStatus(Disponibilidade.DISPONIVEL);
        exemplar.setSecao(secao);
        exemplar.setLivro(livro);
        exemplar.setDataAquisicao(LocalDateTime.now());

        Exemplar savedExemplar = exemplarRepository.save(exemplar);

        return exemplarMapper.toResponse(savedExemplar);
    }


    public void deleteExemplarById(Long id){
        Exemplar exemplar = findExemplarEntityById(id);
        exemplarRepository.delete(exemplar);
    }


}
