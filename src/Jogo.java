import java.util.Random;

public class Jogo {
    private Time time1, time2;
    private int golsTime1 = -1, golsTime2 = -1;

    public Jogo(Time time1, Time time2) {
        this.time1 = time1;
        this.time2 = time2;
    }

    public void simular() {
        Random rand = new Random();
        golsTime1 = rand.nextInt(6); // 0 a 5
        golsTime2 = rand.nextInt(6);
        time1.registrarJogo(golsTime1, golsTime2);
        time2.registrarJogo(golsTime2, golsTime1);
    }

    public String getResultado() {
        return time1.getNome() + " " + golsTime1 + " x " + golsTime2 + " " + time2.getNome();
    }

    public boolean envolve(Time t1, Time t2) {
        return (t1 == time1 && t2 == time2) || (t1 == time2 && t2 == time1);
    }
}