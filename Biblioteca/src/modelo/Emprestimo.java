/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.Dao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author BrunoPC
 */
@Entity
public class Emprestimo implements Serializable{
    @Id
    int idEmprestimo;
    Date dataEmprestimo;
    Date dataPrevista;
    Date data_aux;
    @ElementCollection(targetClass=Item.class)
    List<Item> item;
    @Column(nullable = true)
    boolean ativo;
    
    public Emprestimo(){
        
    }
    
    public Emprestimo(Aluno a){
        dataEmprestimo = new Date();
        dataPrevista = new Date();
        data_aux = new Date();
        item = new ArrayList<Item>();
        idEmprestimo = a.RA;
        ativo = false;
    }
    
    public boolean emprestar(ArrayList<Livro> livros) {
        
		// TODO Auto-generated method stub
    	int aux;
    	//Para o numero de livros a ser emprestado
    	for(int i=0; i<livros.size();i++){
            Item it = new Item(livros.get(i));
            item.add(it);
            Dao<Item> dao = new Dao(Item.class);
            dao.persist(it);
        }
		//Adiciona um novo item no cojunto de items, e passa o livro a ser associado a ele
         
          //Chama o metodo para calcular a data de devolu��o caso tenha pelo menos um livro que possa ser emprestado
    		CalculaDataDevolucao();
    		System.out.print("\nNumero de Livros Emprestados: "+livros.size());
                System.out.print("\nData de Empréstimo: "+this.dataEmprestimo);
                System.out.print("\nData de Devolução: "+this.dataPrevista);
                ativo = true;
    		return true;
    	
    	
	}
    
	private Date CalculaDataDevolucao()
	{                        
            if(item.size()<3){
                dataPrevista = selecionaMaiorPrazo();
            }else{
                adicionaDoisDias();
                dataPrevista = selecionaMaiorPrazo();
            }

            return dataPrevista;	
	}
        
        public Date selecionaMaiorPrazo(){
            for(Item livro:item){                
                data_aux = livro.getDataDevolucao();
                if(data_aux.after(dataPrevista)) dataPrevista = data_aux;
            }
            return dataPrevista;
        }
        
        public void adicionaDoisDias(){
            //adiciona dois dias a cada livro
            Calendar calendario = Calendar.getInstance();
            int j=0;
            for(Item livro:item){
                if(j!=0){
                    calendario.setTime(livro.getDataDevolucao());
                    calendario.add(Calendar.DATE, 2);
                    livro.setDataDevolucao(calendario.getTime());
                }
                j++;
            }
        }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
        
        
}
