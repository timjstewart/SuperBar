package superbar

import org.junit.Test
import superbar.config.Config
import superbar.config.ConfigWriter

import java.nio.charset.StandardCharsets

class ConfigWriterTests
{
    private static strmToStr(ByteArrayOutputStream strm)
    {
        strm.toString(StandardCharsets.UTF_8.name())
    }

    @Test
    void canWriteEmptyMenu()
    {
        Config config = new Config(
                version: 1,
                menus: []
        )

        ByteArrayOutputStream outStrm = new ByteArrayOutputStream()

        new ConfigWriter().write(config, outStrm)

        assert strmToStr(outStrm) == '''{"version":1,"menus":[]}'''
    }
}
