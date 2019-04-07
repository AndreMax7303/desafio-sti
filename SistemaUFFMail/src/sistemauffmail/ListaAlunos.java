package sistemauffmail;

import java.util.*;

/**
 *
 * @author André Max
 */
public class ListaAlunos {
    public List<Aluno> listagem = new ArrayList<>();
    List<String> uffmails = new ArrayList<>();
    
    public void imprimeLista(){
        ListIterator ltr = listagem.listIterator();
        while(ltr.hasNext()){
            System.out.println(ltr.next().toString());
        }
    }
    
    public Aluno procuraMatricula(String matricula){
        ListIterator<Aluno> ltr = listagem.listIterator();
        while(ltr.hasNext()){
            Aluno aluno = ltr.next();
            if(aluno.getMatricula().equals(matricula)){
                return aluno;
            }
        }
        return null;
    }
    
}


