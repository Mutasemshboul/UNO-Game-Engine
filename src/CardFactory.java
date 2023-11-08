public class CardFactory implements Factory {
    public Card createCard(Card c){
        if(c.getValue().equals(Value.REVERSE)){
            c = new RevesreCard(c.getColor(),c.getValue(),"BasicCard");
        }
        else if(c.getValue().equals(Value.SKIP)){
            c = new SkipCard(c.getColor(),c.getValue(),"BasicCard");
        }
        else if(c.getValue().equals(Value.DRAW_TOW)){
            c = new DrawTwoCard(c.getColor(),c.getValue(),"BasicCard");
        }
        else if(c.getValue().equals(Value.WILD_DRAW_FOUR)){
            c = new WildDrawFourCard(c.getColor(),c.getValue(),"BasicCard");
        }
        else if(c.getValue().equals(Value.WILD)){
            c = new WildCard(c.getColor(),c.getValue(),"BasicCard");
        }
        return c;

    }
}
