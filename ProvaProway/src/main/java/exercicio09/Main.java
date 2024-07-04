package exercicio09;

import exercicio09.service.Buscador;
import exercicio09.service.Monitorador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<Alienigina> alieniginas = new ArrayList<>();
    static ArrayList<Especie> especies = new ArrayList<>();
    static ArrayList<Planeta> planetas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Buscador buscador;

    public static void main(String[] args) {

        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarAlienigina(scanner);
                    break;
                case 2:
                    criarEspecie(scanner);
                    break;
                case 3:
                    criarPlaneta(scanner);
                    break;
                case 4:
                    listarAlieniginas();
                    break;
                case 5:
                    listarEspecies();
                    break;
                case 6:
                    listarPlanetas();
                    break;
                case 7:
                    avaliarPericulosidade(scanner);
                    break;
                case 8:
                    colocarAlienigenaEmQuarentena(scanner);
                    break;
                case 9:
                    listarAlienigenasEmQuarentena();
                    break;
                case 10:
                    verRankingDePericulosidade(alieniginas);
                    break;
                case 11:
                    verAlienigenasQueEntraramNaTerraNosUltimosSeisMeses(alieniginas);
                    break;
                case 12:
                    verAlienigenasPorEspecie();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1 - Cadastrar alienígina" +
                "\n2 - Cadastrar espécie" +
                "\n3 - Criar planeta" +
                "\n4 - Listar alienígenas" +
                "\n5 - Listar espécies" +
                "\n6 - Listar planetas" +
                "\n7 - Avaliar periculosidade" +
                "\n8 - Colocar alienígena em quarentena" +
                "\n9 - Ver alienígenas em quarentena" +
                "\n10 - Ver ranking por periculosidade" +
                "\n11 - Ver alienígenas que entraram na terra nos últimos 6 meses" +
                "\n12 - Ver alienígenas por espécie");

        System.out.println("0 - Sair");
    }

    private static void criarPlaneta(Scanner scanner) {
        System.out.println("Digite o id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();

        planetas.add(new Planeta(id, nome));

        System.out.println("Planeta criado com sucesso!");
    }

    private static void criarEspecie(Scanner scanner) {
        System.out.println("Digite o id: ");
        int idEspecie = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o nome da espécie: ");
        String nomeEspecie = scanner.nextLine();

        listarPlanetas();
        System.out.println("\n-> Digite o ID do planeta origem dessa espécie: ");
        int planetaOrigemEspecieId = scanner.nextInt();
        Planeta planetaOrigemDaEspecie = buscador.buscarPlanetaPorId(planetaOrigemEspecieId, planetas);

        System.out.println("Digite o nível de periculosidade base (0 - 10): ");
        int nivelDePericulosidadeBase = scanner.nextInt();

        especies.add(new Especie(idEspecie, nomeEspecie, planetaOrigemDaEspecie, nivelDePericulosidadeBase));
        System.out.println("Espécie criada com sucesso!");
    }

    private static void criarAlienigina(Scanner scanner) {
        System.out.println("Digite o id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();

        listarEspecies();
        System.out.println("\n-> Digite o ID da espécie do Alienígina: ");
        int especieId = scanner.nextInt();
        scanner.nextLine();
        Especie especie = buscador.buscarEspeciePorId(especieId, especies);

        System.out.println("Digite o nível de periculosidade (0 - 10): ");
        int nivelDePericulosidade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a data e hora da entrada (formato: yyyy-MM-dd HH:mm): ");
        String dataHoraString = scanner.nextLine();
        LocalDateTime dataHoraDaEntrada = LocalDateTime.parse(dataHoraString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        alieniginas.add(new Alienigina(id, nome, especie, nivelDePericulosidade, dataHoraDaEntrada));

        System.out.println("Alienígina criado com sucesso!");
    }

    private static void avaliarPericulosidade(Scanner scanner) {
        listarAlieniginas();

        System.out.println("Digite o id do alienígena: ");
        int idAlienigena = scanner.nextInt();
        scanner.nextLine();

        Alienigina alienigina = Buscador.buscarAlieniginasPorId(idAlienigena, alieniginas);
        Monitorador.verificarNecessidadeDeQuarentena(alienigina);
    }

    private static void colocarAlienigenaEmQuarentena(Scanner scanner) {
        listarAlieniginas();

        System.out.println("Digite o id do alienígena: ");
        int idAlienigena = scanner.nextInt();
        scanner.nextLine();

        Alienigina alienigina = Buscador.buscarAlieniginasPorId(idAlienigena, alieniginas);
        Monitorador.aplicarQuarentena(alienigina);
    }

    private static void listarAlienigenasEmQuarentena() {
        System.out.println("Lista de alienígenas em quarentena: ");
        for (Alienigina alienigina : alieniginas) {
            if (alienigina.getEstaDeQuarentena().equals(true)) {
                System.out.println(alienigina);
            }
        }
    }

    private static void verRankingDePericulosidade(ArrayList<Alienigina> alienigenas) {
        ArrayList<Alienigina> copiaAlienigenas = new ArrayList<>(alienigenas);

        for (int i = 0; i < copiaAlienigenas.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < copiaAlienigenas.size(); j++) {
                if (copiaAlienigenas.get(j).getNivelDePericulosidade() > copiaAlienigenas.get(maxIndex).getNivelDePericulosidade()) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                Alienigina temp = copiaAlienigenas.get(maxIndex);
                copiaAlienigenas.set(maxIndex, copiaAlienigenas.get(i));
                copiaAlienigenas.set(i, temp);
            }
        }

        System.out.println("\nRanking por periculosidade:");
        for (Alienigina alienigina : copiaAlienigenas) {
            System.out.println("Alienígena: " + alienigina.getNome() + " - Nível de periculosidade: " + alienigina.getNivelDePericulosidade());
        }
    }

    public static void verAlienigenasPorEspecie() {
        listarEspecies();
        System.out.println("Digite o id da espécie: ");
        int idEspecie = scanner.nextInt();
        scanner.nextLine();

        List<Alienigina> alienigenasDaEspecieEscolhida = alieniginas.stream()
                .filter(alienigina -> alienigina.getEspecie().getId() == idEspecie)
                .collect(Collectors.toList());

        System.out.println("Alienígenas da espécie de ID" + idEspecie + ":");
        alienigenasDaEspecieEscolhida.forEach(System.out::println);
    }

    public static void verAlienigenasQueEntraramNaTerraNosUltimosSeisMeses(ArrayList<Alienigina> alienigenas) {
        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataLimite = dataAtual.minusMonths(6);

        for (Alienigina alienigina : alienigenas) {
            LocalDateTime dataEntrada = alienigina.getDataHoraDaEntrada();
            if (dataEntrada != null && dataEntrada.isAfter(dataLimite)) {
                System.out.println(alienigina);
            }
        }
    }

    private static void listarEspecies() {
        for (Especie especie : especies) {
            System.out.println(especie);
        }
    }

    private static void listarAlieniginas() {
        for (Alienigina alienigina : alieniginas) {
            System.out.println(alienigina);
        }
    }

    private static void listarPlanetas() {
        for (Planeta planeta : planetas) {
            System.out.println(planeta);
        }
    }
}