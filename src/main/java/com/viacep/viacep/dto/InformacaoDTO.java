package com.viacep.viacep.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InformacaoDTO {

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("logradouro")
    private String rua;

    @JsonProperty("complemento")
    private String complemento;

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("localidade")
    private String cidade;

    @JsonProperty("uf")
    private String uf;

    }


