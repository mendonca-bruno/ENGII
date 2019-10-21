package biblioteca;

import java.util.Random;

public class Livro {

	int prazo;
	boolean exemplarBiblioteca;
	Titulo titulo;

	public Livro(int codigo) {
		super();
		//inst�ncia um titulo e o associa ao livro
		titulo = new Titulo(codigo);
		//codigo aleat�rio para definir se o livro � exemplar unico
                Random r = new Random();
		if (codigo == (r.nextInt((100-0)+1)+0) )
			exemplarBiblioteca =true;
		else
			exemplarBiblioteca =false;
	}

	public int verPrazo() {
		return titulo.getPrazo();
	}

	
	public boolean verificaLivro()
	{  return exemplarBiblioteca;
	   
	}
	
}