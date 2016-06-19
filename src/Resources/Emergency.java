package Resources;

public class Emergency {
    private Ranking ranking;

    public Emergency(Ranking ranking) {
        this.ranking = ranking;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return  ranking.toString();
    }
}