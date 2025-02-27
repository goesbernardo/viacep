package com.viacep.viacep.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InformacaoDTO {

    private String cep;

    @JsonProperty("logradouro")
    private String logradouro;

    private String complemento;

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("localidade")
    private String cidade;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("regiao")
    private String regiao;

    @JsonProperty("uf")
    private String uf;

    private String ibge;

    private String gia;

    @JsonProperty("ddd")
    private String ddd;

    private String siafi;



}
