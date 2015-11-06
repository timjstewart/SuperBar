package superbar

import groovy.transform.CompileStatic
import org.junit.Test
import superbar.config.Config
import superbar.config.ConfigReader

import java.awt.Point

@CompileStatic
class ConfigReaderTests {

    private static InputStream strToStrm(String s)
    {
        new ByteArrayInputStream(s.getBytes());
    }

    @Test
    void canLoadBareConfig()
    {
        ConfigReader reader = new ConfigReader()

        String configString = '''{
    "version": 1,
    "menus": []
}'''

        Config config = reader.read(strToStrm(configString))

        assert config.version == 1
        assert config.menus.length == 0
    }

    @Test
    void canLoadConfigWithEmptyMenu()
    {
        ConfigReader reader = new ConfigReader()

        String configString = '''{
    "version": 1,
    "menus": [
        {
            "name": "Main",
            "position": {
                "x": 100,
                "y": 200
            },
            "orientation": "HORIZONTAL",
            "menuItems": []
        }
    ]
}'''

        Config config = reader.read(strToStrm(configString))

        assert config.menus[0].name == "Main"
        assert config.menus[0].position == new Point(100, 200)
        assert config.menus[0].orientation == Orientation.HORIZONTAL
    }

    @Test
    void canLoadConfigWithMenu()
    {
        ConfigReader reader = new ConfigReader()

        String configString = '''{
    "version": 1,
    "menus": [
        {
            "name": "Main",
            "position": {
                "x": 100,
                "y": 200
            },
            "orientation": "HORIZONTAL",
            "menuItems": [
                {
                    "text": "Item1",
                    "description": "Item1Description",
                    "iconFilePath": "/foo.png",
                    "properties": {
                        "propA": "valueA",
                        "propB": "valueB"
                    }
                }
            ]
        }
    ]
}'''

        Config config = reader.read(strToStrm(configString))

        assert config.menus[0].menuItems[0].text == "Item1"
        assert config.menus[0].menuItems[0].description == "Item1Description"
        assert config.menus[0].menuItems[0].iconFilePath == "/foo.png"
    }
}
