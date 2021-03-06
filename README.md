## Вступительная Компания (учебный проект)

Система Вступительная Компания. Студент регистрируется на сдачу
предметов. Администратор выставляет оценки за предметы. Студент
выбирает специальность в университете. Формируются рейтинговые списки
поступивших, студентам приходит уведомление о поступлении.

### Общие требования

Необходимо построить веб-приложение, поддерживающую следующую
функциональность:
1. На основе сущностей предметной области создать классы их
описывающие.
2. Классы и методы должны иметь отражающую их функциональность
названия и должны быть грамотно структурированы по пакетам
3. Информацию о предметной области хранить в БД, для доступа
использовать API JDBC с использованием пула соединений,
стандартного или разработанного самостоятельно. В качестве СУБД
рекомендуется MySQL.
4. Приложение должно поддерживать работу с кириллицей (быть
многоязычной), в том числе и при хранении информации в БД.
5. Код должен быть документирован.
6. Приложение должно быть покрыто Юнит-тестами
7. При разработке бизнес логики использовать сессии и фильтры, и
события в системе обрабатывать с помощью Log4j.
8. В приложении необходимо реализовать Pagination, Transaction в
зависимости от Вашего проекта
9. Используя сервлеты и JSP, реализовать функциональности,
предложенные в постановке конкретной задачи.
10. В страницах JSP применять библиотеку JSTL
11. Приложение должно корректно реагировать на ошибки и исключения
разного рода (Пользователь никогда не должен видеть stack-trace на
стороне front-end).
12. В приложении должна быть реализована система Авторизации и
Аутентификации

### Технологии

#### Обязательные к использованию

1. JSP + JSTL;
2. Servlets;
3. JDBC;
4. Log4J;
5. JUnit.

#### Запрещённые к использованию

1. Scriplets;
2. Applets;
3. Spring / EJB;
4. Hibernate, JPA.

#### Поощряемые

1. Mockito;
2. Apache commons;
3. Slf4J;
4. Собственные теги;
5. Собственная Аннотация и Исключения.

### Предварительные требования

1. Установленный JDK 10
2. Установленная СУБД MySQL 5.7.21
3. Установленный Apache Maven 3.5.3

### Установка

Из командной строки:
1. Открыть корневую директорию проекта
2. Выполнить вход в командную строку MySQL командой "mysql -u root -p --default-character-set=utf8" (username="root", password="root")
3. Выполнить команду "source scripts/creation.sql;", которая создаст базу данных "fp_db" и заполнит ее тестовыми данными
4. Выполнить выход из командной строки MySQL командой "exit;"
5. Выполнить команду "mvn compile" для компиляции исходного кода
6. Выполнить команду "mvn package" для упаковки проекта в WAR

### Запуск 

Из командной строки:
1. Поместить упакованый WAR в папку webapps корневого каталога Tomcat.
2. Запустить Tomcat Serrver.
3. Запущенное приложение должно быть доступно по адресу http://localhost:8080/IntroductoryCampaign-1.0-SNAPSHOT/

### Автор

Гудзенко Иван
