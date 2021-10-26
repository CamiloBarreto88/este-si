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
public class ServiciosMensaje {
    
    @Autowired
    private RepositorioMensaje metodosCrud;
    
    public List<Mensaje> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Mensaje> getMessage(int messageId){
        return metodosCrud.getMessage(messageId);
    }
    
    public Mensaje save (Mensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        } else {
            Optional<Mensaje> e= metodosCrud.getMessage(message.getIdMessage());
            if(!e.isPresent()){
                return metodosCrud.save(message);
            } else {
                return message;
            }
        }
    }
    
    public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> e= metodosCrud.getMessage(message.getIdMessage());
            if(e.isPresent()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }
    
    public boolean deleteMessage(int messageId){
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
