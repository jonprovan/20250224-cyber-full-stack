// single-line comment
/**
 * multi-line comment
 * 
 * JAVASCRIPT BASICS
 * 
 * single-threaded -- not optional
 * NOT actually object-oriented -- there are some simulations of OOP, but it's not real
 * in many ways, it's NOT like Java, but there are also many things brought in from Java and other OOP languages
 * loosely-typed -- variables can change type/content
 * booleans are a bit odd in JS
 * 
 * Famously created by Brandon Eich in 10 days
 * - working at Netscape at the time
 * - needed a standard browser scripting language (primary purpose)
 * - runs in the browser
 * 
 * ECMAScript conferences meet every so often to add new features/standardizations to the language
 * every new feature is "transpilable" back to the original version
 * 
 * Node.js -- a JS runtime
 * - it fuels SPA servers for React, Angular, Vue.js
 * - we also use it to run our JS code in the console
 * 
 * TONS of libraries available to import/use, etc.
 * 
 * The JS Event Loop
 * asynchronous events are kicked to the side into the Event Loop
 * when they return, they are executed
 * BUT, they cannot be executed until the synchronous code is run
 * so, we have to be careful about managing timing for things like API calls, timeouts, intervals, etc.
 * 
 * JS is NOT compiled -- it's a scripting language
 * so, it runs as it's being read, generally from top to bottom
 * HOWEVER, certain things get "hoisted" and can be accessed from anywhere
 * 
 * 
 */

// to print
console.log("Hello from JS World!");

// just like in Java, whitespace doesn't matter
// semicolons are OPTIONAL if you have one statement per line
// if you have multiple statements per line, a semicolon is required for all but the last
console.log("Zero")
console.log("One"); console.log("Two")

// for strings, unlike in Java, single- OR double-quotes are fine
console.log('Three');