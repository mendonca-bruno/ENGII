package biblioteca;
import biblioteca.Livro;
import java.util.ArrayList;
import java.util.List;
import persistencia.AlunoPersistence;

public class Controle {

  public boolean emprestar(Integer RA, String nome, ArrayList<Integer> prazos, int num)
  {
	  boolean retorno=true;
	  /*Aqui voc� deve instaciar um objeto aluno*/
	  Aluno a = new Aluno(nome, RA);
          //AlunoPersistence.inserirAluno(a);
	  //Verifica se o aluno existe
	  if (!a.verficaAluno())
	  {
		  System.out.println("Aluno Inexistente");
		  retorno = false;
       }
	  
	  //Verifica se o aluno possui algum Debito
	  if (a.verificaDebito())
	  {
		  System.out.println("Aluno em Debito");
		  retorno = false;
       }
	  
	  //Caso o aluno n�o tenha d�bitos e exista
	  if(retorno)
	  {   
		  //Cria um conjunto de livros
		  List<Livro> livros = new ArrayList<Livro>();  
	     
		  /*Para cada livro verifica  se � exemplar da biblioteca 
                   e s� deixar� emprestar os livros que n�o s�o */
                  for(int i=0; i< num;i++)
		   {   Livro l = new Livro(prazos.get(i));
		     //caso o livro n�o seja exemplar da biblioteca permite emprestar  
		     if (!l.verificaLivro())
			   livros.add(l); 
		   }
			
		   /*Chama o m�todo delegado do aluno de emprestar cliente, passando o conjunto de livros como parametro caso tenha pelo menos um livro a ser emprestado*/
		   if (livros.size() > 0 )
		   {   
		     retorno = a.emprestar(livros);
		     return retorno;
		   }
		   else
		   return false;
		  
	  }
	  else
		  return retorno;
  }
	
}
