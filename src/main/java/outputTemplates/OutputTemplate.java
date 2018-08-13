package outputTemplates;

import models.character.entities.Character;
import java.io.IOException;

public interface OutputTemplate {

    public void write(Character character);
    public void save() throws IOException;
}
