package exercicio09;

public class Especie {
    private Integer id;
    private String nome;
    private Planeta planetaOrigem;
    private int nivelDePericulosidadeBase;

    public Especie(Integer id, String nome, Planeta planetaOrigem, int nivelDePericulosidadeBase) {
        this.id = id;
        this.nome = nome;
        this.planetaOrigem = planetaOrigem;
        this.nivelDePericulosidadeBase = nivelDePericulosidadeBase;
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

    public Planeta getPlanetaOrigem() {
        return planetaOrigem;
    }

    public void setPlanetaOrigem(Planeta planetaOrigem) {
        this.planetaOrigem = planetaOrigem;
    }

    public int getNivelDePericulosidadeBase() {
        return nivelDePericulosidadeBase;
    }

    public void setNivelDePericulosidadeBase(int nivelDePericulosidadeBase) {
        this.nivelDePericulosidadeBase = nivelDePericulosidadeBase;
    }

    @Override
    public String toString() {
        return "Especie{" +
                "id= " + id +
                ", nome = '" + nome + '\'' +
                ", planetaOrigem = " + planetaOrigem +
                ", nivelDePericulosidadeBase = " + nivelDePericulosidadeBase +
                '}';
    }
}
