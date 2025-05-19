import java.util.Random;

public class Jogo {
    private Time time1;
    private Time time2;
    private int gols1;
    private int gols2;

    public Jogo(Time t1, Time t2) {
        this.time1 = t1;
        this.time2 = t2;
    }

    public void simular() {
        Random rand = new Random();
        gols1 = rand.nextInt(6); // Gols entre 0 e 5
        gols2 = rand.nextInt(6);
        time1.registrarJogo(gols1, gols2);
        time2.registrarJogo(gols2, gols1);
    }

    public boolean envolve(Time t1, Time t2) {
        return (t1 == time1 && t2 == time2) || (t1 == time2 && t2 == time1);
    }

    public String getResultado() {
        return time1.getNome() + " " + gols1 + " x " + gols2 + " " + time2.getNome();
    }
}
