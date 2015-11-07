package superbar.ui

import groovy.transform.CompileStatic
import superbar.Orientation

import javax.swing.JFrame
import java.awt.FlowLayout

@CompileStatic
class Menu extends JFrame
{
    Orientation orientation

    List<MenuItem> menuItems = new ArrayList<>()

    Menu(String name, Orientation orientation, List<MenuItem> menuItems)
    {
        super(name)

        setLayout(new FlowLayout())

        for (MenuItem item : menuItems)
        {
            add(item)
        }
    }
}