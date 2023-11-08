public class MutasemGame extends Game{

    public MutasemGame() {
        this.setOtherFactory(new MutasemCardFactory());
        this.setScoreBehavior(new MutasemScore());

        this.addCard(new WinCard(Color.BLACK,Value.OPTIONAL,"WinCard"));
        this.addCard(new StealScorer(Color.BLACK,Value.OPTIONAL,"StealScore"));

        getDeck().shuffle();
        this.dealInitialCards();
        setTopCard( getDeck().drawCard());
    }
}
