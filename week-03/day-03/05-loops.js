/**
 * LOOPS IN JS
 * 
 * most of this is the same as in Java, but there are a few small differences
 * particularly with objects, we have to get a touch creative
 * 
 * but we have:
 * while
 * do-while
 * standard for
 * enhanced for
 */

// while
let counter = 0;

while (counter < 5) {
    console.log(counter++);
}

// do-while
counter = 5;

do {
    console.log(counter++);
} while (counter < 5)

// standard for
// use let to declare the index variable, if you're using one
for (let i = 0; i < 5; i++) {
    console.log("abcde".charAt(i));
}

// enhanced for
let nums = [ 1, 2, 3, 4, 5 ];

// iterating through an array -- use "for (let <variable name> of <array name>)"
for (let num of nums) {
    console.log(num * 10);
}

// objects, however, are not iterable
const person = {
    name: 'Bertha Billgood',
    age: 99,
    occupation: 'Volunteer Shoe Saleswoman'
}

// can't do this, because person is not iterable
// for (let property of person) {
//     console.log(property);
// }

// instead, for object properties, use "for (let <variable name> in <object name>)"
// we can then use the keys as indices of a sort for getting values out of the object "array"
// regular array bracket notation works for this
for (let property in person) {
    console.log(`${property}: ${person[property]}`);
}