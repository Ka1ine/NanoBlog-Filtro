package com.programem.consulta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    @Query(
        value = "SELECT * FROM cliente c WHERE c.idade >= :idade",
        nativeQuery = true)
    Iterable<Cliente> findCliente(@Param("idade")Integer idade);
}
