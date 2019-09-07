# A CMS based on Vue framework

## Requirement

1. nodejs

2. openjdk(11+)

3. gradle

4. docker(optional)

## Run

### build front-end

```shell
cd front-end
npm i
npm run build
cp dist ../back-end/src/main/resources/public
```

### boot back-end

```shell
cd ../back-end
./gradlew bootRun
```
