package com.senac.bibliotech.secao.service;


import com.senac.bibliotech.biblioteca.model.Biblioteca;
import com.senac.bibliotech.biblioteca.service.BibliotecaService;
import com.senac.bibliotech.secao.api.request.SecaoRequest;
import com.senac.bibliotech.secao.api.response.SecaoResponse;
import com.senac.bibliotech.secao.domain.Secao;
import com.senac.bibliotech.secao.mapper.SecaoMapper;
import com.senac.bibliotech.secao.repository.SecaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecaoService {

    private final SecaoRepository secaoRepository;
    private final SecaoMapper secaoMapper;
    private final BibliotecaService bibliotecaService;

    public SecaoService(SecaoRepository secaoRepository, SecaoMapper secaoMapper, BibliotecaService bibliotecaService) {
        this.secaoRepository = secaoRepository;
        this.secaoMapper = secaoMapper;
        this.bibliotecaService = bibliotecaService;
    }

    public Secao findSecaoEntityById(Long id){
        return secaoRepository
                .findById(id)
                .orElseThrow();
    }

    public SecaoResponse findSecaoById(Long id){
        return secaoMapper.toResponse(findSecaoEntityById(id));
    }

    public List<SecaoResponse> findAllSecao(){
        return secaoRepository
                .findAll()
                .stream()
                .map(secaoMapper::toResponse)
                .toList();
    }

    public SecaoResponse postSecao(SecaoRequest secaoRequest){

        Biblioteca biblioteca = bibliotecaService.findBibliotecaEntityById(secaoRequest.bibliotecaId());
        Secao secao = secaoMapper.createSecao(secaoRequest);
        secao.setBiblioteca(biblioteca);
        Secao savedSecao = secaoRepository.save(secao);
        return secaoMapper
                .toResponse(savedSecao);
    }

    public void deleteSecaoById(Long id){
        Secao secao = findSecaoEntityById(id);
        secaoRepository.delete(secao);
    }

}
