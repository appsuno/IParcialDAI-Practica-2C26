package com.uade.starwars.data

/**
 * Repositorio local de datos para la aplicación de Star Wars (Holocrón).
 * Contiene datos estáticos basados en SWAPI (The Star Wars API) sin consumo de endpoints de red.
 */
class StarWarsRepository {

    fun getFilms(): List<Film> = listOf(
        Film(
            id = 1,
            title = "A New Hope",
            episodeId = 4,
            director = "George Lucas",
            releaseYear = 1977,
            openingCrawl = "It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire."
        ),
        Film(
            id = 2,
            title = "The Empire Strikes Back",
            episodeId = 5,
            director = "Irvin Kershner",
            releaseYear = 1980,
            openingCrawl = "It is a dark time for the Rebellion. Although the Death Star has been destroyed, Imperial troops have driven the Rebel forces from their hidden base."
        ),
        Film(
            id = 3,
            title = "Return of the Jedi",
            episodeId = 6,
            director = "Richard Marquand",
            releaseYear = 1983,
            openingCrawl = "Luke Skywalker has returned to his home planet of Tatooine in an attempt to rescue his friend Han Solo from the clutches of the vile gangster Jabba the Hutt."
        ),
        Film(
            id = 4,
            title = "The Phantom Menace",
            episodeId = 1,
            director = "George Lucas",
            releaseYear = 1999,
            openingCrawl = "Turmoil has engulfed the Galactic Republic. The taxation of trade routes to outlying star systems is in dispute."
        ),
        Film(
            id = 5,
            title = "Attack of the Clones",
            episodeId = 2,
            director = "George Lucas",
            releaseYear = 2002,
            openingCrawl = "There is unrest in the Galactic Senate. Several thousand solar systems have declared their intentions to leave the Republic."
        ),
        Film(
            id = 6,
            title = "Revenge of the Sith",
            episodeId = 3,
            director = "George Lucas",
            releaseYear = 2005,
            openingCrawl = "War! The Republic is crumbling under attacks by the ruthless Sith Lord, Count Dooku. There are heroes on both sides. Evil is everywhere."
        )
    )

    fun getCharacters(): List<Character> = listOf(
        Character(id = 1, name = "Luke Skywalker", height = "172", mass = "77", gender = "male", homeworld = "Tatooine", species = "Humano"),
        Character(id = 2, name = "C-3PO", height = "167", mass = "75", gender = "n/a", homeworld = "Tatooine", species = "Droide"),
        Character(id = 3, name = "R2-D2", height = "96", mass = "32", gender = "n/a", homeworld = "Naboo", species = "Droide"),
        Character(id = 4, name = "Darth Vader", height = "202", mass = "136", gender = "male", homeworld = "Tatooine", species = "Humano"),
        Character(id = 5, name = "Leia Organa", height = "150", mass = "49", gender = "female", homeworld = "Alderaan", species = "Humano"),
        Character(id = 10, name = "Obi-Wan Kenobi", height = "182", mass = "77", gender = "male", homeworld = "Stewjon", species = "Humano"),
        Character(id = 11, name = "Anakin Skywalker", height = "188", mass = "84", gender = "male", homeworld = "Tatooine", species = "Humano"),
        Character(id = 13, name = "Chewbacca", height = "228", mass = "112", gender = "male", homeworld = "Kashyyyk", species = "Wookiee"),
        Character(id = 14, name = "Han Solo", height = "180", mass = "80", gender = "male", homeworld = "Corellia", species = "Humano"),
        Character(id = 15, name = "Greedo", height = "173", mass = "74", gender = "male", homeworld = "Rodia", species = "Rodiano"),
        Character(id = 16, name = "Jabba Desilijic Tiure", height = "175", mass = "1358", gender = "hermaphrodite", homeworld = "Nal Hutta", species = "Hutt"),
        Character(id = 20, name = "Yoda", height = "66", mass = "17", gender = "male", homeworld = "Desconocido", species = "Especie de Yoda"),
        Character(id = 21, name = "Palpatine", height = "170", mass = "75", gender = "male", homeworld = "Naboo", species = "Humano"),
        Character(id = 22, name = "Boba Fett", height = "183", mass = "78", gender = "male", homeworld = "Kamino", species = "Humano"),
        Character(id = 32, name = "Qui-Gon Jinn", height = "193", mass = "89", gender = "male", homeworld = "Coruscant", species = "Humano"),
        Character(id = 35, name = "Padmé Amidala", height = "165", mass = "45", gender = "female", homeworld = "Naboo", species = "Humano"),
        Character(id = 36, name = "Jar Jar Binks", height = "196", mass = "66", gender = "male", homeworld = "Naboo", species = "Gungan"),
        Character(id = 44, name = "Darth Maul", height = "175", mass = "80", gender = "male", homeworld = "Dathomir", species = "Zabrak"),
        Character(id = 51, name = "Mace Windu", height = "192", mass = "84", gender = "male", homeworld = "Haruun Kal", species = "Humano")
    )

