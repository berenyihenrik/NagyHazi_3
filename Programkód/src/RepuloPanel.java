import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RepuloPanel extends JarmuPanel {
    
    class EllenorzesButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            MeglevoFoglalasDialog mfd = new RepuloMeglevoFoglalasDialog(getJegyek());
        }
    }
    
    public RepuloPanel(MainFrame parent) {
        super(parent);
    }

    protected void initJaratok() {
        this.jaratok = new RepuloJaratok();
        this.jaratok.load();
    }

    public Jegyek getJegyek() {
        return parent.getJegyek();
    }
}
