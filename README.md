<h1>Проект автоматизации тестирования <a target="_blank" href="https://mts-link.ru/#form"> МТС Линк </a> </h1>

<p align="center">
<img src="images/logo/mts-link-logo.png">
</p>

## Описание
МТС Линк (Ранее Webinar) - Российский разработчик платформы для бизнес-коммуникаций и совместной работы. МТС Линк предлагает решения для проведения онлайн-встреч и совещаний, вебинаров, организации смешанного обучения, а также проведения крупных виртуальных и гибридных мероприятий.

**Особенности проекта**:
- `Page Object` шаблон проектирования
- Использование техноголии `Owner` для придания тестам гибкости и легкости конфигурации
- Возможность запуска тестов: локально, удалённо, по тегам
- Использование `Faker` для генерации данных
- Использование `Lombok` для моделей в API тестах
- По итогу прохождения автотестов генерируется `Allure отчет`. Содержание отчета:
    - Шаги теста
    - Скриншот страницы на последнем шаге
    - Исходный код страницы в браузере
    - Логи консоли браузера
    - Видео выполнения автотеста
- Возможность запуска тестов напрямую из `Allure TestOps`
- [ Ожидается ] Интеграция с `Jira`
- [ Ожидается ] Уведомление о результатах прохождения в `Telegram`


## Технологии и инструменты
<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/logo/Idea.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/logo/GitHub.svg" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/logo/Java.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/logo/Gradle.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/logo/Junit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="images/logo/Selenide.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="images/logo/Selenoid.svg" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="RestAssured" height="50" src="images/logo/RestAssured.svg" width="50"/></a>
<a href="https://www.browserstack.com/"><img alt="Browserstack" height="50" src="images/logo/Browserstack.svg" width="50"/></a>
<a href="https://appium.io/"><img alt="Appium" height="50" src="images/logo/Appium.svg" width="50"/></a>
<a href="https://developer.android.com/studio"><img alt="Android Studio" height="50" src="images/logo/Android_Studio.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/logo/Jenkins.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/logo/Allure.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="images/logo/Allure_TO.svg" width="50"/></a>
<a href="https://www.atlassian.com/software/jira"><img alt="Jira" height="50" src="images/logo/Jira.svg" width="50"/></a>  
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/logo/Telegram.svg" width="50"/></a>
</div>

## Реализованные проверки
### Web
- [x] Авторизация по почте и паролю
- [x] Запуск быстрой встречи
- [x] Изменение информации в профиле
- [x] Выход из аккаунта

### Api
- [x] Авторизация по почте и паролю
- [x] Создание шаблона для мероприятия
- [x] Создание быстрой встречи
- [x] Удаление мероприятия

### Mobile
- [x] Авторизация по почте и паролю
- [x] Выход из аккаунта

# Запуск тестов
Все настройки лежат в папке `resources` в файлах `.properties`. <br/>
При необходимости можно изменить конфигурацию в этих файлах.

### Допустимые комбинации

```mermaid 
flowchart LR
    A(gradle) --> B(clean)
    B --> C{Выбрать тег}
    C --> D[test]
    C --> E[web]
    C --> F[api]
    C --> G[android]
    E --> H[-DenvWeb=local]
    E --> I[-DenvWeb=remote]
    G --> J[-DenvMobile=browserstack]
    G --> K[-DenvMobile=emulator]
```

## Cборка тестов в <b><a target="_blank" href="https://jenkins.autotests.cloud/job/022-eachubkov-hw27/">Jenkins</a></b>

>Для запуска сборки необходимо перейти в раздел `Build with Parameters` и нажать кнопку `Build`

<img src="images/screenshots/jenkins.png">

## Интеграция с <b><a target="_blank" href="https://jenkins.autotests.cloud/job/022-eachubkov-hw27/8/allure/">Allure Report</a></b>

<img src="images/screenshots/allure_report.png">

## Интеграция с <b><a target="_blank" href="https://allure.autotests.cloud/project/3960/dashboards">Allure TestOps</a></b>

<img src="images/screenshots/allure_testops.png">

## Пример выполнения теста в Selenoid

> К каждому UI-тесту в отчете прилагается видео
<p align="center">
  <img src="images/video/web-test.gif">
</p>

## Пример выполнения теста в Browserstack

> К каждому мобильному тесту, выполняемому в Browserstack, в отчете прилагается видео
<p align="center">
  <img src="images/video/mobile-test.gif">
</p>
