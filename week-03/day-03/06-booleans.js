/**
 * BOOLEANS AND EQUALITY IN JS
 * 
 * much of this works the same as in Java
 * but, we have some issues around type
 * 
 * we still have: < > <= >=
 * we now have: === !==
 * 
 * we also still have: && & || |
 * there are some fun shortcuts for these
 */

let tasty = false;

console.log(tasty);

console.log(3 == 3);
console.log('abc' == 'abcd');

console.log(2 == '2');

console.log(2 == '2' && typeof 2 == typeof '2');

// the strict equality operator
// this is equivalent to the line above
console.log(2 === '2');

// strict inequality
console.log(2 !== '2');

// some weird behavior to consider...
if (3 > 2)
    console.log('3 is greater than 2');

if ('false')
    console.log('Yes, it is true');

const myFunc = () => {};

if (myFunc) {
    console.log('Even a function!');
}

/**
 * TRUTHY AND FALSY
 * 
 * Falsy Values:
 * false (boolean)
 * null
 * undefined
 * NaN
 * 0
 * 0.0
 * 0n
 * -0
 * '' or ""
 * !(anything that's true)
 * 
 * Truthy Values:
 * anything that's not falsy
 * empty objects and arrays {} []
 * basically ANY object, array, or Symbol
 */

// because of truthy/falsy, we can shorthand the assignment of variable values based on their "boolean status"
// longform
let first = '';
let second = 'Second';
let result;

// if first is truthy, assign first to result, otherwise, assign second to result
if (first)
    result = first;
else
    result = second;

// same as above
result = first ? first : second;

// the most shorthand way
// if value 1 is truthy, assign that, otherwise assign value 2
result = first || second;

console.log(result);

// problem, however if the first value is valid but falsy
let middleName = '' || 'No middle name entered';

console.log(middleName);

// the Nullish Coalescing Operator
// this returns the first value as long as it is not specfically null or undefined
// it CAN be falsy
let myNumber = 0;
let jerseyNumber = myNumber ?? 99;
console.log(jerseyNumber);