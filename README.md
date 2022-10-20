Запуск авто-тестов

Шаги по воспроизведению :

1. Запустить в Docker контейнеры СУБД MySQl, PostgerSQL и Node.js
2. Запустить контейнеры в терминале

`docker-compose up`

3. Запустить SUT командой

для MySQL:

`java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -jar artifacts/aqa-shop.jar`

для PostgreSQL:

`java -Dspring.datasource.url=jdbc:postgresql://localhost:5433/app -jar artifacts/aqa-shop.jar`

Приложение должно запуститься на:

`http://localhost:8080/`

4. Запустить авто-тесты командой

для MySQL:

`gradlew clean test -Durl=jdbc:mysql://localhost:3306/app`

для PostgreSQL:

`gradlew clean test -Durl=jdbc:postgresql://localhost:5433/app`

5. Сгенерировать отчеты

`gradlew allureReport`
`gradlew allureServe`

Для завершения работы allureServe выполнить команду:

`Ctrl + С далее Y`

Остановить и удалить все контейнеры

`docker-compose down`
