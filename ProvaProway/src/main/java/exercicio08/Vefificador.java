package exercicio08;

public abstract class Vefificador {
    public static Boolean verificarFinalString(String primeiraString, String segundaString) {

        String ultimasDoisCaracteresDaPrimeiraString = primeiraString.substring(primeiraString.length() - 2);

        String primeirosDoisCaracteresDaSegundaString = segundaString.substring(0, 2);

        return ultimasDoisCaracteresDaPrimeiraString.equals(primeirosDoisCaracteresDaSegundaString);
    }
}
