import java.util.*;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    public List<Card> getCards() {
        return cards;
    }

    private void initializeDeck() {
        for (Color color : Color.values()) {
            for(Value value:Value.values()){
                if(value != Value.OPTIONAL && color!=Color.BLACK){
                        cards.add(new BasicCard(color,value,"BasicCard"));
                }

            }
        }

        for (Color color : Color.values()) {
            for(Value value:Value.values()){
                if(value != Value.OPTIONAL && color!=Color.BLACK){
                    if(value!=Value.ZERO){
                        cards.add(new BasicCard(color,value,"BasicCard"));
                    }
                }

            }
        }
    }
    public void shuffle() {
        Collections.shuffle(cards);
//        Random rand = new Random();
//        for (int i = 0; i < cards.size(); i++) {
//            int j = rand.nextInt(cards.size());
//            Card temp = cards.get(i);
//            cards.set(i, cards.get(j));
//            cards.set(j, temp);
//        }
    }
    public Card drawCard() {
        return cards.remove(0);

    }
    public int size() {
        return cards.size();
    }
    public void addCard(Card card){
         cards.add(card);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
