/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import biblioteca.Aluno;
import biblioteca.Livro;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import static persistencia.AlunoPersistence.lerXml;

/**
 *
 * @author BrunoPC
 */
public class LivroPersistence {
    private static ArrayList<Livro> listaLivros;
    
    public static void inserirLivro(Livro novoLivro){
        lerXml();
        listaLivros.add(novoLivro);
        salvarXML();
    }
    
    public static void excluirLivro(int codLivro){
        lerXml();
        int index = -1;
        for(Livro livro : listaLivros){
            if(livro.getCodigo()== codLivro){
                index = listaLivros.indexOf(livro);
            }
        }
        if(index!=-1) listaLivros.remove(index);
        salvarXML();
    }
    
    public static boolean buscarLivro(int cod){
        boolean retorno = false;
        lerXml();
        for(Livro livro : listaLivros){
            if(livro.getCodigo() == cod){
                retorno = true;
            }
        }
        //salvarXML();
        return retorno;
    }
    
    //le o que esta no XML e coloca no array
    public static void lerXml(){
        File arquivo = new File("Livros.xml");
        if(arquivo.exists()){
            XStream xstream = new XStream();
            xstream.allowTypesByWildcard(new String[] {
                "com.your.package.**"
            });
            xstream.alias("livro", Livro.class);
            listaLivros = (ArrayList<Livro>) xstream.fromXML(arquivo);
        }else{
            listaLivros = new ArrayList<>();
        }
    }
    
    //pega o que esta no vetor e salva no XML
    public static void salvarXML(){
        XStream xstream = new XStream();
        xstream.allowTypesByWildcard(new String[] {
                "com.your.package.**"
            });
        xstream.alias("livro",Livro.class);
        try {
            FileWriter escritor =  new FileWriter ("Livros.xml");
            escritor.write(xstream.toXML(listaLivros));
            escritor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
