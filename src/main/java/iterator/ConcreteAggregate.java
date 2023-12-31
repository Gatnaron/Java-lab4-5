package iterator;

import iterator.infastructure.IAggregate;
import iterator.infastructure.Iterator;
import javafx.scene.image.Image;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteAggregate implements IAggregate {
    private final String fileTopic = new File("src//main//resources//img//").getAbsolutePath() + "\\";
    private List<File> findImages(File dir){
        return Arrays.stream(dir.listFiles()).toList();
    }

    @Override
    public Iterator createIterator() {
        return new ImageIterator();
    }

    private class ImageIterator implements Iterator {
        private int current = 0;
        private final int max = findImages(Paths.get(fileTopic).toFile()).size();
        private Image getImage(int iterator){
            return new Image(Paths.get(fileTopic + iterator + ".jpg").toUri().toString());
        }

        @Override
        public boolean hasNext() {
            return current >= 0 && current + 1 <= max;
        }

        @Override
        public boolean hasPrevious() {
            return !(current - 1 < 1);
        }

        @Override
        public Object next() {
            if (this.hasNext()){
                return getImage(++current);
            }
            current = 1;
            return getImage(current);
        }

        @Override
        public Object preview() {
            if (this.hasPrevious()){
                return getImage(--current);
            }
            current = max;
            return getImage(current);
        }
    }
}
