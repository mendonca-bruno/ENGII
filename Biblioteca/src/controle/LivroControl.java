/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.Dao;
import modelo.Livro;

/**
 *
 * @author BrunoPC
 */
public class LivroControl {
    Dao<Livro> dao = new Dao(Livro.class);
    
    public Livro checaLivro(int chave){
        Livro l;
        l = dao.buscaCodigo(chave);
        return l;
    }
    
    public boolean inserirLivro(int cod){
        Livro l = new Livro(cod);
        dao.persist(l);
        if(checaLivro(cod)!= null) return true;
        return false;
    }
    
    public int verificaPrazo(int chave){
        Livro l = dao.buscaCodigo(chave);
        if(l!=null){
            return l.getTitulo().getPrazo();
        }
        return 0;
    }
    
    public boolean verificaExemplar(int chave){
        boolean retorno = false;
         Livro l = dao.buscaCodigo(chave);
         if(l!=null){
             if(l.isExemplarBiblioteca()) return true;
         }
         return retorno;
    }
}
