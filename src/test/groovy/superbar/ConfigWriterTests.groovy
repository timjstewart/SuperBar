package superbar

import org.junit.Test
import superbar.config.Config
import superbar.config.ConfigWriter
import superbar.config.MenuConfig
import superbar.config.MenuItemConfig

import java.awt.*
import java.nio.charset.StandardCharsets

class ConfigWriterTests {

    private static strmToStr(ByteArrayOutputStream strm) {
        strm.toString(StandardCharsets.UTF_8.name())
    }

    @Test
    void canWriteEmptyConfig() {
        Config config = new Config(
                version: 1,
                menus: []
        )

        ByteArrayOutputStream outStrm = new ByteArrayOutputStream()

        ConfigWriter.write(config, outStrm)

        assert strmToStr(outStrm) == '''{"version":1,"menus":[]}'''
    }

    @Test
    void canWriteEmptyMenu() {
        Config config = new Config(
                version: 1,
                menus: [
                        new MenuConfig(
                                name: "Menu1",
                                menuItems: [],
                                position: new Point(100, 200),
                                orientation: "VERTICAL"
                        )
                ]
        )

        ByteArrayOutputStream outStrm = new ByteArrayOutputStream()

        ConfigWriter.write(config, outStrm)

        assert strmToStr(outStrm) == '''{"version":1,"menus":[{"orientation":"VERTICAL","name":"Menu1","menuItems":[],''' +
                '''"position":{"x":100,"y":200}}]}'''
    }

    @Test
    void canWriteMenu() {
        Config config = new Config(
                version: 1,
                menus: [
                        new MenuConfig(
                                name: "Menu1",
                                orientation: "VERTICAL",
                                position: new Point(100, 200),
                                menuItems: [
                                        new MenuItemConfig(
                                                text: "Item1",
                                                description: "Item1Description",
                                                iconFilePath: "/bar.jpg")
                                ]
                        )
                ]
        )

        ByteArrayOutputStream outStrm = new ByteArrayOutputStream()

        ConfigWriter.write(config, outStrm)

        assert strmToStr(outStrm) == '''{"version":1,"menus":[{"orientation":"VERTICAL","name":"Menu1","menuItems":[''' +
                '''{"iconFilePath":"/bar.jpg","description":"Item1Description","text":"Item1","properties":{}}''' +
                '''],"position":{"x":100,"y":200}}]}'''
    }
}
