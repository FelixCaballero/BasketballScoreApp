#  Basketball Score App

Una aplicación Android simple e intuitiva para llevar el marcador de partidos de baloncesto entre equipos Local y Visitante.

##  Características

- **Contador de puntos**: Botones para sumar +1, +2 o restar -1 punto a cada equipo
- **Interfaz simétrica**: Diseño claro con controles para ambos equipos
- **Reinicio rápido**: Botón para resetear el marcador a 0-0
- **Pantalla de resultados**: Vista dedicada que muestra el marcador final y declara al ganador
- **Data Binding**: Implementación moderna usando Android Data Binding
- **Interfaz responsive**: Diseño con ConstraintLayout adaptable

## 🎯 Capturas de pantalla

```

```

## 🏗️ Arquitectura del proyecto

```
com.example.basketballscore/
├── MainActivity.java          # Pantalla principal con el marcador
├── ScoreActivity.java         # Pantalla de resultados
├── Constants.java             # Constantes para extras del Intent
└── databinding/
    ├── ActivityMainBinding
    └── ActivityScoreBinding
```

### Estructura de archivos

```
app/
├── src/main/
│   ├── java/com/example/basketballscore/
│   │   ├── MainActivity.java
│   │   ├── ScoreActivity.java
│   │   └── Constants.java
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml
│   │   │   └── activity_score.xml
│   │   └── values/
│   │       └── strings.xml
│   └── AndroidManifest.xml
└── build.gradle
```

### Pantalla Principal (MainActivity)

1. **Sumar puntos**: Usa los botones `+1` o `+2` para cada equipo
2. **Restar puntos**: Usa el botón `-1` si hay un error (no puede bajar de 0)
3. **Reiniciar**: Presiona el botón `⟲` para volver ambos marcadores a 0
4. **Ver resultados**: Presiona el botón `→` para ir a la pantalla de resultados

### Pantalla de Resultados (ScoreActivity)

Muestra:
- El marcador final en formato `XX - XX`
- Un mensaje indicando el resultado:
  - "Ganó el equipo Local"
  - "Ganaron los Visitantes"
  - "Fue un empate"


### Data Binding
La aplicación utiliza Data Binding para vincular las vistas directamente con el código Java, eliminando la necesidad de `findViewById()`.

```java
binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
binding.btnLocalPlus1.setOnClickListener(v -> changeLocal(+1));
```
