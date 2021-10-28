/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Servicios;

import tutoria.Modelo.Carro;
import tutoria.Repositorio.CarroRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosCarro {
        @Autowired
    private CarroRepositorio metodosCrud;
    
    public List<Carro> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Carro> getCarro(int carId){
        return metodosCrud.getCarro(carId);
    }
    
    public Carro save(Carro carro){
        if(carro.getIdCar()==null){
            return metodosCrud.save(carro);
        }else{
            Optional<Carro> evt=metodosCrud.getCarro(carro.getIdCar());
            if(evt.isEmpty()){
                return metodosCrud.save(carro);
            }else{
                return carro;
            }
        }
    }
    public Carro update(Carro carro){
        if(carro.getIdCar()!=null){
            Optional<Carro> e=metodosCrud.getCarro(carro.getIdCar());
            if(!e.isEmpty()){
                if(carro.getName()!=null){
                    e.get().setName(carro.getName());
                }
                if(carro.getAddress()!=null){
                    e.get().setAddress(carro.getAddress());
                }
                if(carro.getExtension()!=null){
                    e.get().setExtension(carro.getExtension());
                }
                if(carro.getDescription()!=null){
                    e.get().setDescription(carro.getDescription());
                }
                if(carro.getGama()!=null){
                    e.get().setGama(carro.getGama());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return carro;
            }
        }else{
            return carro;
        }
    }


    public boolean deleteCarro(int carroId) {
        Boolean aBoolean = getCarro(carroId).map(carro -> {
            metodosCrud.delete(carro);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
