package com.example.cinaeste.data

import com.example.cinaeste.data.model.Movie

fun favoriteMovies(): List<Movie> {
    return listOf(
            Movie(1, "In time",
                    "In a future where people stop aging at 25, but are engineered to live only one more year, having the means to buy your way out of the situation is a shot at immortal youth.",
                    "20.10.2011.", "https://www.imdb.com/title/tt1637688/",
                    "scifi", "https://www.imdb.com/title/tt1637688/", "https://www.imdb.com/title/tt1637688/"),
            Movie(2, "Imitation game",
                    "During World War II, the English mathematical genius Alan Turing tries to crack the German Enigma code with help from fellow mathematicians.",
                    "24.12.2014.", "https://www.imdb.com/title/tt1637688/",
                    "drama", "https://www.imdb.com/title/tt1637688/", "https://www.imdb.com/title/tt1637688/"),
            Movie(3, "Love, Rosie",
                    "Rosie and Alex have been best friends since they were 5, so they couldn't possibly be right for one another...or could they? When it comes to love, life and making the right choices, these two are their own worst enemies.",
                    "05.11.2014.", "https://www.imdb.com/title/tt1638002/",
                    "romance", "https://www.imdb.com/title/tt1638002/", "https://www.imdb.com/title/tt1638002/")

    )
}
fun recentMovies(): List<Movie> {
    return listOf(
            Movie(1, "The Courier",
                    "Cold War spy Greville Wynne and his Russian source try to put an end to the Cuban Missile Crisis.",
                    "12.03.2021.", "https://www.imdb.com/title/tt4479380/",
                    "action", "https://www.imdb.com/title/tt4479380/", "https://www.imdb.com/title/tt4479380/"),
            Movie(2, "SAS: Red Notice",
                    "A small army of well trained criminals led by Laszlo Antonov have hijacked a train deep beneath the English Channel.",
                    "17.03.2021.", "https://www.imdb.com/title/tt8368512/",
                    "thriller", "https://www.imdb.com/title/tt8368512/", "https://www.imdb.com/title/tt8368512/"),
            Movie(3, "Nobody",
                    "A bystander who intervenes to help a woman being harassed by a group of men becomes the target of a vengeful drug lord.",
                    "26.03.2021.", "https://www.imdb.com/title/tt7888964/",
                    "crime", "https://www.imdb.com/title/tt7888964/", "https://www.imdb.com/title/tt7888964/")

    )
}

    fun movieActors(): Map<String, List<String>> {
        return mapOf<String, List<String>>("In time" to listOf("Justin Timberlake", "Olivia Wilde", "Bruce Willis", "Johnny Galecki", "Colin McGurk"), "Imitation game" to listOf("Keira Knightley", "Benedict Cumberbatch", "Matthew Goode"))
    }

    fun similarMovies(): Map<String, List<String>> {
        return mapOf<String, List<String>>("In time" to listOf("Anon", "Inception", "Elysium"), "Imitation game" to listOf("Enigma", "A Beautiful Mind", "The Theory of Everything"))
    }

