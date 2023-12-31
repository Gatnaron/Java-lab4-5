package items.infastructure;

import items.Meme;
import javafx.scene.image.Image;

public interface IBuilder {
    public void setImage(Image image);
    public void setText();
    public void setDesign();
    public void setColor();
    public Meme build();
}
