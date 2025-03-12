/**
 * FUNCTIONS IN JS
 * 
 * methods in Java = functions in JS
 * 
 * the general rules we're used to from Java apply here as well
 * however, there are some small differences we need to be aware of
 * 
 * the keyword to create a function is "function" in the standard version
 * we do not have to (and can't) declare a return type -- whatever it returns is the return type
 * parameters are untyped as well
 * 
 * functions are fully hoisted!!
 * 
 * functions are lightweight and can be thrown around pretty easily
 * as we'll see later, functions are the underlying structure for some things we wouldn't normally think of as functions...
 */

myFirstFunction();

// standard structure
function myFirstFunction() {
    console.log('This is my first function. Bully for me!');
}

myFirstFunction();

// with parameters, return type is whatever comes out!
function add(x, y) {
    return x + y;
}

console.log(add(1, 2));
console.log(add('abc', 'def'));
console.log(add(123, '456'));

// other ways to declare functions
// using a variable name to create the name of the function
const printName = function (name) {
    console.log(name);
}

printName('Oscar The Grouch');

// ditching the function keyword using lambda syntax
// same rules with parameter/return declaration in lambdas, same rules with single/multi line and braces, etc.
// only significant difference is that we use => rather than ->
const printTwoNames = (firstName, secondName) => console.log(firstName, ':', secondName);

printTwoNames('Sonic', 'Knuckles');

const whichOne = name => {
    return (name == 'Sam') ? 'Great' : 'Not So Great';
}

console.log(whichOne('Sam'));

// you can pass a function to another variable easily
const whichName = whichOne;
console.log(whichName('Maurice'));

const addition = add;
console.log(addition(5, 7));