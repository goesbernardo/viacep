package com.viacep.viacep.repository;

import com.viacep.viacep.dto.CEPLogDTO;
import com.viacep.viacep.model.CEPLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CepRepository extends JpaRepository<CEPLog,Long> {

    @Query("SELECT new com.viacep.viacep.dto.CepLogDTO(c.cep, c.dataHoraConsulta) " +
            "FROM CepLog c WHERE c.uf = :uf ORDER BY c.dataHoraConsulta DESC LIMIT 20")
    List<CEPLogDTO> findLast20ByUf(@Param("uf") String uf);
}
