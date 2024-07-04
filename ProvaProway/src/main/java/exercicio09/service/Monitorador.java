package exercicio09.service;

import exercicio09.Alienigina;

import java.util.ArrayList;

public abstract class Monitorador {

    public static Double calcularPericulosidade(Alienigina alienigina) {
        Double pontosDePericulosidade = (alienigina.getNivelDePericulosidade() + (alienigina.getEspecie().getNivelDePericulosidadeBase() * 0.3));

        return pontosDePericulosidade;
    }

    public static Boolean verificarNecessidadeDeQuarentena(Alienigina alienigina) {
        Double periculosidade = calcularPericulosidade(alienigina);

        if (periculosidade < 2) {
            System.out.println("Periculosidade do alienígena: "
                    + alienigina.getNivelDePericulosidade() +
                    "\nPericulosidade da espécie dele: " + alienigina.getEspecie().getNivelDePericulosidadeBase() +
                    "\nPontos de periculosidade final: " + periculosidade +
                    "\nResultado da avaliação: Esse alienígena não apresenta perigo!");
        }   else if (periculosidade >= 2 && periculosidade <= 5) {
            System.out.println("Periculosidade do alienígena: "
                    + alienigina.getNivelDePericulosidade() +
                    "\nPericulosidade da espécie dele: " + alienigina.getEspecie().getNivelDePericulosidadeBase() +
                    "\nPontos de periculosidade final: " + periculosidade +
                    "\nResultado da avaliação: Esse alienígena é suspeito, mas pode passar!");
        } else if (periculosidade >= 6) {
            System.out.println("Periculosidade do alienígena: "
                    + alienigina.getNivelDePericulosidade() +
                    "\nPericulosidade da espécie dele: " + alienigina.getEspecie().getNivelDePericulosidadeBase() +
                    "\nPontos de periculosidade final: " + periculosidade +
                    "\nResultado da avaliação: Esse alienígena deve ser colocado em quarentena imediatamente!");
            return true;
        }   else {
            System.out.println("Não foi possível saber se a quarentena é necessária!");
        }

        return false;
    }

    public static void aplicarQuarentena(Alienigina alienigina) {
        alienigina.setEstaDeQuarentena(true);
        System.out.println("O alienígena " + alienigina.getNome() + " foi colocado de quarentena!");
    }

}
