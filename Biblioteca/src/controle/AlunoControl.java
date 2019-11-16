/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.Dao;
import modelo.Aluno;

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
        dao.inserir(a);
        if(checaAluno(RA)!= null) return true;
        return false;        
    }
}
