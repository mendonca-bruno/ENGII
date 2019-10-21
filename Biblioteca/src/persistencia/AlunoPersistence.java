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
        int index = -1;
        for(Aluno aluno : listaAlunos){
            if(aluno.getRA() == RA){
                index = listaAlunos.indexOf(aluno);
            }
        }
        if(index!=-1) listaAlunos.remove(index);
        salvarXML();
    }
    
    public static boolean verificaDebito(int RA){
        boolean retorno = false;
        lerXml();
        for(Aluno aluno : listaAlunos){
            if(aluno.getRA() == RA){
                if(aluno.getDebitoAluno().verificaDebito())retorno = true;
            }
        }
        //salvarXML();
        return retorno;
    }
    
    public static Aluno buscarAluno(int RA){
        Aluno al = null;
        //boolean retorno = false;
        lerXml();
        for(Aluno aluno : listaAlunos){
            if(aluno.getRA() == RA){
                al = aluno;
            }
        }
        //salvarXML();
        return al;
    }
    
    public static boolean checaAluno(int RA){
        
        boolean retorno = false;
        lerXml();
        for(Aluno aluno : listaAlunos){
            if(aluno.getRA() == RA){
                retorno = true;
            }
        }
        //salvarXML();
        return retorno;
    }
    
    //le o que esta no XML e coloca no array
    public static void lerXml(){
        File arquivo = new File("Alunos.xml");
        if(arquivo.exists()){
            XStream xstream = new XStream();
            xstream.allowTypesByWildcard(new String[] {
                "com.your.package.**"
            });
            xstream.alias("aluno", Aluno.class);
            listaAlunos = (ArrayList<Aluno>) xstream.fromXML(arquivo);
        }else{
            listaAlunos = new ArrayList<>();
        }
    }
    
    //pega o que esta no vetor e salva no XML
    public static void salvarXML(){
        XStream xstream = new XStream();
        xstream.allowTypesByWildcard(new String[] {
                "com.your.package.**"
            });
        xstream.alias("aluno",Aluno.class);
        try {
            FileWriter escritor =  new FileWriter ("Alunos.xml");
            escritor.write(xstream.toXML(listaAlunos));
            escritor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
