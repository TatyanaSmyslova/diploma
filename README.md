Процедура запуска автотестов

Необходимое окружение:
1. Docker Desktop
2. Eclipse Temurin OpenJDK

Запуск
1. Получить [код репозитория](https://github.com/TatyanaSmyslova/diploma) удобным способом
2. Выполнить (в каталоге [Docker](https://github.com/TatyanaSmyslova/diploma/tree/master/Docker)) `docker-compose up -d`.
3. Включить `SUT` командой `java -jar aqa-shop.jar`.
4. Запустить автотесты командой `./gradlew clean test`.

Переключение баз данных

Чтобы задействовать MySQL необходимо:

включить `SUT` командой `java -jar aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app`;
запустить автотесты командой `./gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app`.
