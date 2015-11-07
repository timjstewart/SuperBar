package superbar

import superbar.config.ConfigReader
import groovy.transform.CompileStatic
import superbar.config.Config
import superbar.config.MenuConfig
import superbar.config.MenuItemConfig
import superbar.ui.Menu
import superbar.ui.MenuFactory

@CompileStatic
class Application
{
  Config config
  List<Menu> menus = new ArrayList<>();

  Application()
  {
    config = (Config) new File('config.json').withInputStream {
      stream ->
        ConfigReader.read(stream)
    }

    for (MenuConfig mc : config.menus)
    {
      menus.add(MenuFactory.create(mc))
    }
  }

  static void main(String[] args)
  {
    new Application()


  }
}