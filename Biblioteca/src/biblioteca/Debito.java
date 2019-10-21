package biblioteca;
public class Debito {
	int codigoAluno;
        boolean deb;
	public Debito(int raAluno){
		this.codigoAluno = raAluno;
                deb = false;
	}
	
	public boolean verificaDebito()
	{
            return deb;
	}
        
        public void setDeb(boolean deb){
            this.deb = deb;
        }

}