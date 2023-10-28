function solve(input) {
    class Movie {
        constructor(name, director, date) {
            this.name = name;
            this.director = director;
            this.date = date;
        }
    }

    const movies = [];

    for (let line of input) {
        const tokens = line.split(' ');

        if (tokens[0] === 'addMovie') {
            const movieName = tokens.slice(1).join(' ');
            movies.push(new Movie(movieName, '', ''));
        } else {
            const match = line.match(/^(.*?)\s(?:directedBy|onDate)/);
            const movieName = match ? match[1].trim() : line.trim();

            let movieIndex = movies.findIndex(movie => movie.name === movieName);

            if (movieIndex !== -1) {
                if (tokens.includes('directedBy')) {
                    const director = tokens.slice(tokens.indexOf('directedBy') + 1).join(' ');
                    movies[movieIndex].director = director;
                } else if (tokens.includes('onDate')) {
                    const date = tokens.slice(tokens.indexOf('onDate') + 1).join('');
                    movies[movieIndex].date = date;
                }
            }
        }
    }

    const filteredMovies = movies.filter(movie => movie.name && movie.director && movie.date);

    for (const movie of filteredMovies) {
        console.log(JSON.stringify(movie));
    }
}

solve(['addMovie Fast and Furious','addMovie Godfather','Inception directedBy Christopher Nolan',
    'Godfather directedBy Francis Ford Coppola','Godfather onDate 29.07.2018','Fast and Furious onDate 30.07.2018',
    'Batman onDate 01.08.2018','Fast and Furious directedBy Rob Cohen']);
solve(['addMovie The Avengers','addMovie Superman','The Avengers directedBy Anthony Russo',
    'The Avengers onDate 30.07.2010','Captain America onDate 30.07.2010','Captain America directedBy Joe Russo']);