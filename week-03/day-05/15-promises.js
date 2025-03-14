/**
 * PROMISES IN JS
 * 
 * Promises are what get returned from async operations like API calls
 * they are placed in the event loop and take precedence over things like timeouts, intervals, etc.
 * A Promise represents the eventual success/failure of that async operation
 * If it's successful, it'll contain the data you requested
 * If it isn't, it may contain nothing, an error response, etc.
 * When handling promises, we attach handler methods for successful/failed responses
 * 
 */

// manually creating a Promise
let myPromise = new Promise((resolve, reject) => {
    let randomResult = Math.random();

    if (randomResult < 0.5)
        resolve('Random number was < 0.5 -- SUCCESS!');
    else
        reject('Random number was > 0.5 -- FAILURE!');
});

// unpacking our Promise
// .then processes a fulfilled Promise/successful response
// .catch processes a rejected Promise/failed response
// .finally executes afterward either way
myPromise.then(data => console.log(data))
         .catch(error => console.log(error))
         .finally(() => console.log('Promise resolved, for better or for worse.'));

// the fetch API
// this is a lightweight JS API for making calls to other servers
// fetch('https://reqres.in/api/users', {
//     method: 'GET'
// }).then(response => {
//     console.log(response.status, response.statusText);
//     return response.json();
// }).then(json => json.data.forEach(element => {
//     console.log(element.email);
// }));

// this will happen first unless we pack it into the async pipeline properly
// console.log('******** WE WANT THIS TO HAPPEN AFTER THE ASYNC CALLS ********');

// inside an async function, we can use await
// await will wait for the async operation it's applied to to finish before moving on to subsequent sync code
async function getUsers() {
    await fetch('https://reqres.in/api/users', {
            method: 'GET'
        }).then(response => {
            console.log(response.status, response.statusText);
            return response.json();
        }).then(json => json.data.forEach(element => {
            console.log(element.email);
        }));
    console.log('***** NOW WE HAVE AWAITED AND THIS SHOULD EXECUTE AS INTENDED *****');
}

getUsers();