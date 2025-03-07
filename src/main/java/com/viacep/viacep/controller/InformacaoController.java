package com.viacep.viacep.controller;

import com.viacep.viacep.dto.CEPLogDTO;
import com.viacep.viacep.dto.InformacaoDTO;
import com.viacep.viacep.service.InformacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/lista-ceps")
    public List<CEPLogDTO> listarUltimos20PorUf(@RequestParam String uf) {
        return informacaoService.listarUltimosPorUf(uf);
    }
}
