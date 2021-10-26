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
public class RepositorioGama {
    @Autowired
    private InterfaceGama crud;
    public List<Gama> getAll(){
        return (List<Gama>) crud.findAll();
    }
    public Optional<Gama> getGama(int id){
        return crud.findById(id);
    }
    public Gama save(Gama Gama){
        return crud.save(Gama);
    }
    public void delete (Gama Gama){
        crud.delete(Gama);
    }
    
}
