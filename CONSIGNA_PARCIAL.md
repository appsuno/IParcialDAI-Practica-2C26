# Primer Parcial Parte Práctica: Auditoría y Refactorización en Jetpack Compose
**Materia:** Programación de Aplicaciones Móviles / Desarrollo de Aplicaciones I  
**Institución:** Universidad Argentina de la Empresa (UADE)  
**Facultad:** Facultad de Ingeniería y Cs. Exactas  

---

## 1. Contexto y Objetivos

La Alianza Rebelde ha recibido el prototipo funcional de su nuevo centro de inteligencia táctica galáctica (**StarWarsCompose / Holocrón Galáctico**), construido en **Kotlin** y **Jetpack Compose con Material 3**. La aplicación integra un repositorio local con registros canónicos de SWAPI (*The Star Wars API*) que comprende **Películas, Personajes, Planetas y Razas/Especies**, permite alternar dinámicamente entre categorías mediante chips de filtrado, buscar registros por nombre o ID, calcular el porcentaje de exploración y los elementos restantes, marcar y desmarcar registros en el Holocrón, y transmitir reportes a la flota rebelde mediante el sistema de mensajería del dispositivo.

Aunque el código compila y la aplicación puede iniciar, el equipo de desarrollo junior ha incurrido en **10 errores conceptuales y de lógica de programación graves** que violan los principios fundamentales del modelo declarativo de Compose, el tipado de Kotlin, la lógica booleana y el manejo de colecciones.

Tu objetivo en este examen es actuar como **Revisor Senior de Código (Code Reviewer)**:
1. **Identificar** los 10 errores analizando el código fuente (no es obligatorio disponer de un emulador, los errores son evidentes mediante lectura estática de código).
2. **Justificar** por qué cada fragmento representa un error conceptual o de lógica.
3. **Corregir** cada error en el código para que el proyecto funcione de forma coherente y siga las mejores prácticas de la materia.

---

## 2. Pautas de Trabajo

- **Archivos a inspeccionar:**
  - `app/src/main/java/com/uade/starwars/ui/StarWarsScreen.kt`
  - `app/src/main/java/com/uade/starwars/logic/StarWarsLogic.kt`
  - `app/src/main/res/values/strings.xml`
- No agregues librerías externas adicionales ni alteres las versiones de Gradle.
- Cada error resuelto y justificado correctamente tiene un valor de **1 punto** (Total: 10 puntos).
- Si utilizás un asistente de Inteligencia Artificial para consultas conceptuales, deberás completar el **Registro Obligatorio de uso de IA** que figura al final de este documento (según la Sección 17 de la guía de la materia).

---

## 3. Matriz 

Completá la siguiente tabla para cada uno de los 10 errores encontrados:

### Error 1
- **Archivo y línea aproximada:** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```

### Error 2
- **Archivo y línea aproximada:** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```

### Error n
- **Archivo y línea aproximada:** `...`
- **¿Por qué es un error conceptual / de lógica?:** `...`
- **Código de corrección:**
```kotlin
// Escribí aquí tu corrección
```


## 5. Registro a completar sobre el uso de Asistentes de IA

Si utilizaste asistentes de Inteligencia Artificial para consultar dudas conceptuales, completá el siguiente registro:

### Registro de Uso de IA
- **1. Problema o duda conceptual:** `...`
- **2. Prompt enviado a la IA:** `...`
- **3. Explicación útil que aportó:** `...`
- **4. Decisión y código propio aplicado:** `...`

> **Recordatorio:** El objetivo didáctico no es penalizar el uso de IA, sino validar que comprendas plenamente el razonamiento detrás de cada corrección aplicada.
