package superbar.ui

import groovy.transform.CompileStatic
import superbar.config.MenuConfig
import superbar.config.MenuItemConfig

@CompileStatic
class MenuFactory {

    static Menu create(MenuConfig config)
    {
        Menu menu = new Menu(
                config.name,
                config.orientation,
                config.menuItems.<MenuItem>collect {
                    itemConfig ->
                    MenuItemFactory.create(itemConfig as MenuItemConfig)
                } as List<MenuItem>
        )

        menu.setLocation(config.position.x as int,
                config.position.y as int)

        menu.setSize(100, 100)

        menu.setVisible(true)

        menu
    }
}
