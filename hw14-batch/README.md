# Сервис реализации каталога книг в библиотеке
Разработанный сервис моделирует процесс обработки каталога книг в библиотеке.
Книгу можно добавить, указав автора, удалить по идентификатору, найти по идентификатору, обновить, а также
выбрать все книги и отобразить всех авторов.

## Общая информация и структура проекта

Внешние проектные ресурсы:

- пакет библиотек фреймворка Spring-boot и spring security;
- библиотека для тестирования junit: 
  - junit представляет собой фреймворк для автоматического юнит-тестирования программ;
- lombok - библиотека для сокращения кода в классах и расширения функциональности языка Java;

Сервис построен на Java SE 17 с использованием Spring-Boot.

Структурно, проект разделен на следующие пакеты:
- config - пакет, содержащий конфигурацию;
- domain - пакет, содержащий модели данных;
- service - пакет, содержащий сервисные методы;
- shell - пакет, содержащий команды запуска.

sql файлы с исходными тестовыми данными расположены в каталоге resources/schema.sql, data.sql и содержит 3 таблицы с данными
авторов, книг, жанров.

## Сборка сервиса
### Используемое ПО
Для развертывания и сборки компонент сервиса на компьютере должны быть предустановлены:
1. Java SDK ver. 17+
2. maven ver. 3.8+

Перед сборкой убедитесь что переменная окружения JAVA_HOME указывает на корневой каталог Java SDK 17-й версии.
