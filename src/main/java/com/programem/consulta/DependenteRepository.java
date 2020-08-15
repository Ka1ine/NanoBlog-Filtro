package com.programem.consulta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DependenteRepository extends CrudRepository<Dependente, Integer> {
    @Query(
        value = "SELECT * FROM dependente d WHERE d.idade >= :idade",
        nativeQuery = true)
    Iterable<Dependente> findDependente(@Param("idade")Integer idade);
}

