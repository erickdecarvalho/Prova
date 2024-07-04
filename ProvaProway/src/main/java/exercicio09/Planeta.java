package exercicio09;

public class Planeta {
    private Integer id;
    private String nome;

    public Planeta(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Planeta{" +
                "id = " + id +
                ", nome = '" + nome + '\'' +
                '}';
    }
}
