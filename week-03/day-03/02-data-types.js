/**
 * DATA TYPES IN JS
 * 
 * Though variables are loosely-typed in JS, we still have types, of course
 * 
 * Numerical Types
 * number -- can store whole or decimal numbers, positive or negative, all in one type! e.g., 1, -12, 123.456, 0.00001, etc.
 *        -- maxvalue = 1.7976931348623157e+308
 * bigint -- impractical for most purposes, but essentially has an unlimited cap, e.g. 1n, -12345n
 * 
 * Alphanumeric Types
 * string -- zero or more alphanumeric characters
 *        -- there is no 'char' type in JS
 *        -- strings are still arrays, though, so we can use those properties here
 *        -- single or double quotes are fine around strings
 * 
 * Other Types
 * boolean -- true/false (NOT 'true' or "false", but true or false (without quotes))
 * null -- technically object type, but has its own specifics
 * undefined -- a variable that has not been initialized, distinct from null
 * object -- any JS object or array is of object type
 * Symbol -- an object in memory with a specific key we can use to retrieve it [we will NOT use this!]
 */

console.log(typeof 555);
console.log(typeof 555n);
console.log(typeof 'abcde');
console.log(typeof false);
console.log(typeof null);
console.log(typeof undefined);
console.log(typeof [ 6, 6, 6 ]);
console.log(typeof { id: 3 });

// figure this one out...
console.log(typeof NaN);