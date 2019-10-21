/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import biblioteca.Emprestimo;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author BrunoPC
 */
public class EmprestimoPersistence {
    private static ArrayList<Emprestimo> listaEmprestimos;
    
    public static void inserirEmprestimo(Emprestimo novoEmprestimo){
        lerXml();
        listaEmprestimos.add(novoEmprestimo);
        salvarXML();
    }
    
    public static void excluirEmprestimo(int codEmprestimo){
        lerXml();
        int index = -1;
        for(Emprestimo emp : listaEmprestimos){
            if(emp.getIdEmprestimo() == codEmprestimo){
                index = listaEmprestimos.indexOf(emp);
            }
        }
        if(index!=-1) listaEmprestimos.remove(index);
        salvarXML();
    }
    
    //le o que esta no XML e coloca no array
    public static void lerXml(){
        File arquivo = new File("Emprestimos.xml");
        if(arquivo.exists()){
            XStream xstream = new XStream();
            xstream.allowTypesByWildcard(new String[] {
                "com.your.package.**"
            });
            xstream.alias("emprestimo", Emprestimo.class);
            listaEmprestimos = (ArrayList<Emprestimo>) xstream.fromXML(arquivo);
        }else{
            listaEmprestimos = new ArrayList<>();
        }
    }
    
    //pega o que esta no vetor e salva no XML
    public static void salvarXML(){
        XStream xstream = new XStream();
        xstream.allowTypesByWildcard(new String[] {
                "com.your.package.**"
            });
        xstream.alias("emprestimo",Emprestimo.class);
        try {
            FileWriter escritor =  new FileWriter ("Emprestimos.xml");
            escritor.write(xstream.toXML(listaEmprestimos));
            escritor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
