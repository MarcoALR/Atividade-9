public class Main {
    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato();

        while (true) {
            int opcao = IOUtils.lerInteiro("Menu:\n1 - Cadastrar Times\n2 - Simular Jogos\n3 - Sair");
            switch (opcao) {
                case 1:
                    campeonato.cadastrarTimes();
                    break;
                case 2:
                    if (campeonato.todosJogosRealizados()) {
                        IOUtils.exibirMensagem("Todos os jogos foram realizados!");
                        campeonato.exibirCampeoes();
                    } else {
                        campeonato.simularJogo();
                        campeonato.exibirTabela();
                    }
                    break;
                case 3:
                    IOUtils.exibirMensagem("Programa encerrado.");
                    return;
                default:
                    IOUtils.exibirMensagem("Opção inválida.");
            }
        }
    }
}
