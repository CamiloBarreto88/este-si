/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public class RepositorioCarro {
    
    @Autowired
    private InterfaceCarro crud1;
    
    public List<Carro> getAll(){
        return (List<Carro>) crud1.findAll();
    }
    
    public Optional<Carro> getCarro(int id){
        return crud1.findById(id);
    }
    
    public Carro save(Carro carro){
        return crud1.save(carro);
    }   
    
    public void delete(Carro carro){
        crud1.delete(carro);
    }
    
}
