public class WinCard extends Card{
    public WinCard(Color color, Value value, String type) {
        super(color, value, type);
    }

    @Override
    public void doAction(Game g) {
        this.changeColor(g);
        g.getPlayers().get(g.getCurrentPlayerIndex()).getHand().clear();
    }

    @Override
    public int getScore() {
        return 200;
    }
}
