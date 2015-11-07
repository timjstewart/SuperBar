package superbar.ui

import groovy.transform.CompileStatic
import superbar.config.MenuConfig
import superbar.config.MenuItemConfig

import javax.swing.*

@CompileStatic
class MenuItemFactory {

    static MenuItem create(MenuConfig owningMenuConfig, MenuItemConfig config) {
        new MenuItem(
                config.text,
                loadIcon(config.iconFilePath),
                config.description,
                owningMenuConfig.menuItemSize,
                config.properties
        )
    }

    private static Icon loadIcon(String iconFilePath) {
        return new ImageIcon(iconFilePath)
    }
}
