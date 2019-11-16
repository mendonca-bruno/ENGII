/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import dao.Dao;
import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;


/**
 *
 * @author BrunoPC
 */
@Entity
@Access(AccessType.FIELD)
public class Titulo implements Serializable{
    @Id
    int prazo;
    Autor autor;
    Area area;

    public Titulo() {
    }
    
    public Titulo(int codigo){
        this.prazo = codigo+1;
        Dao<Autor> daoAutor = new Dao(Autor.class);
        autor = new Autor("Autor " + codigo);
        daoAutor.persist(autor);
        Dao<Area> daoArea = new Dao(Area.class);
        area = new Area(""+codigo);
        daoArea.persist(area);
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    
}
