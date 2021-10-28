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
    private InterfaceGama crud1;
    
    public List<Gama> getAll(){
        return (List<Gama>) crud1.findAll();
    }
    public Optional<Gama> getGama(int id){
        return crud1.findById(id);
    }
    public Gama save(Gama gama){
        return crud1.save(gama);
    }
    public void delete (Gama gama){
        crud1.delete(gama);
    }
    
}
