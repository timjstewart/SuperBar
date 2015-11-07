package superbar.config

import groovy.json.JsonSlurper
import superbar.Orientation

import java.awt.Dimension
import java.awt.Point

class ConfigReader
{
  static Config read(InputStream inStream)
  {
      Object json = new JsonSlurper().parse(inStream)

      Config result = new Config();

      result.with {
          version = json.version
          menus = readMenus(json.menus)

      }

      result
  }

    private static MenuConfig[] readMenus(Object menus)
    {
        List<MenuConfig> result = new ArrayList<>(menus.size as int)

        for (Object menu : menus)
        {
            MenuConfig menuConfig = readMenu(menu)

            result.add(menuConfig)
        }

        result.toArray(new MenuConfig[0])
    }

    private static MenuConfig readMenu(Object json)
    {
        MenuConfig result = new MenuConfig()

        result.with {
            name = json.name
            position = new Point(
                    json.position.x as Integer,
                    json.position.y as Integer
                )
            orientation = Orientation.valueOf(json.orientation as String)
            menuItems = readMenuItems(json.menuItems)
            menuItemSize = json.menuItemSize
        }

        result
    }

    private static MenuItemConfig[] readMenuItems(Object json)
    {
        List<MenuItemConfig> results = new ArrayList<>(json.size() as int)

        for (Object o : json)
        {
            results.add(readMenuItem(o))
        }

        results.toArray(new MenuItemConfig[0])
    }

    private static MenuItemConfig readMenuItem(Object json)
    {
        MenuItemConfig result = new MenuItemConfig()

        result.with {
            result.text = json.text
            result.description = json.description
            result.iconFilePath = json.iconFilePath
            result.properties = json.properties as Map<String,String>
        }

        result
    }
}