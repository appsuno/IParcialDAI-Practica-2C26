package com.uade.starwars.data

/**
 * Categorías principales disponibles en el Holocrón de Star Wars.
 */
enum class StarWarsCategory(val displayName: String) {
    FILMS("Películas"),
    CHARACTERS("Personajes"),
    PLANETS("Planetas"),
    SPECIES("Especies")
}

/**
 * Representa una película de la saga (SWAPI /films).
 */
data class Film(
    val id: Int,
    val title: String,
    val episodeId: Int,
    val director: String,
    val releaseYear: Int,
    val openingCrawl: String,
    val posterUrl: String = "https://starwars-visualguide.com/assets/img/films/$id.jpg"
)

/**
 * Representa un personaje de la saga (SWAPI /people).
 */
data class Character(
    val id: Int,
    val name: String,
    val height: String,
    val mass: String,
    val gender: String,
    val homeworld: String,
    val species: String,
    val imageUrl: String = "https://starwars-visualguide.com/assets/img/characters/$id.jpg"
)

/**
 * Representa un planeta del universo de Star Wars (SWAPI /planets).
 */
data class Planet(
    val id: Int,
    val name: String,
    val climate: String,
    val terrain: String,
    val population: String,
    val imageUrl: String = "https://starwars-visualguide.com/assets/img/planets/$id.jpg"
)

/**
 * Representa una raza o especie del universo de Star Wars (SWAPI /species).
 */
data class Species(
    val id: Int,
    val name: String,
    val classification: String,
    val designation: String,
    val averageHeight: String,
    val language: String,
    val imageUrl: String = "https://starwars-visualguide.com/assets/img/species/$id.jpg"
)

/**
 * Modelo unificado para visualización en las tarjetas de la interfaz Compose.
 */
data class StarWarsItem(
    val id: Int,
    val name: String,
    val subtitle: String,
    val detail: String,
    val category: StarWarsCategory,
    val imageUrl: String
)

// Funciones de mapeo a StarWarsItem para la interfaz
fun Film.toDisplayItem(): StarWarsItem = StarWarsItem(
    id = id,
    name = title,
    subtitle = "Episodio $episodeId • Año $releaseYear",
    detail = "Director: $director",
    category = StarWarsCategory.FILMS,
    imageUrl = posterUrl
)

fun Character.toDisplayItem(): StarWarsItem = StarWarsItem(
    id = id,
    name = name,
    subtitle = "$species • Origen: $homeworld",
    detail = "Altura: ${height}cm • Género: $gender",
    category = StarWarsCategory.CHARACTERS,
    imageUrl = imageUrl
)

fun Planet.toDisplayItem(): StarWarsItem = StarWarsItem(
    id = id,
    name = name,
    subtitle = "Clima: $climate",
    detail = "Terreno: $terrain • Pob.: $population",
    category = StarWarsCategory.PLANETS,
    imageUrl = imageUrl
)

fun Species.toDisplayItem(): StarWarsItem = StarWarsItem(
    id = id,
    name = name,
    subtitle = "Clasificación: $classification",
    detail = "Idioma: $language • Altura prom: ${averageHeight}cm",
    category = StarWarsCategory.SPECIES,
    imageUrl = imageUrl
)
