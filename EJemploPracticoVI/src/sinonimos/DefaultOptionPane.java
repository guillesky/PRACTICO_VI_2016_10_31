package sinonimos;

import java.awt.Component;

import javax.swing.JOptionPane;


public class DefaultOptionPane implements OptionPane
{
    public DefaultOptionPane()
    {
        super();
    }

    public void showMessageDialog(Component parentComponent, Object message)
    {
        JOptionPane.showMessageDialog(parentComponent, message);
    }

    @Override
    public int userConfirmation(Component component, Object message, String title, int optionType)
    {
        return userConfirmation(component, message, title, optionType);
    }
}
