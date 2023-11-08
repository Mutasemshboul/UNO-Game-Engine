public class RevesreCard extends Card{

    public RevesreCard(Color color, Value value,String type) {
        super(color, value,type);
    }

    @Override
    public void doAction(Game g) {
        g.setReverse(!g.isReverse());
    }

    public int getScore() {
        return 10;
    }
}
