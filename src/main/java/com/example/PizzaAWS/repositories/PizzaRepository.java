package com.example.PizzaAWS.repositories;

import com.example.PizzaAWS.models.PizzaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PizzaRepository extends CrudRepository<PizzaModel, Long> {
    public Optional<ArrayList<PizzaModel>> findPizzaModelByCode(String code);

    public Optional<ArrayList<PizzaModel>> findPizzaModelByClient(String client);
}
