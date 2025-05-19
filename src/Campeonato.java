import java.util.ArrayList;

public class Campeonato {
    private ArrayList<Time> times = new ArrayList<>();
    private ArrayList<Jogo> jogos = new ArrayList<>();

    public void cadastrarTimes() {
        while (times.size() < 10) {
            String nome = EntradaSaida.lerString("Digite o nome do time:");
            if (nome == null || nome.trim().isEmpty()) break;
            times.add(new Time(nome.trim()));
        }
    }

    public void simularJogo() {
        if (times.size() < 2) {
            EntradaSaida.exibirMensagem("Cadastre pelo menos 2 times primeiro.");
            return;
        }

        listarTimes();
        int i = EntradaSaida.lerInteiro("Índice do primeiro time:");
        int j = EntradaSaida.lerInteiro("Índice do segundo time:");

        if (i == j || i < 0 || j < 0 || i >= times.size() || j >= times.size()) {
            EntradaSaida.exibirMensagem("Selecione dois times diferentes válidos.");
            return;
        }

        Time t1 = times.get(i);
        Time t2 = times.get(j);

        if (jogoJaRealizado(t1, t2)) {
            EntradaSaida.exibirMensagem("Este jogo já foi realizado! Escolha outra dupla de times.");
            return;
        }

        Jogo jogo = new Jogo(t1, t2);
        jogo.simular();
        jogos.add(jogo);
        EntradaSaida.exibirMensagem(jogo.getResultado());
    }

    public void listarTimes() {
        System.out.println("\nTimes Cadastrados:");
        for (int i = 0; i < times.size(); i++) {
            System.out.println(i + " - " + times.get(i).getNome());
        }
    }

    public boolean jogoJaRealizado(Time t1, Time t2) {
        for (Jogo jogo : jogos) {
            if (jogo.envolve(t1, t2)) return true;
        }
        return false;
    }

    public void exibirTabela() {
        System.out.println("\nTABELA DO CAMPEONATO:");
        System.out.println("Nome      VIT    EMP    DER   GP    GC   PTS");
        for (Time t : times) {
            System.out.println(t);
        }
        System.out.println();
    }

    public boolean todosJogosRealizados() {
        int totalTimes = times.size();
        int maxJogos = totalTimes * (totalTimes - 1) / 2;
        return jogos.size() >= maxJogos;
    }

    public void exibirCampeoes() {
        int maiorPontuacao = -1;
        ArrayList<Time> campeoes = new ArrayList<>();

        for (Time t : times) {
            int pts = t.getPontos();
            if (pts > maiorPontuacao) {
                campeoes.clear();
                campeoes.add(t);
                maiorPontuacao = pts;
            } else if (pts == maiorPontuacao) {
                campeoes.add(t);
            }
        }

        StringBuilder sb = new StringBuilder("Campeão):\n");
        for (Time t : campeoes) {
            sb.append(t.getNome()).append(" com ").append(t.getPontos()).append(" pontos\n");
        }
        EntradaSaida.exibirMensagem(sb.toString());
    }
}
