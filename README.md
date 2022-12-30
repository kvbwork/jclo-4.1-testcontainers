## Сборка окружения

```
./gradlew clean build -x test
docker build -t prodapp .
docker build -t devapp -f Dockerfile-dev .
```

## Запуск тестов

```
./gradlew --info clean test
```