package sistemauffmail;

/**
 *
 * @author André Max
 */
public class Aluno {
    private String nome, matricula, telefone, email, uffmail, status;
    public Aluno(){
       
    }
    
    public boolean checaStatus(){
        return status.equals("Ativo");
    }
    
    @Override
    public String toString(){
        return (nome + "," + matricula + "," + telefone + "," + email + "," + uffmail + "," + status);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUffmail() {
        return uffmail;
    }

    public void setUffmail(String uffmail) {
        this.uffmail = uffmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
