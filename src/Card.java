import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class Card {
    private   Color color;
    private  Value value;
    private String type;

    public Card(Color color, Value value, String type) {
        this.color = color;
        this.value = value;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Color getColor(){
        return this.color;
    }

    public Value getValue() {
        return value;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "color=" + color +
                ", value=" + value +
                ", type='" + type + '\'' +
                '}';
    }

    public abstract void doAction(Game g);
    public abstract int getScore();

    public void changeColor(Game g){
        ArrayList<Color> color = new ArrayList<>(Arrays.asList(Color.values()).subList(0,Color.values().length-1));
        System.out.println(color);
        System.out.println("PLease Select a color from 1 - 4 : ");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        g.getTopCard().setColor(color.get(index - 1));
    }
}
