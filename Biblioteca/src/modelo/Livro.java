/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import dao.Dao;
import java.io.Serializable;
import modelo.Debito;
import java.util.Random;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author BrunoPC
 */
@Entity
public class Livro implements Serializable{
    @Id
    Integer codigo;
    boolean exemplarBiblioteca;
    @Column
    Titulo titulo;
    
    public Livro(){
        
    }

    public Livro(int codigo) {
            //super();
            //inst�ncia um titulo e o associa ao livro
            this.codigo = codigo;
            Dao<Titulo> dao = new Dao(Titulo.class);
            titulo = new Titulo(codigo);
            dao.persist(titulo);
            //codigo aleat�rio para definir se o livro � exemplar unico
            Random r = new Random();
            if (codigo == (r.nextInt((100-0)+1)+0) )
                    exemplarBiblioteca =true;
            else
                    exemplarBiblioteca =false;
    }

    public boolean verificaLivro()
    {  return exemplarBiblioteca;

    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public boolean isExemplarBiblioteca() {
        return exemplarBiblioteca;
    }

    public void setExemplarBiblioteca(boolean exemplarBiblioteca) {
        this.exemplarBiblioteca = exemplarBiblioteca;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }


    @Override
    public String toString(){
        String teste = codigo.toString();
        return teste;
    }
}