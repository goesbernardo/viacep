package com.viacep.viacep.service;

import com.viacep.viacep.dto.CEPLogDTO;
import com.viacep.viacep.dto.InformacaoDTO;
import com.viacep.viacep.model.Informacao;
import com.viacep.viacep.repository.CepRepository;
import com.viacep.viacep.repository.InformacaoRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class InformacaoService {

    private final RestTemplate restTemplate;

    private final InformacaoRepository informacaoRepository;

    private final ModelMapper modelMapper;

    private final CepRepository cepRepository;


    private static final Logger logger = LoggerFactory.getLogger(InformacaoService.class);


    public InformacaoService(RestTemplate restTemplate, InformacaoRepository informacaoRepository, ModelMapper modelMapper, CepRepository cepRepository) {
        this.restTemplate = restTemplate;
        this.informacaoRepository = informacaoRepository;
        this.modelMapper = modelMapper;
        this.cepRepository = cepRepository;

    }

    public InformacaoDTO buscarCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        InformacaoDTO response = restTemplate.getForObject(url, InformacaoDTO.class);
        if (response == null) {
            throw new RuntimeException("Error to find information");
        }
        Informacao map = modelMapper.map(response, Informacao.class);
        logger.info("find mapping{}", map);
        informacaoRepository.save(map);

        return response;
    }

    public List<CEPLogDTO> listarUltimosPorUf(String uf) {
        return cepRepository.findLast20ByUf(uf);
    }
}
