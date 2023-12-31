# Javalin

## Ссылки

* [Методы для работы с контекстом](https://javalin.io/documentation#context)
* [Как вернуть страницу с кодом ответа 404](https://javalin.io/documentation#notfoundresponse)

## src/main/java/exercise/App.java

## Задачи

В приложении реализуйте обработчик для динамического маршрута */companies/{id}*. При GET запросе на адрес */companies/{id}* должно отдаваться json представление компании. Компании находятся в константе COMPANIES. Каждая компания представляет собой словарь `Map<String, String>`, у которого есть ключ `id`

```java
// Гипотетический пример
Map<String, String> company = Map.of(
    "id", "3",
    "name", "Google"
    "telephone", "12345678"
)
```

Если компания с таким идентификатором не существует, то должна вернуться страница с HTTP кодом 404 и текстом *Company not found*

### Подсказки

* Изучите методы по работе с контекстом. Найдите тот, который позволяет сериализовать тело ответа в JSON
