package superbar.ui

import groovy.transform.CompileStatic

import javax.swing.Icon
import javax.swing.JButton
import java.awt.Dimension

@CompileStatic
class MenuItem extends JButton
{
    Map<String, Object> properties

    MenuItem(String text, Icon icon, String description, int size, Map<String, Object> properties)
    {
        super(icon)

        this.properties = properties

        setPreferredSize(new Dimension(size, size))

        setToolTipText(description)
    }
}