    fun getPlanets(): List<Planet> = listOf(
        Planet(id = 1, name = "Tatooine", climate = "Árido", terrain = "Desierto", population = "200.000"),
        Planet(id = 2, name = "Alderaan", climate = "Templado", terrain = "Pastizales, montañas", population = "2.000.000.000"),
        Planet(id = 3, name = "Yavin IV", climate = "Templado, tropical", terrain = "Selva, selva tropical", population = "1.000"),
        Planet(id = 4, name = "Hoth", climate = "Helado", terrain = "Tundra, cuevas de hielo", population = "Desconocida"),
        Planet(id = 5, name = "Dagobah", climate = "Cenagoso", terrain = "Pantano, junglas", population = "Desconocida"),
        Planet(id = 6, name = "Bespin", climate = "Templado", terrain = "Gigante gaseoso", population = "6.000.000"),
        Planet(id = 7, name = "Endor", climate = "Templado", terrain = "Bosques, montañas, lagos", population = "30.000.000"),
        Planet(id = 8, name = "Naboo", climate = "Templado", terrain = "Colinas, pantanos, bosques", population = "4.500.000.000"),
        Planet(id = 9, name = "Coruscant", climate = "Templado", terrain = "Paisaje urbano, montañas", population = "1.000.000.000.000"),
        Planet(id = 10, name = "Kamino", climate = "Templado", terrain = "Océano", population = "1.000.000.000"),
        Planet(id = 11, name = "Geonosis", climate = "Templado, árido", terrain = "Roca, desierto, montaña", population = "100.000.000.000"),
        Planet(id = 14, name = "Kashyyyk", climate = "Tropical", terrain = "Selva, bosques, lagos", population = "45.000.000")
    )

    fun getSpecies(): List<Species> = listOf(
        Species(id = 1, name = "Humano", classification = "Mamífero", designation = "Sintiente", averageHeight = "180", language = "Básico Galáctico"),
        Species(id = 2, name = "Droide", classification = "Artificial", designation = "Sintiente", averageHeight = "Variable", language = "Binario / Básico"),
        Species(id = 3, name = "Wookiee", classification = "Mamífero", designation = "Sintiente", averageHeight = "210", language = "Shyriiwook"),
        Species(id = 4, name = "Rodiano", classification = "Reptiliano", designation = "Sintiente", averageHeight = "170", language = "Rodese / Básico"),
        Species(id = 5, name = "Hutt", classification = "Gasterópodo", designation = "Sintiente", averageHeight = "300", language = "Huttese"),
        Species(id = 6, name = "Especie de Yoda", classification = "Mamífero", designation = "Sintiente", averageHeight = "66", language = "Básico Galáctico"),
        Species(id = 11, name = "Twi'lek", classification = "Mamífero", designation = "Sintiente", averageHeight = "170", language = "Rylothean"),
        Species(id = 12, name = "Gungan", classification = "Anfibio", designation = "Sintiente", averageHeight = "190", language = "Gungan Básico"),
        Species(id = 22, name = "Zabrak", classification = "Mamífero", designation = "Sintiente", averageHeight = "180", language = "Zabraki")
    )

    /**
     * Retorna los elementos convertidos a StarWarsItem según la categoría seleccionada.
     */
    fun getItemsByCategory(category: StarWarsCategory): List<StarWarsItem> {
        return when (category) {
            StarWarsCategory.FILMS -> getFilms().map { it.toDisplayItem() }
            StarWarsCategory.CHARACTERS -> getCharacters().map { it.toDisplayItem() }
            StarWarsCategory.PLANETS -> getPlanets().map { it.toDisplayItem() }
            StarWarsCategory.SPECIES -> getSpecies().map { it.toDisplayItem() }
        }
    }
}
