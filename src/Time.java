public class Time {
    private String nome;
    private int vitorias, empates, derrotas, golsPro, golsContra;

    public Time(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return vitorias * 3 + empates;
    }

    public void registrarJogo(int golsFeitos, int golsSofridos) {
        golsPro += golsFeitos;
        golsContra += golsSofridos;

        if (golsFeitos > golsSofridos) vitorias++;
        else if (golsFeitos == golsSofridos) empates++;
        else derrotas++;
    }

    public String toString() {
        return String.format("%-10s %3d %3d %3d %3d %3d %3d",
                nome, vitorias, empates, derrotas, golsPro, golsContra, getPontos());
    }
}