package biblioteca;
public class Titulo {
int prazo;
Autor autor;
Area area;
public Titulo(int codigo)
{
	this.prazo = codigo+1;
        autor = new Autor("Autor " + codigo);
        area = new Area(""+codigo);
}
public int getPrazo() {
	return prazo;
}

public void setPrazo(int prazo) {
	this.prazo = prazo;
}

}