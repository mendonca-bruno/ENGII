import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Emprestimo {

	Date dataEmprestimo = new Date();
	/*metodo para gegar a variavel dataEmprestimo*/
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	/*metodo para setar a variavel dataEmprestimo*/
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	/*utilize essas v�riaveis para calcular a data final de devolu��o*/
        Date dataPrevista = new Date();
	Date data_aux = new Date();
	String nome;

        /*Cada Emprestimo � composto de v�rios itens*/
	List<Item> i = new ArrayList<>();
       
	
        //Metodo respons�vel por calcular a data de devolu��o
	public Date CalculaDataDevolucao()
	{
            
            //Calendar calendario = Calendar.getInstance();
            
            if(i.size()<3){
                dataPrevista = selecionaMaiorPrazo();
            }else{
                adicionaDoisDias();
                dataPrevista = selecionaMaiorPrazo();
            }
            /*Voc� precisa implementar as regras do c�lculo da devolu��o dentro deste m�todo*/

            /*N�o esque�a de chamar o m�todo para calcular a data de devolu��o de cada item*/	

            //i.get(j).calculaDataDevolucao(date);

            //Dica use o calendar para calcular as data


            return dataPrevista;
	}
        
        public Date selecionaMaiorPrazo(){
            for(Item livro:i){                
                data_aux = livro.getDataDevolucao();
                if(data_aux.after(dataPrevista)) dataPrevista = data_aux;
            }
            return dataPrevista;
        }
        
        public void adicionaDoisDias(){
            //adiciona dois dias a cada livro
            Calendar calendario = Calendar.getInstance();
            int j=0;
            for(Item livro:i){
                if(j!=0){
                    calendario.setTime(livro.getDataDevolucao());
                    calendario.add(Calendar.DATE, 2);
                    livro.setDataDevolucao(calendario.getTime());
                }
                j++;
            }
        }
	
}