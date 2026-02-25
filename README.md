# Tenis TDD - Sistema de Puntuación de Tenis

![Java](https://img.shields.io/badge/Java-17-orange)
![JUnit](https://img.shields.io/badge/JUnit-5.12.2-green)

## 📋 Descripción

Sistema de puntuación de tenis desarrollado siguiendo la metodología **TDD (Test-Driven Development)** y aplicando los **principios SOLID**. El sistema traduce las puntuaciones numéricas del tenis a su representación textual estándar.

## 🎾 Reglas del Tenis

### Puntuación Regular
- **0 puntos** = Love
- **1 punto** = Fifteen (15)
- **2 puntos** = Thirty (30)
- **3 puntos** = Forty (40)

### Puntuación Especial
- Cuando ambos jugadores tienen la misma puntuación: **"[Score]-All"** (ej: "Fifteen-All")
- **Deuce**: Cuando ambos jugadores tienen 3 o más puntos y están empatados
- **Advantage**: Cuando un jugador tiene 1 punto de ventaja después del Deuce
- **Win**: Cuando un jugador tiene 2 o más puntos de ventaja después del Deuce


## 📁 Estructura del Proyecto

```
tenis-tdd/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── BasicScoreTranslator.java      # Coordinador principal
│   │       ├── GameScoreTranslator.java       # Interfaz para traductores de juego
│   │       ├── RegularGameTranslator.java     # Traductor de juegos regulares
│   │       ├── DeuceGameTranslator.java       # Traductor de Deuce/Advantage/Win
│   │       ├── ScoreTranslatorFactory.java    # Fábrica de traductores
│   │       ├── ScoreTranslator.java           # Interfaz base
│   │       ├── LoveTranslator.java            # Traductor "Love"
│   │       ├── FifteenTranslator.java         # Traductor "Fifteen"
│   │       ├── ThirtyTranslator.java          # Traductor "Thirty"
│   │       └── FortyTranslator.java           # Traductor "Forty"
│   └── test/
│       └── java/
│           ├── BasicScoringTest.java          # Tests de puntuación regular
│           └── AdvantageTranslatorTest.java   # Tests de Deuce/Advantage
├── pom.xml
└── README.md
```

## 🚀 Cómo Usar

### Requisitos
- Java 17 o superior
- Maven (opcional para compilación)

### Compilación

#### Con Java directamente:
```bash
cd src/main/java
javac -d ../../../target/classes *.java
```

#### Con Maven:
```bash
mvn clean compile
```

### Ejecución de Tests

```bash
mvn test
```

## 🧪 Testing

El proyecto incluye tests completos usando JUnit 5:

### BasicScoringTest
Prueba todos los casos de puntuación regular:
- Love-All, Fifteen-Love, Thirty-Love, etc.
- Casos de empate (Fifteen-All, Thirty-All)
- Todas las combinaciones hasta Forty

### AdvantageTranslatorTest
Prueba las situaciones especiales:
- Deuce (3-3)
- Advantage Player One/Two
- Win scenarios


## 📊 Casos de Prueba

| Jugador 1 | Jugador 2 | Resultado Esperado |
|-----------|-----------|-------------------|
| 0 | 0 | Love-All |
| 1 | 0 | Fifteen-Love |
| 2 | 0 | Thirty-Love |
| 3 | 0 | Forty-Love |
| 0 | 1 | Love-Fifteen |
| 1 | 1 | Fifteen-All |
| 2 | 2 | Thirty-All |
| 3 | 3 | Deuce |
| 4 | 3 | Advantage Player One |
| 3 | 4 | Advantage Player Two |
| 5 | 3 | Player One Wins |
| 3 | 5 | Player Two Wins |

## 🎓 Principios de Diseño Aplicados

- **TDD (Test-Driven Development)**: Tests escritos primero
- **Clean Code**: Nombres descriptivos y métodos pequeños
- **SOLID Principles**: Aplicación rigurosa de los 5 principios
- **Factory Pattern**: Para crear traductores de puntuación
- **Strategy Pattern**: Diferentes estrategias de traducción (Regular vs Deuce)

## 🧠 Uso de IA
El proyecto fue desarrollado utilizando inteligencia natural y buenas practicas apoyado en herramientas de inteligencia artificial para generar código, escribir tests y documentar el proyecto. La IA ayudó a acelerar el proceso de desarrollo y a garantizar la calidad del código.

## 📄 Licencia

Este proyecto es de código abierto.

