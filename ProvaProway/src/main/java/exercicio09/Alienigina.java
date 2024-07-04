package exercicio09;

import java.time.LocalDateTime;

public class Alienigina {
    private Integer id;
    private String nome;
    private Especie especie;
    private int nivelDePericulosidade;
    private LocalDateTime dataHoraDaEntrada;
    private Boolean estaDeQuarentena;


    public Alienigina(Integer id, String nome, Especie especie, int nivelDePericulosidade, LocalDateTime dataHoraDaEntrada) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.nivelDePericulosidade = nivelDePericulosidade;
        this.dataHoraDaEntrada = dataHoraDaEntrada;
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

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public int getNivelDePericulosidade() {
        return nivelDePericulosidade;
    }

    public void setNivelDePericulosidade(int nivelDePericulosidade) {
        this.nivelDePericulosidade = nivelDePericulosidade;
    }

    public LocalDateTime  getDataHoraDaEntrada() {
        return dataHoraDaEntrada;
    }

    public void  setDataHoraDaEntrada(LocalDateTime  dataHoraDaEntrada) {
        this.dataHoraDaEntrada = dataHoraDaEntrada;
    }

    public Boolean getEstaDeQuarentena() {
        return estaDeQuarentena;
    }

    public void setEstaDeQuarentena(Boolean estaDeQuarentena) {
        this.estaDeQuarentena = estaDeQuarentena;
    }

    @Override
    public String toString() {
        return "Alienigina{" +
                "id = " + id +
                ", nome = '" + nome + '\'' +
                ", especie = " + especie +
                ", nivelDePericulosidade = " + nivelDePericulosidade +
                ", dataHoraDaEntrada = " + dataHoraDaEntrada +
                ", estaDeQuarentena = " + estaDeQuarentena +
                '}';
    }
}
