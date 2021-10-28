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
public class ServiciosGama {
    @Autowired
    private RepositorioGama metodosCrud;
    
    public List<Gama> getAll() {
        return metodosCrud.getAll();
    }
    public Optional<Gama> getGama(int gamaId){
        return metodosCrud.getGama(gamaId);
    }
    public Gama save(Gama gama){
        if (gama.getIdGama()==null) {
            return metodosCrud.save(gama);
        } else {
            Optional<Gama> gama1 = metodosCrud.getGama(gama.getIdGama());
            if (!gama1.isPresent()){
                return metodosCrud.save(gama);
            } else {
                return gama;
            }
        }
    }
    
    public Gama update(Gama gama){
        if(gama.getIdGama()!=null){
            Optional<Gama>gama1=metodosCrud.getGama(gama.getIdGama());
            if(gama1.isPresent()){
                if(gama.getName()!=null){
                    gama1.get().setName(gama.getName());
                }               
                if(gama.getDescription()!=null){
                    gama1.get().setDescription(gama.getDescription());
                }
                metodosCrud.save(gama1.get());
                return gama1.get();
            } else {
                return gama;
            }
        } else {
            return gama;
        }
    }
    
    public boolean deleteGama(int gamaId){
        Boolean aBoolean=getGama(gamaId).map(gama -> {
            metodosCrud.delete(gama);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
