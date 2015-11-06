package superbar.config

import groovy.json.JsonOutput
import groovy.transform.CompileStatic

import java.awt.Menu
import java.nio.charset.StandardCharsets

@CompileStatic
class ConfigWriter
{
    static void write(Config config, OutputStream outStream)
    {
        outStream.write(JsonOutput.toJson(configToJson(config))
                .getBytes(StandardCharsets.UTF_8.name()))
    }

    private static Object configToJson(Config config)
    {
        [
                version: config.version,
                menus: menusToJson(config.menus)
        ]
    }

    private static Object menusToJson(MenuConfig[] menus)
    {
        List<Map<String, Object>> results = new ArrayList<>(menus.length)

        for (MenuConfig mc : menus)
        {
            results.add(menuToJson(mc))
        }

        results.toArray()
    }

    private static Map<String, Object> menuToJson(MenuConfig menu)
    {
        Map<String, Object> result = new HashMap<>();

        result['name'] = menu.name
        result['menuItems'] = menuItemsToJson(menu.menuItems)
        result['orientation'] = menu.orientation
        result['position'] = new HashMap<String, Object>()
        result['position']['x'] = menu.position.x as int
        result['position']['y'] = menu.position.y as int

        result
    }

    private static List<Map<String, Object>> menuItemsToJson(MenuItemConfig[] menuItems)
    {
        List<Map<String, Object>> result = new ArrayList<>(menuItems.size())

        for (MenuItemConfig mi : menuItems)
        {
            result.add(menuItemToJson(mi))
        }

        result
    }

    private static Map<String, Object> menuItemToJson(MenuItemConfig mi)
    {
        Map<String, Object> result = new HashMap<>()

        result['text'] = mi.text
        result['description'] = mi.description
        result['iconFilePath'] = mi.iconFilePath
        result['properties'] = new HashMap<String, Object>()

        result
    }

}