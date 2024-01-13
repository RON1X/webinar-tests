package ru.webinar.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envWeb}.properties"
})
public interface WebConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://my.mts-link.ru")
    String getBaseUrl();

    @Key("baseUri")
    @DefaultValue("https://my.mts-link.ru")
    String getBaseUri();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("remote")
    String getRemote();
}