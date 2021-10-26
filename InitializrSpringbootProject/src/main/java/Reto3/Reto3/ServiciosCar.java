/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author DELL
 */
@Service
public class ServiciosCar {
    @Autowired
    private RepositorioCar metodosCrud;
    
    public List<Car> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Car> getCar(int carId){
        return metodosCrud.getCar(carId);
    }
    public Car save(Car car){
        if(car.getId()==null){
            return metodosCrud.save(car);
        } else {
            Optional<Car> e=metodosCrud.getCar(car.getId());
            if(!e.isPresent()) {
                return metodosCrud.save(car);
            } else {
                return car;
            }
        }
    }
    public Car update (Car car){
        if(car.getId()!=null){
            Optional<Car> e=metodosCrud.getCar(car.getId());
            if(e.isPresent()){
                if(car.getName()!=null){
                    e.get().setName(car.getName());
                }
                if(car.getBrand()!=null){
                    e.get().setBrand(car.getBrand());
                }
                if(car.getYear()!=null){
                    e.get().setDescription(car.getDescription());
                }
                if(car.getDescription()!=null){
                    e.get().setDescription(car.getDescription());
                }
                if(car.getGama()!=null){
                    e.get().setGama(car.getGama());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return car;
            }
        } else {
            return car;
        }
    }
    
    public boolean deleteCar(int carId){
        Boolean aBoolean = getCar(carId).map(car -> {
            metodosCrud.delete(car);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
