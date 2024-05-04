package com.example.PizzaAWS.controllers;

import com.example.PizzaAWS.models.PizzaModel;
import com.example.PizzaAWS.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    @Autowired
    PizzaService service;

    @PostMapping()
    public PizzaModel savePizza(@RequestBody PizzaModel pizza) {
        return service.savePizza(pizza);
    }

    @PutMapping()
    public PizzaModel editPizza(@RequestBody PizzaModel pizza) {
        return service.editPizza(pizza);
    }

    @GetMapping()
    public ArrayList<PizzaModel> getAllPizzas() {
        return service.getAllPizzas();
    }

    @GetMapping("/findPizzaById/{id}")
    public Optional<PizzaModel> findPizzaById(@PathVariable Long id) {
        return service.findPizzaById(id);
    }

    @GetMapping("/findPizzaByCode/{code}")
    public Optional<ArrayList<PizzaModel>> findPizzaByCode(@PathVariable String code) {
        return service.findPizzaByCode(code);
    }


    @GetMapping("/findPizzaByClient/{client}")
    public Optional<ArrayList<PizzaModel>> findPizzaByClient(@PathVariable String client) {
        return service.findPizzaByClient(client);
    }
    @DeleteMapping("/delete-pizza-by-id")
    public String deletePizzaById(@RequestParam("id") Long id){
        return service.deletePizzaById(id);
    }

}
