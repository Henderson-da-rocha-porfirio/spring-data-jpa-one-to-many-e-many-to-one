package com.tuyo.associations.onetomany.repos;

import com.tuyo.associations.onetomany.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
