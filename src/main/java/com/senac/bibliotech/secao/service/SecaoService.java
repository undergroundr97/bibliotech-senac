package com.senac.bibliotech.secao.service;


import com.senac.bibliotech.secao.api.dto.request.SecaoRequest;
import com.senac.bibliotech.secao.api.dto.response.SecaoResponse;
import com.senac.bibliotech.secao.domain.Secao;
import com.senac.bibliotech.secao.mapper.SecaoMapper;
import com.senac.bibliotech.secao.repository.SecaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecaoService {

    private final SecaoRepository secaoRepository;
    private final SecaoMapper secaoMapper;

    public SecaoService(SecaoRepository secaoRepository, SecaoMapper secaoMapper) {
        this.secaoRepository = secaoRepository;
        this.secaoMapper = secaoMapper;
    }

    private Secao findSecaoEntityById(Long id){
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

        Secao secao = secaoMapper.createSecao(secaoRequest);

        Secao savedSecao = secaoRepository.save(secao);

        return secaoMapper
                .toResponse(savedSecao);
    }

}
