package superbar.ui

import groovy.transform.CompileStatic

import javax.swing.Icon
import javax.swing.JButton

@CompileStatic
class MenuItem extends JButton
{
    String description

    Map<String, Object> properties

    MenuItem(String text, Icon icon, String description, Map<String, Object> properties)
    {
        super(text, icon)

        this.description = description

        this.properties = properties
    }
}