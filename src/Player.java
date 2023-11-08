import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private int score;



    private boolean isSayUno;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public void setSayUno(boolean sayUno) {
        isSayUno = sayUno;
    }

    public boolean isSayUno() {
        return isSayUno;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }
    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public Card playCard(int index) {
        return hand.remove(index);
    }
    public boolean hasCards() {
        return !hand.isEmpty();
    }
}
