package biblioteca;
import biblioteca.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aluno {
    String nome;
    int RA;
    Debito debitoAluno;

public Aluno(String nome, int RA) {
	super();
	//precisa ir no banco e criar o aluno
        this.RA = RA;
	this.nome = nome;
        debitoAluno = new Debito(this.RA);
	
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public int getRA(){
    return RA;
}

public boolean verficaAluno()
{   //Se o RA � null � retorna erro - m�todo aleat�rio ?
    Random r = new Random();
    if(this.RA == r.nextInt(100)) return false;
    else return true;
}

public boolean verificaDebito()
{       //instancia um objeto d�bito
        //Debito debito = new Debito( Integer.parseInt(this.RA)); 
	/* Aqui voc� deve chamar o metodo verificaDebito da classe debito*/
        return debitoAluno.verificaDebito();
}

//Metodo que delega a funcionalidade de emprestar para a classe emprestimo
public boolean emprestar(List<Livro> livros)
{
    Emprestimo emp = new Emprestimo(this);
    emp.emprestar((ArrayList<Livro>) livros);
    debitoAluno.setDeb(true);
    return true;
    /* Aqui voc� deve intanciar um objeto emprestimo */
	/* Aqui voc� deve chamar o metodo emprestar da classe empresitmo*/	
}
}
