package pe.edu.ulima.pm.cineapp

data class Pelicula(val nombre: String, val hora: String, val resena: String, val img: Int)

class GestorPeliculas{
    fun obtenerPeliculas(): List<Pelicula> {
        val peliculas  = ArrayList<Pelicula>()
        peliculas.add(Pelicula(
            "Dr Strange 2",
            "15:00 pm",
            "Doctor Strange en el Multiverso de la Locura (en inglés: Doctor Strange in the Multiverse of Madness) es una película de superhéroes estadounidense basada en el personaje Doctor Strange, de Marvel Comics. Producida por Marvel Studios y distribuida por Walt Disney Studios Motion Pictures, es la secuela de Doctor Strange (2016) y la película número 28 del Universo cinematográfico de Marvel (UCM). La película está dirigida por Sam Raimi, escrita por Michael Waldron, y está protagonizada por Benedict Cumberbatch como Stephen Strange, junto a Elizabeth Olsen, Chiwetel Ejiofor, Benedict Wong, Xochitl Gomez, Michael Stuhlbarg y Rachel McAdams. En la película, Strange viaja a través del multiverso para proteger a América Chávez (Gómez), una adolescente capaz de abrir portales en forma de estrella a distintos universos, de Wanda Maximoff (Olsen).",
            R.drawable.doctor_strange_2))
        peliculas.add(Pelicula(
            "Top Gun Maverick",
            "17:00 pm",
            "Top Gun: Maverick se lleva a cabo 35 años después de los eventos de la película original y muestra al legendario piloto ´Pete Maverick´ Mitchell (Tom Cruise), como capitán y nuevo instructor de vuelo de la academia de pilotos de combate Top Gun en California. Allí guía ahora a los nuevos pilotos de combate, hombres y mujeres. Entre ellos está el teniente Bradley Bradshaw (Milles Teller), el hijo de Goose, su antiguo compañero que falleció en un accidente de vuelo durante el entrenamiento de pilotos, que busca convertirse ahora en un aviador mucho mejor de lo que su padre era.",
            R.drawable.top_gun_maverick))
        peliculas.add(Pelicula(
            "Detective Pikachu",
            "11:00 am",
            "Pokémon: Detective Pikachu es una película de fantasía\u200B dirigida por Rob Letterman y escrita por Nicole Perlman y Letterman, basada en el videojuego del mismo nombre. La película es una empresa conjunta estadounidense y japonesa producida por Legendary Pictures, The Pokémon Company, Warner Bros. Pictures y Toho.",
            R.drawable.detective_pikachu))
        peliculas.add(Pelicula(
            "El Hombre Araña 3",
            "12:00 pm",
            "Peter Parker sufre una terrible transformación cuando su traje se vuelve negro y libera su personalidad oscura y vengativa. Afrontará el mayor desafío de su vida al tener que redescubrir la humildad y compasión que lo hacen ser quien es: un héroe.",
                    R.drawable.spiderman3))
        peliculas.add(Pelicula(
            "Sonic 2",
            "14:00 pm",
            "El erizo azul favorito del mundo está de regreso para una nueva aventura en SONIC 2: LA PELÍCULA. Después de establecerse en Green Hills, Sonic está ansioso por demostrar que tiene lo que se necesita para ser un verdadero héroe. Su prueba llega cuando el Dr. Robotnik regresa, esta vez con un nuevo socio, Knuckles, en busca de una esmeralda que tenga el poder de destruir civilizaciones. Sonic se une a su propio compañero, Tails, y juntos se embarcan en un viaje trotamundos para encontrar la esmeralda antes de que caiga en las manos equivocadas.",
            R.drawable.sonic2))
        return peliculas
    }
}