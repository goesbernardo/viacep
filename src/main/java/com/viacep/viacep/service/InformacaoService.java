package com.viacep.viacep.service;

import com.viacep.viacep.dto.InformacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class InformacaoService {

    private final RestTemplate restTemplate;

    public InformacaoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public InformacaoDTO buscarCep(String cep) {
        // Monta a URL
        String url = UriComponentsBuilder.fromHttpUrl("https://viacep.com.br/ws/{cep}/json/")
                .buildAndExpand(cep)
                .toUriString();

        // Faz a requisição GET e recebe um ResponseEntity
        ResponseEntity<InformacaoDTO> response = restTemplate.getForEntity(url, InformacaoDTO.class);

        // Verifica se a resposta foi bem-sucedida
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody(); // Retorna o corpo da resposta
        } else {
            throw new RuntimeException("Erro ao consultar o CEP: " + response.getStatusCode());
        }
    }
}
