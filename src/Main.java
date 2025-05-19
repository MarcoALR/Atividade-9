public class Main {
    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato();

        while (true) {
            int opcao = EntradaSaida.lerInteiro("61 - Cadastrar Times\n2 - Simular Jogos\n3 - Sair");
            switch (opcao) {
                case 1:
                    campeonato.cadastrarTimes();
                    break;
                case 2:
                    if (campeonato.todosJogosRealizados()) {
                        EntradaSaida.exibirMensagem("Todos os jogos foram realizados!");
                        campeonato.exibirCampeoes();
                    } else {
                        campeonato.simularJogo();
                        campeonato.exibirTabela();
                    }
                    break;
                case 3:
                    EntradaSaida.exibirMensagem("Programa encerrado.");
                    return;
                default:
                    EntradaSaida.exibirMensagem("Opção inválida.");
            }
        }
    }
}
