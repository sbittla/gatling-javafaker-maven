# gatling-javafaker-maven framework

This is a simple framework for Gatling Frontline using JavaFaker for data generation, implemented in Scala with Maven.

## Setup

1. Clone the repository.
2. Navigate to the project directory.
3. Open the project in IntelliJ IDEA.
4. Set environment variables in IntelliJ:
   - Go to `Run` -> `Edit Configurations...`
   - Select your simulation configuration.
   - Add `BASE_URL` environment variable with your base URL.
5. Run the simulations using the Maven lifecycle or directly from IntelliJ.

## Folder Structure

```
gatling-javafaker-maven/
├── src/
│   ├── main/
│   │   ├── scala/
│   │   │   ├── services/
│   │   │   │   └── UserService.scala
│   │   │   └── util/
│   │   │       └── DataGenerator.scala
│   ├── test/
│   │   ├── scala/
│   │   │   └── simulation/
│   │   │       └── UserSimulation.scala
│   │   ├── helpers/
│   │   │   └── Engine.scala
│   ├── resources/
│   │   ├── config/
│   │   │   └── UserConfig.conf
│   │   ├── images/
│   │   │   └── IntelliJ.png
│   │   │
├── pom.xml
└── README.md
```

- `src/main/scala`: Contains the main code (config, service, util).
- `src/test/scala`: Contains the Gatling simulations.

## Dependencies

- Gatling
- JavaFaker

## Example

To run the `UserSimulation`, use the following command:

```bash
mvn gatling:test
```

Example

To run the `UserSimulation`, use the following command:

## IntelliJ

To configure run time settings in IntelliJ
<img height="500" src="https://github.com/sbittla/gatling-javafaker-maven/tree/main/src/test/resources/images/IntelliJ.png" width="500"/>
