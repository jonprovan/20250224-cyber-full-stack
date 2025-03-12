/**
 * CONTROL FLOW IN JS
 * 
 * we have all the same functionality from Java
 * if
 * else if
 * else
 * switch
 */

// if
if (3 < 4)
    console.log('Three is less than four');

// else
if (3 > 4)
    console.log('Three is greater than four');
else
    console.log('Three is not greater than four');

// else if
if (3 > 4)
    console.log('Three is greater than four');
else if (3 > 2)
    console.log('Three is greater than two');
else
    console.log('This is getting repetitive');

// switch
// unlike in Java, you CAN switch on a boolean
// but it's a lot of syntax for an if/else
// perhaps related to the fact that a variable EXPECTED to be a boolean may be null, undefined, or some other type
const moniker = 'Franz';

switch (moniker) {
    case 'Andy':
        console.log(1);
        break;
    case 'Franz':
        console.log(2);
        break;
    case 'Millie':
        console.log(3);
        break;
    default:
        console.log(0);           
}

/**
 * you can use break and continue in loops with the same functionality from Java
 */

let counter = 0;
while (counter < 5) {
    if (counter == 1) {
        counter++;
        continue;
    }
    if (counter == 4)
        break;
    console.log(counter++);
}