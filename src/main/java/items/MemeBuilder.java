package items;

import items.infastructure.IBuilder;
import iterator.ConcreteAggregate;
import iterator.infastructure.Iterator;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemeBuilder implements IBuilder {
    private final Meme meme = new Meme();
    private final Text text = new Text();
    private final List<String> jokes = List.of(
            "Студенты...\nЭто не люди, это зомби...\n",
            "Когда разбил вазу\nа наказали младшего ребёнка)\n",
            "Ох... Этот запах...\n Запаз зачета!\n",
            "За вас \nи за моих друзей", "Купите цветы маме \nОна будет очень рада\n",
            "А почему на новогоднем столе\nхлеб прошлогодний?",
            "Лучше надушиться духами \nчем пахнуть общагой",
            "Если меня спросят\n «кто навредил мне больше всего?» \nответ будет - я сам..."

    );
    private final List<Color> colors = List.of(Color.BLUE,Color.LIME,Color.ORANGE,Color.RED);
    @Override
    public void setImage(Image image) {
        this.meme.addImage(image);
    }

    @Override
    public void setText() {
        text.setText(jokes.get(new Random().nextInt(0, jokes.size())));
        this.meme.addText(text);
    }

    @Override
    public void setColor(){
        text.setFill(colors.get(new Random().nextInt(0,colors.size())));
    }

    @Override
    public void setDesign(){
        text.fontProperty().setValue(Font.font("Calibri", 18));
    }

    @Override
    public Meme build() {
        return this.meme;
    }
}
