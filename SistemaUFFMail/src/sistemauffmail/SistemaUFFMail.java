package sistemauffmail;


import java.io.IOException;
import java.util.*;



/**
 *
 * @author André Max
 */
public class SistemaUFFMail {
    private static final String ARQUIVO = "./alunos.csv";
    private static final String MAT = "100484";
     
    public static void main(String[] args) throws IOException {
        ListaAlunos lista = new ListaAlunos();
        LeitorArquivo auxiliar = new LeitorArquivo();
        auxiliar.ler(ARQUIVO, lista);
        System.out.println("Digite sua matrícula: ");
        Scanner scO = new Scanner(System.in);
        String mat = scO.nextLine();  // Read user input
        Aluno aluno = lista.procuraMatricula(mat);
        List <String> listaFinal = new ArrayList<>();
        if ( aluno != null){
            CriadorUM novoUFFMail = new CriadorUM();
            listaFinal = novoUFFMail.createMail(aluno, lista);
            if (listaFinal != null){
                System.out.println(aluno.getNome().substring(0, aluno.getNome().indexOf(" ")) +
                    ", por favor escolha uma das opções abaixo para o seu UFFMail");
                for (int i = 1; i < 6; i++){
                    System.out.println(i + " - " + listaFinal.get(i-1) + "@id.uff.br"); 
                }

                String op = scO.nextLine();
                System.out.println("A criação de seu e-mail (" + listaFinal.get(Integer.parseInt(op)-1) + ") será feita nos próximos minutos.");
                System.out.println("Um SMS foi enviado para " + aluno.getTelefone() + " com a sua senha de acesso.");
            }
            else{
                System.out.println("Você não pode criar um UFFMail");
            }
        }
        else{
            System.out.println("Você não pode criar um UFFMail");
        }
        
        
    }  
}
