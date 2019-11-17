package biblioteca;
import biblioteca.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import persistencia.AlunoPersistence;
import persistencia.EmprestimoPersistence;

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

public Debito getDebitoAluno(){
    return this.debitoAluno;
}

public boolean verficaAluno(int RA)
{   //Se o RA � null � retorna erro - m�todo aleat�rio ?
    //Random r = new Random();
    if(AlunoPersistence.checaAluno(RA)) return true;
    else return false;
}

public boolean verificaDebito()
{       //instancia um objeto d�bito
        //Debito debito = new Debito( Integer.parseInt(this.RA)); 
	/* Aqui voc� deve chamar o metodo verificaDebito da classe debito*/
        return AlunoPersistence.verificaDebito(this.RA);
}

//Metodo que delega a funcionalidade de emprestar para a classe emprestimo
public boolean emprestar(List<Livro> livros)
{
    Emprestimo emp = new Emprestimo(this);
    emp.emprestar((ArrayList<Livro>) livros);
    AlunoPersistence.alteraAluno(RA);
    EmprestimoPersistence.inserirEmprestimo(emp);
    return true;
    /* Aqui voc� deve intanciar um objeto emprestimo */
	/* Aqui voc� deve chamar o metodo emprestar da classe empresitmo*/	
}

@Override
public String toString(){
    return nome;
}
}
