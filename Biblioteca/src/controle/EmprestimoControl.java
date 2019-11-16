/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.Dao;
import modelo.Emprestimo;

/**
 *
 * @author BrunoPC
 */
public class EmprestimoControl {
    Dao<Emprestimo> dao = new Dao(Emprestimo.class);
    
    public Emprestimo checaEmprestimo(int chave){
        Emprestimo emp;
        emp = dao.buscaCodigo(chave);
        return emp;
    }
}
