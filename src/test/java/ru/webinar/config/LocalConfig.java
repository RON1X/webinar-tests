package ru.webinar.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envMobile}.properties"
})
public interface LocalConfig extends Config {

    @Key("deviceModel")
    @DefaultValue("Pixel 4 API 30")
    String getDeviceModel();

    @Key("systemVersion")
    @DefaultValue("11")
    String getSystemVersion();

    @Key("appVersion")
    @DefaultValue("app-gms-release.apk")
    String getAppVersion();

    @Key("appPackage")
    @DefaultValue("ru.webinar.mobile")
    String getAppPackage();

    @Key("appActivity")
    @DefaultValue("ru.webinar.core.presentation.MainActivity")
    String getAppActivity();
}