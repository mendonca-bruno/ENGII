/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.Dao;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author BrunoPC
 */
@Entity
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    //Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    @Id
    int RA;
    String nome;
    Debito debitoAluno;
    
    public Aluno(){
        
    }
    public Aluno (String nome, int RA){
        this.nome = nome;
        this.RA = RA;
        Dao dao = new Dao(Debito.class);
        debitoAluno = new Debito(RA);
        dao.persist(debitoAluno);
        
    }

    public Debito getDebitoAluno() {
        return debitoAluno;
    }

    public void setDebitoAluno(Debito debitoAluno) {
        this.debitoAluno = debitoAluno;
    }
    
    public int getRA() {
        return RA;
    }

    public void setRA(int RA) {
        this.RA = RA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.RA;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.RA != other.RA) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return nome;
    }
    
}
