/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Repositorio;

import tutoria.Modelo.Gama;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutoria.Interface.InterfaceGama;

/**
 *
 * @author USUARIO
 */
@Repository
public class GamaRepositorio {
       @Autowired
    private InterfaceGama crud2;
    
     public List<Gama> getAll(){
        return (List<Gama>) crud2. findAll();       
    }
    
    public Optional <Gama> getGama(int id){
        return crud2.findById(id);
    }
    
    public Gama save(Gama gama){
        return crud2.save(gama);
    }
     public void delete(Gama gama){
        crud2.delete(gama);
    }
}
