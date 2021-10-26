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
public class RepositorioCar {
    
    @Autowired
    private InterfaceCar crud;
    
    public List<Car> getAll(){
        return (List<Car>) crud.findAll();
    }
    
    public Optional<Car> getCar(int id){
        return crud.findById(id);
    }
    
    public Car save(Car car){
        return crud.save(car);
    }   
    
    public void delete(Car car){
        crud.delete(car);
    }
    
}
