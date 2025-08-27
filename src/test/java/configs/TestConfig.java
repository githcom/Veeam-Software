package configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:propertiesFiles/preprod.properties"
})
public interface TestConfig extends Config {

    @Key("hostUrl")
    String hostUrl();
}