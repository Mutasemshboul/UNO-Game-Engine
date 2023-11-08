import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WildCard extends Card{
    public WildCard(Color color, Value value,String type) {
        super(color, value,type);
    }

    @Override
    public void doAction(Game g) {
        this.changeColor(g);
        g.getTopCard().setValue(Value.WILD);
    }

    @Override
    public int getScore() {
        return 7;
    }
}
