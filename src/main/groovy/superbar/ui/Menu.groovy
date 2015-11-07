package superbar.ui

import groovy.transform.CompileStatic
import superbar.Orientation

import javax.swing.*
import java.awt.*
import java.util.List

@CompileStatic
class Menu extends JFrame {

    Orientation orientation

    List<MenuItem> menuItems = new ArrayList<>()
    
    Menu(String name, Orientation orientation, int menuItemSize, List<MenuItem> menuItems) {
        super(name)

        setDefaultCloseOperation(DISPOSE_ON_CLOSE)

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0), true)

        getContentPane().add(panel)

        int panelWidth
        int panelHeight

        switch (orientation) {
            case Orientation.HORIZONTAL:
                panelWidth = menuItemSize * menuItems.size()
                panelHeight = menuItemSize
                break

            case Orientation.VERTICAL:
                panelWidth = menuItemSize
                panelHeight = menuItemSize * menuItems.size()
                break
        }

        panel.setPreferredSize(new Dimension(panelWidth, panelHeight))

        setUndecorated(true)

        pack()

        for (MenuItem item : menuItems) {
            panel.add(item)
        }
    }
}