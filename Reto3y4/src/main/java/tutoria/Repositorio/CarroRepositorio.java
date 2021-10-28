/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Repositorio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutoria.Modelo.Carro;
import tutoria.Interface.InterfaceCarro;

/**
 *
 * @author USUARIO
 */
@Repository
public class CarroRepositorio {
      @Autowired
    private InterfaceCarro crud;
    

    public List<Carro> getAll(){
        return (List<Carro>) crud.findAll();       
    }
    
    public Optional <Carro> getCarro(int id){
        return crud.findById(id);
    }
    
    public Carro save(Carro carro){
        return crud.save(carro);
    }
     public void delete(Carro carro){
        crud.delete(carro);
    }
    
}
