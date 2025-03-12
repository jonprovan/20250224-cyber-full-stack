/**
 * OBJECTS IN JS
 * 
 * objects are much lighter-weight than in Java, since we're not actually object-oriented in JS
 * technically, under the hood, objects are functions
 * they're much more flexible than Java objects
 * we can add/remove properties at will
 * we can control what is allowed to be done with properties
 * ultimately, we can think of them as groups of key-value pairs
 * 
 * we'll get later to where we abstract these objects behind "classes"
 */

let myObject = {
    propertyOne: 34,
    propertyTwo: 'String Value',
    propertyThree: [ 3, 8, 4 ],
    propertyFour: () => console.log('Prop 4 Function')
}

console.log(myObject);

// retrieve values by dot notation
console.log(myObject.propertyOne);

// set values similarly
myObject.propertyOne = 80;
console.log(myObject.propertyOne);

// call property functions the same way
myObject.propertyFour();

// overwrite methods
myObject.propertyFour = () => console.log('New Functionality');
myObject.propertyFour();

// adding a new property
console.log(myObject);
myObject.propertyFive = { subObjectName: 'Larry' };
console.log(myObject);

console.log(myObject.propertyFive.subObjectName);
console.log(myObject.propertyThree[1]);

// removing a property
delete myObject.propertyFive;

console.log(myObject);
// optional chaining operator
// if we tried without the ? to get subObjectName, we'd throw an error, because propertyFive is gone
// similar to a NullPointerException
// with the ?, if the property is null/undefined, it'll just return undefined and not crash
console.log(myObject.propertyFive?.subObjectName);

// object equality
const o1 = { type: 'Vegetable', price: 12.99 };
const o2 = { type: 'Vegetable', price: 12.99 };

// we REALLY want this to work, but it doesn't
console.log(o1 == o2);

// there's no built-in way for checking object equality
// in a class, you can add a .equals() function or something
// outside of that, you just have to write your own
function equalityCheck(one, two) {

    // checking if they have the same number of properties
    if (Object.keys(one).length !== Object.keys(two).length)
        return false;

    // if they do, checking if the property values are equal
    // if they have the same number of props but different keys, at least one will return false
    for (let prop in one) {
        if (one[prop] !== two[prop])
            return false;
    }

    // otherwise, they're equal!
    return true;
}

console.log(equalityCheck(o1, o2));