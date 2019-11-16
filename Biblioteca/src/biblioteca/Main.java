package biblioteca;
import controle.AlunoControl;
import dao.AlunoDAO;
import dao.Dao;
import interf.Interface;
import java.util.ArrayList;
import java.util.Scanner;
import persistencia.AlunoPersistence;
import modelo.Aluno;

public class Main {

	public static void main(String[] args) {
		 
		 //Scanner entrada = new Scanner (System.in);
		 //int[] codigos= {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                 //ArrayList<Integer> codigos = new ArrayList<>();
		 /*System.out.print("Digite o RA do Aluno: ");
		 Integer RA = entrada.nextInt();
                 System.out.print("Digite o nome do Aluno: ");
		 String nome = entrada.nextLine();
		 System.out.print("Digite o numero de Livros a ser Emprestado: ");
		 int num = entrada.nextInt();
                 */
                 /*Integer RA = 122;
                 String nome = "Jow";
                 int num = 4;
		 int aux;
		 for(int i=0;i<num;i++)
		 {
			 System.out.print("Digite o codigo do livro "+(i+1)+":");
			 aux=entrada.nextInt();
			 codigos.add(aux);
		 }
		 
                Controle c = new Controle();
                c.emprestar(RA, nome, codigos, num);*/
            Interface intef = new Interface();
            intef.setVisible(true);
            //Dao<Aluno> dao = new Dao(Aluno.class);
            //Aluno aluno = new Aluno("Luiz", 120159);
            //alunoDAO.persist(aluno);
            //dao.persist(aluno);
            /*System.out.println("Done");
            AlunoControl c = new AlunoControl();
            Aluno a = c.checaAluno(120157);
            if(a!=null) System.out.println("Deu bom");
            System.out.println(c.verificaDebito(120157));*/
            
            
            //Aluno a = new Aluno("Wilson", 123);
            //AlunoPersistence.excluirAluno(120);
    	 
    		 
	}

}
