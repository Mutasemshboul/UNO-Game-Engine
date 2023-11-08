public class DrawTwoCard extends Card{
    public DrawTwoCard(Color color, Value value,String type) {
        super(color, value,type);
    }

    @Override
    public void doAction(Game g) {
        Player nextPlayer = g.getPlayers().get((g.getCurrentPlayerIndex() + 1) % g.getPlayers().size());
        nextPlayer.addCardToHand(g.getDeck().drawCard());
        nextPlayer.addCardToHand(g.getDeck().drawCard());

    }

    public int getScore() {
        return 5;
    }
}
