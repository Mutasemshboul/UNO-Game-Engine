import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StealScorer extends Card{
    public StealScorer(Color color, Value value, String type) {
        super(color, value, type);
    }

    @Override
    public void doAction(Game g) {
        List<Player> P = g.getPlayers();
        for(Player p: P){
            if(!p.equals(g.getPlayers().get(g.getCurrentPlayerIndex())))
                g.getPlayers().get(g.getCurrentPlayerIndex()).setScore(p.getScore());
        }
        this.changeColor(g);
        g.getTopCard().setValue(Value.OPTIONAL);
    }

    @Override
    public int getScore() {
        return 0;
    }
}
