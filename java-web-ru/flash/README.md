# Флеш-сообщения

В этом упражнении мы реализуем вывод флеш-сообщений в макете сайта. Сообщения будут сигнализировать об успешном создании поста

## Ссылки

* [Методы для работы с контекстом](https://javalin.io/documentation#context)
* [Оформление флеш-сообщений](https://getbootstrap.com/docs/4.0/components/alerts/)

## src/main/java/exercise/controller/PostsController.java

## Задание

Реализуйте в контроллере метод `create()`, который будет создавать новый пост. Добавьте валидацию на название курса, оно должно быть не короче двух символов. При успешном создании курса в сессию записывается сообщение об успешном создании поста *Пост был успешно создан!* и выполняется редирект на страницу постов

Реализуйте в контроллере метод `index()`, который отвечает за вывод списка постов. Реализуйте вывод флеш сообщения

## src/main/java/exercise/dto/BasePage.java

## Задачи

Создайте базовый класс для наших страниц и реализуйте в нем передачу данных для флеш сообщений

## src/main/java/exercise/dto/posts/PostsPage.java

## Задачи

Создайте dto-класс для вывода всех постов, унаследуйте его от `BasePage`

## src/main/java/jte/layout/page.jte

## Задачи

Создайте макет сайта и реализуйте вывод флеш-сообщений в макете сайта

## src/main/java/jte/layout/posts/index.jte

## Задачи

Создайте шаблон для вывода списка всех постов и реализуйте передачу в макет необходимых данных

Флеш сообщения могут сообщать нам о разных событиях. Если хотите немного усложнить задачу, можно сделать сообщения более информативными – подсветить их разными цветами в зависимости от типа события. Например, сообщение об успешном создании поста подсветить зеленым. Используйте для этого [классы Bootstrap для аллертов](https://getbootstrap.com/docs/5.0/components/alerts/). Подумайте, какой дополнительный параметр нужно установить в сессию, чтобы задать тип сообщения
