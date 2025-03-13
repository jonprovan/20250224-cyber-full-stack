/**
 * HIGHER-ORDER FUNCTIONS IN JS
 * 
 * a closure is a returned function that maintains some element of the original enclosing function's context
 * we'll illustrate this with a simple factory that can produce functions of various types
 */

// a function that multiplies a number by 10
function timesTen(x) {
    return x * 10;
}

console.log(timesTen(5));

// a factory function that returns various functions depending on how it's called
function timesSomething(something) {
    return x => x * something;
}

timesTen = timesSomething(10);

console.log(timesTen(7));

const timesFifteen = timesSomething(15);

console.log(timesFifteen(3));

// we have access to the various "Stream"-type operations for our arrays, and they function similarly
const nums = [ 1, 2, 123, 3, 4, 5 ];

// forEach
nums.forEach(element => {
    if (element < 3) return;
    console.log(element + 2);
});

// map
// this is no longer just an intermediate function and will return a usable array
// very useful for creating typed JS objects from backend responses
const numsAfterMap = nums.map(element => {
    // if we don't return anything, undefined is still added to the resulting array
    return element * 10;
});

console.log(numsAfterMap);

// filter
// also no longer intermediate and will also return a usable array
// you DO NOT return the element or a specific value, ONLY true/false -- true means the element goes in the result array, false means it doesn't
// careful! if you return a value, it will be evaluated for truthy/falsy and may not match what you expected!
const numsAfterFilter = nums.filter(element => {
    return element % 2 === 0;
});

console.log(numsAfterFilter);

// reduce
// same functionality we're used to, except...
// the initialValue (accumulator) comes as the SECOND parameter, not the first like in Java
// and we'll always get something, even if it's null/undefined, so we don't have an Optional if we don't include the accumulator
const reductionResult = nums.reduce((num1, num2) => {
    return (num1 < num2) ? num2 : num1;
}, 50);

console.log(reductionResult);

// you can chain these like before
const chainResult = nums.map(element => element * 10)
                        .filter(element => element > 30)
                        .reduce((e1, e2) => e1 < e2 ? e1 : e2);

console.log(chainResult);
