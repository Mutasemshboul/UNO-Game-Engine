public class BasicScore implements ScoreBehavior{
    @Override
    public void calculateBehavior(Game g) {
        g.getPlayers().get(g.getCurrentPlayerIndex()).setScore(g.getTopCard().getScore());
    }
}
