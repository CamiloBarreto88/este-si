/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author Tutoria del Sabado
 */
@Entity
@Table(name = "gama")
public class Gama implements Serializable {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer idGama;
    private String name;
    
    private String description;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="gama")
    @JsonIgnoreProperties({"gama","message"})
    private List<Carro> cars;

    public Integer getIdGama() {
        return idGama;
    }

    public void setId(Integer idGama) {
        this.idGama = idGama;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Carro> getCars() {
        return cars;
    }

    public void setFarms(List<Carro> farms) {
        this.cars = farms;
    }
    
    
    
    
    
    
    
    
    
}
