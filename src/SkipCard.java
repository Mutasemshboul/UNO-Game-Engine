public class SkipCard extends Card{
    public SkipCard(Color color, Value value,String type) {
        super(color, value,type);
    }

    @Override
    public void doAction(Game g) {
        g.setCurrentPlayerIndex((g.getCurrentPlayerIndex()+1)%g.getPlayers().size());
    }

    public int getScore() {
        return 7;
    }
}
