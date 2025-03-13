/**
 * OBJECT AND ARRAY DESTRUCTURING IN JS
 * 
 * we often want the things inside an object or an array, but we don't want/need the whole thing
 * we also often want to break elements out into smaller/more manageable/more directly-accessible pieces
 * 
 * 
 */

// spread operator: ...
// the spread operator reverses the actions of the similarly-notated rest operator
// it takes parts of a thing, and breaks them out
function add(x, y, z) {
    return x + y + z;
}

let nums = [ 5, 10, 15 ];

// this spreads the values in the array out into individual elements
console.log(add(...nums));

// there is no longer a connection between the individual elements and the original array
let nums2 = [ 0, 0, ...nums, 0, 0 ];
console.log(nums2);

const [ one, two, three ] = [ ...nums ];

console.log(one);
console.log(two);
console.log(three);

// can do this for objects as well
const movie = {
    title: 'Jaws',
    year: '1976',
    rating: 'PG',
    boxOffice: 300000000
}

// for objects, since they're not iterable and the properties are not ordered
// you have to match the property names, so JS knows which values to map to the new variables
// you don't have to use all of them, and the order doesn't matter
// if you use a variable name for which there's no match, it'll just assign undefined
const { title, year, rating, boxOffice, reviewScore } = { ...movie };

console.log(title);
console.log(year);
console.log(rating);
console.log(boxOffice);
console.log(reviewScore);

// you can also spread to add to a new object
const rereleasedMovie = {
    ...movie,
    rereleaseYear: 2025,
    updatedBoxOffice: 500000000
}

console.log(rereleasedMovie);
