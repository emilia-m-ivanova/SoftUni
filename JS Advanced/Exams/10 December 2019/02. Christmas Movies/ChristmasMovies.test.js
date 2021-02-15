const ChristmasMovies = require('./02. Christmas Movies_Resources');
const assert = require('chai').assert;
describe('Tests', () => {
    describe('ChristmasMovies', () => {
        let cinema;
        const actors1 = ['Johny Depp', 'Emma Stone', 'Emma Stone']
        const actors2 = ['Emma Stone']
        beforeEach(() => cinema = new ChristmasMovies())
        it('constructor', () => {
            assert.deepEqual(cinema.movieCollection, [], 'MovieCollection not initialised');
            assert.deepEqual(cinema.watched, {}, 'Watched not initialised');
            assert.deepEqual(cinema.actors, [], 'Movies not initialised');
        });
        it('buyMovie', () => {
            assert(cinema.buyMovie('New movie', actors1) === 'You just got New movie to your collection in which Johny Depp, Emma Stone are taking part!', 'Wrong return value');
            assert(cinema.movieCollection.length === 1, 'movie not added to collection');
            assert.deepEqual(cinema.movieCollection[0], {
                name: 'New movie',
                actors: ['Johny Depp', 'Emma Stone']
            }, 'movie not added correctly');
            assert.throws(() => cinema.buyMovie('New movie', actors1), 'You already own New movie in your collection!')
            assert(cinema.movieCollection.length === 1, 'movie incorrectly added to collection');
            cinema.buyMovie('New movie2', actors2);
            assert(cinema.movieCollection.length === 2, 'movie not added to collection');

        });
        it('discardMovie', () => {
            assert.throw(() => cinema.discardMovie('New movie2'), 'New movie2 is not at your collection!');
            cinema.buyMovie('New movie', actors1);
            assert.throw(() => cinema.discardMovie('New movie'), 'New movie is not watched!');
            let removed = cinema.movieCollection.find(e => e.name === 'New movie');
            assert(removed === undefined, 'Movie not deleted from collection');

            cinema.buyMovie('New movie2', actors2);
            cinema.watchMovie('New movie2');
            assert(cinema.discardMovie('New movie2')==='You just threw away New movie2!');
            assert(cinema.watched.hasOwnProperty('New movie2') === false, 'Movie not deleted from watched');
            removed = cinema.movieCollection.find(e => e.name === 'New movie2');
            assert(removed === undefined, 'Movie not deleted from collection');
        });
        it('watchMovie', () => {
            assert.throw(() => cinema.watchMovie('New movie'), 'No such movie in your collection!');
            cinema.buyMovie('New movie', actors1);
            assert(cinema.watched['New movie'] === undefined, 'Movie incorrectly registered as watched')
            cinema.watchMovie('New movie');
            assert(cinema.watched['New movie'] === 1, 'Movie not registered as watched')
            cinema.watchMovie('New movie');
            assert(cinema.watched['New movie'] === 2, 'Movie not registered as watched')
        });
        it('favouriteMovie', () => {
            assert.throw(() => cinema.favouriteMovie(), 'You have not watched a movie yet this year!');
            cinema.buyMovie('New movie', actors1);
            cinema.buyMovie('New movie2', actors2);
            assert.throw(() => cinema.favouriteMovie(), 'You have not watched a movie yet this year!');
            cinema.watchMovie('New movie');
            assert(cinema.favouriteMovie() === 'Your favourite movie is New movie and you have watched it 1 times!');
            cinema.watchMovie('New movie');
            assert(cinema.favouriteMovie() === 'Your favourite movie is New movie and you have watched it 2 times!');
            cinema.watchMovie('New movie2');
            cinema.watchMovie('New movie2');
            assert(cinema.favouriteMovie() === 'Your favourite movie is New movie and you have watched it 2 times!');
            cinema.watchMovie('New movie2');
            assert(cinema.favouriteMovie() === 'Your favourite movie is New movie2 and you have watched it 3 times!');

        });
        it('mostStarredActor', () => {
            assert.throw(() => cinema.mostStarredActor(), 'You have not watched a movie yet this year!');
            cinema.buyMovie('New movie', actors1);
            assert(cinema.mostStarredActor() === 'The most starred actor is Johny Depp and starred in 1 movies!', 'Didn\'t find actor');
            cinema.buyMovie('New movie2', actors2);
            assert(cinema.mostStarredActor() === 'The most starred actor is Emma Stone and starred in 2 movies!', 'Didn\'t find actor');

        });
    })
})