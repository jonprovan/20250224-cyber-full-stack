/**
 * ASYNCHRONOUS OPERATIONS IN JS
 * 
 * sync operations (regular code like we've been writing) will execute in top-down order
 * async operations move off onto the event loop
 * then, they process in the order they return when there's room in the stack (AFTER sync operations)
 * for event loop tasks of the same type, the order they come back is the order in which they are processed
 * Promise operations take precedence over non-promise operations
 * you'll get Promises back from any API calls, etc.
 */

// setTimeout executes a callback function after a "fixed" amount of time
// setTimeout(() => {
//     console.log("1-second timeout returned!");
// }, 1000);

// for (let i = 0; i < 10; i++)
//     console.log('Waiting...');

// for (let i = 0; i < 10000000000; i++) {
//     let x = (i * i / .333 + i * 33);
// }

// setInterval executes a callback function over and over after the specified interval FOREEEEEEVEER...
// setInterval(() => {
//     console.log("1-second interval...");
// }, 1000);

// if you wish to stop your interval, you have to store it in a variable and then use clearInterval
let myInterval = setInterval(() => {
    console.log("1-second interval...");
}, 1000);

setTimeout(() => {
    clearInterval(myInterval);
    console.log('Interval Cleared!!');
}, 5000);