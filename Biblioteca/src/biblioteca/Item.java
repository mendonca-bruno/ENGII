package biblioteca;
import biblioteca.Livro;
import java.util.Calendar;
import java.util.Date;

public class Item {
    //Cada Item tem um livro associado
	Livro livro;
    Date dataDevolucao;
    
    //Quando um item � criado, um livro � associado a ele
	public Item(Livro livro) {
		super();
		this.livro = livro;
                dataDevolucao = new Date();
		
	}


	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	//Metodo para calcular a data de Devolucao de cada Item
	public Date calculaDataDevolucao(Date data)
	{
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(dataDevolucao);
            calendario.add(Calendar.DATE, this.livro.verPrazo());
            dataDevolucao = calendario.getTime();
            return dataDevolucao;
	}

}
