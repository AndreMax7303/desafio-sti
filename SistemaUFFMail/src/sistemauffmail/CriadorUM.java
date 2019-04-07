package sistemauffmail;

import static java.lang.Boolean.parseBoolean;
import java.util.*;



/**
 *
 * @author André Max
 */
public class CriadorUM {
    
    private void implementaSugestoes(String sug, ListaAlunos lista, List sugestoes){
        if(!lista.uffmails.contains(sug)){
            sugestoes.add(sug.toLowerCase());
        }
    }
    
    private List criaSugestoes(Aluno aluno, ListaAlunos lista){
        String nome = aluno.getNome();
        String email = aluno.getEmail().substring(0,aluno.getEmail().indexOf("@"));
        String matricula = aluno.getMatricula();
        List<String> sugestoes = new ArrayList<>();
        String ideias[] = {email, 
            nome.replaceAll("\\s",""),
            nome.split(" ")[0]  + matricula.substring(matricula.length()-2) + matricula.substring(matricula.length()-1),
            nome.split(" ")[0] ,
            nome.split(" ")[0] + nome.substring(nome.lastIndexOf(" ")+1),
            nome.substring(nome.lastIndexOf(" ")+1) + nome.split(" ")[0],
            nome.charAt(0)+ nome.substring(nome.lastIndexOf(" ")+1)
                };
        int i = 0;
        while (sugestoes.size() < 5){
            implementaSugestoes(ideias[i], lista, sugestoes);
            i++;
        }
        return sugestoes;
    }
    
    public List createMail(Aluno aluno, ListaAlunos lista){
        if (aluno.getUffmail().length() == 0 && aluno.checaStatus()){
            return criaSugestoes(aluno,lista);
        }
        else{
            return null;
        }
    }
}
