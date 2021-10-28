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
public class ServiciosCarro {
    @Autowired
    private RepositorioCarro metodosCrud;
    
    public List<Carro> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Carro> getCar(int idCarro){
        return metodosCrud.getCarro(idCarro);
    }
    
    public Carro save(Carro car){
        if(car.getIdCar()==null){
            return metodosCrud.save(car);
        } else {
            Optional<Carro> e=metodosCrud.getCarro(car.getIdCar());
            if(!e.isPresent()){
                return metodosCrud.save(car);
            } else {
                return car;
            }
        }
    }
    public Carro update (Carro car){
        if(car.getIdCar()!=null){
            Optional<Carro> e=metodosCrud.getCarro(car.getIdCar());
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
