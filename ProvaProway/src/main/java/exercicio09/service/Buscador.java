package exercicio09.service;

import exercicio09.Alienigina;
import exercicio09.Especie;
import exercicio09.Planeta;

import java.util.ArrayList;

public class Buscador {

    public static Especie buscarEspeciePorId(int id, ArrayList<Especie> especies) {
        for (Especie especie : especies) {
            if (especie.getId().equals(id)) {
                return especie;
            }
        }
        return null;
    }

    public static Alienigina buscarAlieniginasPorId(int id, ArrayList<Alienigina> alieniginas) {
        for (Alienigina alienigina : alieniginas) {
            if (alienigina.getId().equals(id)) {
                return alienigina;
            }
        }
        return null;
    }

    public static Planeta buscarPlanetaPorId(int id, ArrayList<Planeta> planetas) {
        for (Planeta planeta : planetas) {
            if (planeta.getId().equals(id)) {
                return planeta;
            }
        }
        return null;
    }
}
