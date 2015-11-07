package superbar.ui

import groovy.transform.CompileStatic
import superbar.config.MenuConfig
import superbar.config.MenuItemConfig

import javax.swing.Icon
import javax.swing.ImageIcon

@CompileStatic
class MenuItemFactory {

    static MenuItem create(MenuItemConfig config)
    {
        new MenuItem(
            config.text,
            loadIcon(config.iconFilePath),
            config.description,
            config.properties
        )
    }

    private static Icon loadIcon(String iconFilePath)
    {
        return new ImageIcon(iconFilePath)
    }
}
