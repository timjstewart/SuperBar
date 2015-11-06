package superbar.config

import groovy.json.JsonOutput
import groovy.transform.CompileStatic

import java.nio.charset.StandardCharsets

@CompileStatic
class ConfigWriter
{
    void write(Config config, OutputStream outStream)
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
        []
    }

}