# Gradle Test Intelligence Project

A Java project with 8 source classes and **179 unit tests** designed for test intelligence agent evaluation. The Gradle daemon runs in a Docker container (separate "pod"), not on the host machine.

## Project Structure

```
src/main/java/com/example/
├── Calculator.java        # Arithmetic operations
├── StringUtils.java       # String manipulation
├── CollectionUtils.java   # Collection operations
├── MathUtils.java         # Mathematical functions (prime, fibonacci, stats)
├── ValidationUtils.java   # Input validation (email, phone, IP, password)
├── DateUtils.java         # Date/time operations
├── SortUtils.java         # Sorting algorithms & binary search
└── ConversionUtils.java   # Unit conversions (temp, distance, weight, number bases)

src/test/java/com/example/
├── CalculatorTest.java       (21 tests)
├── StringUtilsTest.java      (24 tests)
├── CollectionUtilsTest.java  (16 tests)
├── MathUtilsTest.java        (24 tests)
├── ValidationUtilsTest.java  (28 tests)
├── DateUtilsTest.java        (22 tests)
├── SortUtilsTest.java        (23 tests)
└── ConversionUtilsTest.java  (21 tests)
```

## Prerequisites

- Docker and Docker Compose
- No local JDK or Gradle installation required (everything runs in the container)

## How It Works

The Gradle daemon runs **inside a Docker container**, not on your host machine. The project source code is bind-mounted into the container. When you run tests, the command is executed inside the container where the daemon is already warm and ready.

```
┌─────────────────────┐       ┌────────────────────────────┐
│   Host Machine      │       │  Docker Container          │
│                     │       │  (gradle-daemon)            │
│  Project files ─────┼──────>│  /project (bind mount)     │
│  (bind mount)       │       │                            │
│                     │       │  Gradle Daemon (JVM)       │
│  docker exec ───────┼──────>│  gradle test               │
│                     │       │                            │
│  build/ reports <───┼───────┤  Test results written      │
│                     │       │  to mounted volume         │
└─────────────────────┘       └────────────────────────────┘
```

## Quick Start

### 1. Start the Gradle daemon container

```bash
docker compose up -d --build
```

This builds the image (JDK 17 + Gradle 8.7), starts the container, and warms up the Gradle daemon.

### 2. Run all tests

```bash
docker exec gradle-daemon gradle test
```

Or use the convenience script:

```bash
./run-tests.sh
```

### 3. Run specific test classes

```bash
# Run only CalculatorTest
docker exec gradle-daemon gradle test --tests "com.example.CalculatorTest"

# Run only tests matching a pattern
docker exec gradle-daemon gradle test --tests "*MathUtils*"

# Run a single test method
docker exec gradle-daemon gradle test --tests "com.example.CalculatorTest.addPositiveNumbers"
```

### 4. Run tests with additional options

```bash
# Force re-run (skip up-to-date checks)
docker exec gradle-daemon gradle test --rerun

# With info logging
docker exec gradle-daemon gradle test --info

# Generate JaCoCo coverage report
docker exec gradle-daemon gradle test jacocoTestReport
```

### 5. View test reports

Test results are written to `build/` on the host (via the bind mount):

- **HTML report**: `build/reports/tests/test/index.html`
- **XML results**: `build/test-results/test/`
- **JaCoCo coverage**: `build/reports/jacoco/test/html/index.html`

### 6. Stop the daemon container

```bash
docker compose down
```

To also remove the Gradle cache volume:

```bash
docker compose down -v
```

## Running Without Docker (local Gradle)

If you want to skip Docker and run locally (requires JDK 17+):

```bash
./gradlew test
```

## For Test Intelligence Agents

The project is structured so that a test intelligence agent can:

1. **Map source-to-test relationships**: Each source class has a corresponding test class.
2. **Select tests by changed files**: A change to `Calculator.java` should trigger `CalculatorTest`.
3. **Use JUnit XML reports** at `build/test-results/test/` for result parsing.
4. **Use JaCoCo XML** at `build/reports/jacoco/test/jacocoTestReport.xml` for coverage-based selection.
5. **Run subsets** via `--tests` filter patterns.
