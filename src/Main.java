public class Main {
    public static void main(String[] args) {
        Campeonato camp = new Campeonato();
        int opcao;
        do {
            String menu = "1 - Cadastrar Times\n2 - Simular Jogos\n3 - Sair";
            opcao = EntradaSaida.lerInteiro(menu);

            switch (opcao) {
                case 1:
                    while (camp.getTimes().size() < 10) {
                        String nome = EntradaSaida.lerString("Nome do time:");
                        if (nome == null || nome.trim().isEmpty()) break;
                        camp.adicionarTime(nome);
                    }
                    break;

                case 2:
                    if (camp.getTimes().size() < 2) {
                        EntradaSaida.exibirMensagem("Cadastre pelo menos dois times.");
                        break;
                    }
                    camp.listarTimes();
                    int i = EntradaSaida.lerInteiro("Índice do primeiro time:");
                    int j = EntradaSaida.lerInteiro("Índice do segundo time:");
                    if (i != j) {
                        camp.simularJogo(i, j);
                        camp.exibirTabela();
                    } else {
                        EntradaSaida.exibirMensagem("Escolha times diferentes.");
                    }
                    break;
            }
        } while (opcao != 3);

        EntradaSaida.exibirMensagem("Programa encerrado.");
    }
}