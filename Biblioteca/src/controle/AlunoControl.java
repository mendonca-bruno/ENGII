/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.Dao;
import java.util.ArrayList;
import java.util.List;
import modelo.Aluno;
import modelo.Livro;

/**
 *
 * @author BrunoPC
 */
public class AlunoControl {
    Dao<Aluno> dao = new Dao(Aluno.class);
    
    public Aluno checaAluno(int chave){
        Aluno al;
        al = dao.buscaCodigo(chave);
        return al;
    }
    
    public boolean verificaDebito(int chave){
        Aluno al = dao.buscaCodigo(chave);
        if(al!=null){
            if(al.getDebitoAluno().verificaDebito()==true) return true;
        }
        return false;
    }
    
    public boolean inserirAluno(int RA, String nome){
        Aluno a = new Aluno(nome,RA);
        dao.persist(a);
        if(checaAluno(RA)!= null) return true;
        return false;        
    }
    
    public boolean emprestar(Aluno aluno, List<Livro> listaLivros){
        boolean retorno = false;
        List<Livro> livros = new ArrayList<Livro>();
        
        for(Livro l:listaLivros){
            if(!l.isExemplarBiblioteca()) livros.add(l);
        }
        
        if(livros.size()>0){
            retorno = aluno.emprestar(livros);
            return retorno;
        }
        return retorno;
    }
}
