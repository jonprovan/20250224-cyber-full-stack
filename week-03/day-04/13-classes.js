/**
 * CLASSES IN JS
 * 
 * this abstraction is very similar to Java class construction
 */

class MediaProduct {

    // properties
    #title;
    type;
    releaseYear;
    studio;

    // static properties
    static mediaProductCount = 0;

    // constructor
    constructor(title, type, releaseYear, studio) {
        this.#title = title;
        this.type = type;
        this.releaseYear = releaseYear;
        this.studio = studio;
        MediaProduct.mediaProductCount++;
    }

    // getters and setters
    get title() {
        return this.#title;
    }

    set title(title) {
        if (title === 'Some Other Title')
            throw new Error('NOOOOOOOOOOOO');
        this.#title = title;
    }

    // methods
    printTitleAndType() {
        console.log(`${this.#title} is a ${this.type}`);
    }

}

// inheriting from the above class
class TVShow extends MediaProduct {

    numberOfSeasons;
    numberOfEpisodes;
    genre;

    constructor(title, type, releaseYear, studio, numberOfSeasons, numberOfEpisodes, genre) {
        super(title, type, releaseYear, studio);
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfEpisodes = numberOfEpisodes;
        this.genre = genre;
    }

}

class Sitcom extends TVShow {
    constructor(title, releaseYear, studio, numberOfSeasons, numberOfEpisodes) {
        super(title, 'TV Series', releaseYear, studio, numberOfSeasons, numberOfEpisodes, 'Sitcom');
    }
}

console.log(MediaProduct.mediaProductCount);

const genericMP = new MediaProduct('Generic Title', 'Generic Type', 2000, 'Generic Studio');

console.log(genericMP);

console.log(MediaProduct.mediaProductCount);

// without a setter, this actually creates a new .title property
// genericMP.title = 'Some Other Title';

// without a getter, this is impossible because it's private
// console.log(genericMP.#title);

console.log(genericMP.title);
genericMP.title = 'Some Other IMPROVED Title';
console.log(genericMP.title);

// instantiating our extended class
const lost = new TVShow('Lost', 'TV Series', 2004, 'Fox', 6, 132, 'Suspense');

console.log(lost);
console.log(MediaProduct.mediaProductCount);
console.log(lost.title);

const marriedWithChildren = new Sitcom('Married With Children', 1995, 'Fox', 5, 100);

console.log(marriedWithChildren);
console.log(MediaProduct.mediaProductCount);
console.log(marriedWithChildren.title);