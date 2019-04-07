package sistemauffmail;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author André Max
 */
public class LeitorArquivo {
    
    public void populaLista(ListaAlunos lista,CSVRecord csvRecord){
        Aluno novo = new Aluno();
        novo.setNome(csvRecord.get(0));
        novo.setMatricula(csvRecord.get(1));
        novo.setTelefone(csvRecord.get(2));
        novo.setEmail(csvRecord.get(3));
        novo.setUffmail(csvRecord.get(4));
        novo.setStatus(csvRecord.get(5));

        lista.listagem.add(novo);
        if (novo.getUffmail().length() != 0){
            lista.uffmails.add(csvRecord.get(4).substring(0, csvRecord.get(4).indexOf("@")));   
        }
        
    }
    
    public void ler(String endereco, ListaAlunos lista) throws IOException {
    try (
            Reader reader = Files.newBufferedReader(Paths.get(endereco));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                populaLista(lista, csvRecord);    
            }
        }
    }
}