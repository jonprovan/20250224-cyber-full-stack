/**
 * ARRAYS IN JS
 * 
 * we don't have other types of collections in JS, just arrays and objects
 * all the List-type collections are basically just arrays in JS
 * they have a number of built-in functions/methods from List-type collections
 * arrays are NOT of a fixed size
 */

let myArray = [ 1, 2, 3, 4, 5 ];

// not typed, so we can put in whatever we want
let myWildArray = [ 1, 'a', { name: 'Bill'}, [ 3, 4, 5 ], true, null, undefined ];

// bracket notation for retrieval/changing
console.log(myWildArray[3]);

myWildArray[3] = [ 6, 7, 8, 9, 10 ];

console.log(myWildArray[3]);

// can add/remove slots at will
let nums = [ 0, 1, 2, 3, 4 ];

console.log(nums);

// push adds an element to the end
nums.push(5);

console.log(nums);

// pop removes an element from the end
console.log(nums.pop());
console.log(nums);

// unshift adds an element to the beginning
nums.unshift(-1);
console.log(nums);

// shift removes one from the beginning
console.log(nums.shift());
console.log(nums);

// assigning an array to another variable just points the second variable to the same array
let nums2 = nums;
nums2[0] = 111;

console.log(nums2);
console.log(nums);

nums2[0] = 0;

// one way to copy some/all of an array is with slice
// with no parameters, it copies the whole thing
nums2 = nums.slice();

nums2[0] = 111;

console.log(nums2);
console.log(nums);

// to take part of an array, you can enter a start and end parameter
// if you just have a start, you'll get from there until the end
// if you have both, the first is inclusive, the second is exclusive
// so here, we WILL NOT get index 3
nums2 = nums.slice(0, 3);

console.log(nums2);

// to insert/remove elements at any spot in an array, use splice
// we can remove 0-any # of elements and simultaneously insert 0-any # of elements
nums = [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ];

// removing some
// the first parameter is the starting index to remove, the second is the number of elements to remove
nums.splice(3, 3);
console.log(nums);

// adding some
// first parameter is still the starting point, in this case for the insertion
// second parameter is still the number of elements to remove
// any remaining parameters will be inserted at that spot -- you can have as many as you like!
nums.splice(3, 0, 3, 4, 5);
console.log(nums);

// you can do both at the same time
nums.splice(3, 3, 'three', 'four', 'five', 'extra fun value');
console.log(nums);

// a fun little puzzle
// remove Nikash and move Liam and Dhruv to the spot where Nikash was in one statement?
let names = [ 'Dave', 'Liam', 'Dhruv', 'Muhiddin', 'Leah', 'Malykai', 'Nikash', 'Sebastian' ];

console.log(names);

names.splice(names.indexOf('Nikash') - 2, 1, ...names.splice(1, 2));

console.log(names);


// you can sort arrays as well
nums = [ 3, 8, -12, 44, 1001, -3456, 4.5 ];
console.log(nums);

// you insert your preferred sorting lambda in the parentheses
nums.sort((a, b) => a - b);

console.log(nums);

// useful for objects
const person1 = { name: 'Anne', age: 35 };
const person2 = { name: 'Manny', age: 74 };
const person3 = { name: 'Riff', age: 21 };

let people = [ person1, person2, person3 ];

const sortFunction = (p1, p2) => p1.age - p2.age;

console.log(people);
people.sort(sortFunction);
console.log(people);

// flipping the array order
people.reverse();
console.log(people);

// sort and reverse change the original array! so be sure to slice or destructure if you don't want to alter the original content
