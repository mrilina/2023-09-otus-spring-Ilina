# Сервис реализации каталога книг в библиотеке
Разработанный сервис моделирует процесс обработки каталога книг в библиотеке.
Книгу можно добавить, указав автора, удалить по идентификатору, найти по идентификатору, обновить, а также
выбрать все книги и отобразить всех авторов.

## Общая информация и структура проекта

Внешние проектные ресурсы:

- пакет библиотек фреймворка Spring-boot и Spring shell;
- библиотека для тестирования junit: 
  - junit представляет собой фреймворк для автоматического юнит-тестирования программ;
- lombok - библиотека для сокращения кода в классах и расширения функциональности языка Java;

Сервис построен на Java SE 17 с использованием Spring-Boot.

Структурно, проект разделен на следующие пакеты:
- commands - пакет, содержащий команды для работы с приложением;
- converters - пакет, содержащий конвертеры;
- exceptions - пакет, содержащий описание исключительных ситуаций;
- models - пакет, содержащий модели данных;
- repositories - пакет, содержащий репозитории;
- services - пакет, содержащий сервисные методы;
- тестирование - пакет содержит набор покрывающих приложение тестов.

sql файлы с исходными тестовыми данными расположены в каталоге resources/schema.sql, data.sql и содержит 4 таблицы с данными
авторов, книг, жанров и таблицы связи жанров и книг.

Команды:
aa: поиск всех авторов
ag: поиск всех жанров

ab: поиск всех книг
bins: добавление книги (bins BookTitle_4 1 1,6)
bbid: поиск книги по идентификатору (bbid 1)
bdel: удаление книги по идентификатору (bdel 2)
bupd: обновление книги (bupd 4 BookTitle_44 3 2,5)

## Сборка сервиса
### Используемое ПО
Для развертывания и сборки компонент сервиса на компьютере должны быть предустановлены:
1. Java SDK ver. 17+
2. maven ver. 3.8+

Перед сборкой убедитесь что переменная окружения JAVA_HOME указывает на корневой каталог Java SDK 17-й версии.
