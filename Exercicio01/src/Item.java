import java.util.Calendar;
import java.util.Date;

public class Item {
   /*Cada Item � associado a um livro*/
	Livro livro;
    Date dataDevolucao;
 
    /*Constructor, quando uma instancia do item � criada
     * j� � associada a ela o livro*/
    public Item(Livro livro) {
		super();
		this.livro = livro;
                dataDevolucao = new Date();
                calculaDataDevolucao();
	}
    
    /*M�todo getDataDevolucao*/
	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	/*M�todo setDataDevolucao*/
	public void setDataDevolucao(Date dataDevolucao) {
           
		this.dataDevolucao = dataDevolucao;
	}
	
	/*M�todo getLivro*/
	public Livro getLivro() {
		return livro;
	}
	
	/*M�todo setLivro*/
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	/*Voc� deve implementarDate calculaDataDevolucao(Date data)
	 * 
	 */
	    /*Use a fun��o Calendar*/
	    
	    //Calendar calendar = Calendar.getInstance();
		//calendar.setTime(data);
         /*precisa acessar o m�todo de livro que retorna o prazo*/
		//calendar.add(Calendar.DATE, prazo);
        //dataDevolucao = calendar.getTime();
        
        Date calculaDataDevolucao(){
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(dataDevolucao);
            calendario.add(Calendar.DATE, this.livro.verPrazo());
            dataDevolucao = calendario.getTime();
            return dataDevolucao;
        }
		
}
