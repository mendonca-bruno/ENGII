/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import biblioteca.Aluno;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author WinSeven
 */
public class AlunoPersistence {
    private static ArrayList<Aluno> listaAlunos;
    
    public static void inserirAluno(Aluno novoAluno){
        lerXml();
        listaAlunos.add(novoAluno);
        salvarXML();
    }
    
    public static void excluirAluno(int RA){
        lerXml();
        for(Aluno aluno : listaAlunos){
            if(aluno.getRA() == RA){
                listaAlunos.remove(aluno);
            }
        }
        salvarXML();
    }
    
    //le o que esta no XML e coloca no array
    public static void lerXml(){
        File arquivo = new File("C:\\Users\\WinSeven\\Documents\\Bruno\\ENGSOFII\\Alunos.xml");
        if(arquivo.exists()){
            XStream xstream = new XStream();
            xstream.alias("aluno", Aluno.class);
            listaAlunos = (ArrayList<Aluno>) xstream.fromXML(arquivo);
        }else{
            listaAlunos = new ArrayList<>();
        }
    }
    
    //pega o que esta no vetor e salva no XML
    public static void salvarXML(){
        XStream xstream = new XStream();
        xstream.alias("aluno",Aluno.class);
        try {
            FileWriter escritor =  new FileWriter ("C:\\Users\\WinSeven\\Documents\\Bruno\\ENGSOFII\\Alunos.xml");
            escritor.write(xstream.toXML(listaAlunos));
            escritor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
