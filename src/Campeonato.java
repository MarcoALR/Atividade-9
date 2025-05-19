import java.util.ArrayList;

public class Campeonato {
    private ArrayList<Time> times = new ArrayList<>();
    private ArrayList<Jogo> jogos = new ArrayList<>();

    public void adicionarTime(String nome) {
        if (times.size() < 10) times.add(new Time(nome));
    }

    public void listarTimes() {
        for (int i = 0; i < times.size(); i++) {
            System.out.println(i + " - " + times.get(i).getNome());
        }
    }

    public void simularJogo(int i, int j) {
        Time t1 = times.get(i), t2 = times.get(j);
        if (jogoJaRealizado(t1, t2)) {
            EntradaSaida.exibirMensagem("Este jogo já foi realizado!");
            return;
        }

        Jogo jogo = new Jogo(t1, t2);
        jogo.simular();
        jogos.add(jogo);
        EntradaSaida.exibirMensagem(jogo.getResultado());
    }

    public boolean jogoJaRealizado(Time t1, Time t2) {
        for (Jogo j : jogos) {
            if (j.envolve(t1, t2)) return true;
        }
        return false;
    }

    public void exibirTabela() {
        System.out.println("Nome       VIT EMP DER GP  GC  PTS");
        for (Time t : times) {
            System.out.println(t);
        }
    }

    public ArrayList<Time> getTimes() {
        return times;
    }
}