/**
 * VARIABLES IN JAVASCRIPT
 * - variables are loosely-typed by default and can change value and type at will
 * 
 * 4 WAYS TO DECLARE A VARIABLE
 * <blank> -- global variable
 * var -- wherever declared in scope, the declaration is available EVERYWHERE
 *     -- can be redeclared in a different scope, but it's really the SAME VARIABLE AGAIN!
 * let -- scoped to wherever it's declared, whether that's the "main" thread, an if block, a method, etc.
 *     -- can ALSO be redeclared at a different scope, but it exists in isolation from the other one(s)
 * const -- once initialized, the value cannot be changed (can still change array values or object properties)
 * 
 * BOTTOM LINE => use let and const, don't use the others!!
 * ADDENDUM TO BOTTOM LINE => try to structure your variables to avoid redeclaring variables at different scopes with the same name
 */

// this prints undefined, because the declaration is "hoisted" for vars
// let and const are NOT hoisted
console.log(myVar);
console.log(abc);

var x = 1;
console.log(x);
x = true;
x = 'Hello';
x = [ 1, 2, 3 ];
console.log(x);
x = { name: "George" };

var z = 3;
var z = 4;
console.log(z);

if (true) {
    var z = 5;
    console.log(z);
}

console.log(z);

let a = 10;
console.log(a);

if (true) {
    let a = 11;
    console.log(a);
}

console.log(a);

// we printed this at the beginning -- the program knew the var existed, but not its value until here
// uninitialized variables return undefined
var myVar = 100;
console.log(myVar);

let myLet;
console.log(myLet);

if (true) {
    if (true) {
        if (true) {
            var abc = 'abc';
        }
    }
}

console.log(abc);

// working with const
const myConst = 11;
console.log(myConst);

// this will throw an error!
// myConst = 12;
// console.log(myConst);

// we can change/remove/add indices of an array
const myArray = [ 1, 2, 3, 4, 5 ];
console.log(myArray);
myArray.push(123);
console.log(myArray);

// BUT, we can't assign a new array to the variable!
// myArray = [ 5, 6, 7 ];

// same with objects
const myObject = { flavor: 'Salty' };
console.log(myObject);
myObject.flavor = 'sweet';
console.log(myObject);

// myObject = { type: 'Electric' };
