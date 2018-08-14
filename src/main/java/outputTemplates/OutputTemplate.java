package outputTemplates;

import java.io.IOException;

public interface OutputTemplate {

    public void write();
    public void save(String fileName) throws IOException;
}
