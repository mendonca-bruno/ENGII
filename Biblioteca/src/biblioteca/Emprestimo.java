package biblioteca;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Emprestimo {
    Date dataEmprestimo;
    Date dataPrevista;
    Date data_aux;
    //String nome;
    //Cada emprestimo tem um conjutno de itens
    List<Item> item;
    int idEmprestimo;
    
    public Emprestimo(Aluno a){
        dataEmprestimo = new Date();
        dataPrevista = new Date();
        data_aux = new Date();
        item = new ArrayList<Item>();
        idEmprestimo = a.RA;
    }
	
	public Date getDataEmprestimo() {
            
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	
	// Metodo respons�vel por realizar o empr�stimo
    public boolean emprestar(ArrayList<Livro> livros) {
        
		// TODO Auto-generated method stub
    	int aux;
    	//Para o numero de livros a ser emprestado
    	for(int i=0; i<livros.size();i++)
		//Adiciona um novo item no cojunto de items, e passa o livro a ser associado a ele
    		item.add(new Item(livros.get(i))); 
         
          //Chama o metodo para calcular a data de devolu��o caso tenha pelo menos um livro que possa ser emprestado
    		CalculaDataDevolucao();
    		System.out.print("\nNumero de Livros Emprestados: "+livros.size());
                System.out.print("\nData de Empr�stimo: "+this.dataEmprestimo);
                System.out.print("\nData de Devolu��o: "+this.dataPrevista);
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
	
}
