/**
 * FUNCTION OVERLOADING IN JS
 * 
 * overloading = defining a function several times with different input parameters
 * 
 * THERE IS NO FUNCTION OVERLOADING IN JS!!
 */

function print() {
    console.log('Print function with no parameters');
}

function print(name) {
    console.log(name);
}

// this calls our second function
// print('Mariella');
// this does NOT call our first function, because our second function overwrote it
// print();

// a function to add some numbers together
// parameters which are not supplied with a value have the value of undefined
// so here, we assign default values to the parameters
// if a user supplies a value, it will replace the default value
// if they don't, the default value applies
function addNums(x = 0, y = 0, z = 0) {
    console.log(x + y + z);
}

addNums(3, 7, 11);
addNums(3, 7);
addNums();

// calculating the area of a rectangle
// we can base parameter default values on previously-acquired parameter values
// here, we're "overloading" for both squares and rectangles that are not square
function area(length, width = length) {
    return length * width;
}

console.log(area(2, 4));
console.log(area(3));


function printName(first, middle = 'No Middle Name', last) {
    console.log(`First Name: ${first}, Middle Name: ${middle}, Last Name: ${last}`);
}

printName('Jimmy', 'Eat', 'World');
// we can "skip" a parameter by using undefined
// then the intake value is undefined, so the function uses the default value or does whatever the logic dictates
printName('Jon', undefined, 'Provan');

// what if we don't know how many parameters the user will enter?
// what if it could be hundreds, etc.?
// we can use the rest operator, which looks like this:   ...
// this takes all the "rest" of the parameters and stuffs them into an array
// it has to be last, and you can only have one per function
function printAll(a, b, ...c) {
    console.log(a, b, c);
}

// if the rest parameter is left blank, it still exists as an empty array
printAll();

printAll(4, 8, 2, 0, 3, 5);

// refactoring our add method using the rest operator
function addAnyAndAll(...nums) {
    let sum = 0;
    for (let num of nums)
        sum += num;
    console.log(sum);
}

addAnyAndAll(3, 10, 100);