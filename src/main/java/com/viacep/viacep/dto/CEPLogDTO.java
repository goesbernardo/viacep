package com.viacep.viacep.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CEPLogDTO {

    private String cep;
    private LocalDate dtHrConsulta;

    public CEPLogDTO(String cep, LocalDate dtHrConsulta) {
        this.cep = cep;
        this.dtHrConsulta = dtHrConsulta;
    }
}
