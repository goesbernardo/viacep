package com.viacep.viacep.controller;

import com.viacep.viacep.dto.InformacaoDTO;
import com.viacep.viacep.service.InformacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/buscaCep")
public class InformacaoController {

    @Autowired
    private InformacaoService informacaoService;

    @GetMapping(value = "/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InformacaoDTO> consultaCep(@PathVariable String cep) {
        InformacaoDTO response = informacaoService.buscarCep(cep);
        return ResponseEntity.ok(response);
    }
}
