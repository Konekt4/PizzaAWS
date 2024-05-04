package com.example.PizzaAWS.services;

import com.example.PizzaAWS.models.PizzaModel;
import com.example.PizzaAWS.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PizzaService {
    @Autowired
    PizzaRepository repository;

    public PizzaModel savePizza(PizzaModel pizza){
        if(repository.findPizzaModelByCode(pizza.getCode()).toString().equals("Optional[[]]")){
            return repository.save(pizza);
        }else{
            //retornar un error de repetido
            PizzaModel pizzaError = new PizzaModel();
            pizzaError.setId(-1L);
            return pizzaError;
        }



    }

    public ArrayList<PizzaModel> getAllPizzas(){
        return (ArrayList<PizzaModel>) repository.findAll();
    }

    public Optional<PizzaModel> findPizzaById(Long id){
        return repository.findById(id);
    }



    public PizzaModel editPizza(PizzaModel pizza){
        return repository.save(pizza);
    }

    public String deletePizzaById(Long id){

        if(findPizzaById(id).isPresent()){
            repository.deleteById(id);
            return "pizza deleted successfully";
        }else {
            return "pizza with id="+ id+ " not foud";
        }
    }

    public Optional<ArrayList<PizzaModel>> findPizzaByCode(String code){
        return repository.findPizzaModelByCode(code);
    }
    public Optional<ArrayList<PizzaModel>> findPizzaByClient(String client){
        return repository.findPizzaModelByClient(client);
    }
}
