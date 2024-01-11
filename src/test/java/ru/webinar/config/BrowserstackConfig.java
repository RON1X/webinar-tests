package ru.webinar.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envMobile}.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("accessKey")
    @DefaultValue("VaykixsYYLxpisjraPmx")
    String getAccessKey();

    @Key("userName")
    @DefaultValue("user_ylT3qU")
    String getUserName();

    @Key("url")
    @DefaultValue("https://hub-cloud.browserstack.com/wd/hub")
    String getUrl();

    @Key("device")
    @DefaultValue("Google Pixel 5")
    String getDevice();

    @Key("osVersion")
    @DefaultValue("12.0")
    String getOSVersion();

    @Key("app")
    @DefaultValue("bs://fa5545cf017ded1ba87bc57334d89acd0df0ad3d")
    String getApp();
}