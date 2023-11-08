import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WildDrawFourCard extends Card{
    public WildDrawFourCard(Color color, Value value,String type) {
        super(color, value,type);
    }

    @Override
    public void doAction(Game g) {
        this.changeColor(g);
        g.getTopCard().setValue(Value.WILD_DRAW_FOUR);
        Player nextPlayer = g.getPlayers().get((g.getCurrentPlayerIndex() + 1) % g.getPlayers().size());
        for(int i = 0 ; i < 4;i++){
            nextPlayer.addCardToHand(g.getDeck().drawCard());
        }
    }

    public int getScore() {
        return 20;
    }
}
