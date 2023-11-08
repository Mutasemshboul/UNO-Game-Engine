public class MutasemCardFactory implements Factory{
    @Override
    public Card createCard(Card c) {
        if(c.getValue()==Value.OPTIONAL && c.getType().equals("WinCard")){
            c = new WinCard(c.getColor(),c.getValue(),"WinCard");
        }
        else if(c.getValue()==Value.OPTIONAL && c.getType().equals("StealScore")){
            c = new StealScorer(c.getColor(),c.getValue(),"StealScore");
        }

        return c;
    }
}
