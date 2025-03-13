/**
 * CONSTRUCTOR FUNCTIONS IN JS
 * 
 * objects in JS are, in fact, functions
 * we don't have traditional OOP functionality under the hood
 * but, it's much easier to think of objects as instances of classes
 * so there are some abstractions we can use in JS to enable this
 * here's what's happening under the hood...
 */

// a constructor function
function Exam(subject, numberOfQuestions, timeLimit) {
    this.subject = subject;
    this.numberOfQuestions = numberOfQuestions;
    this.timeLimit = timeLimit;
    this.start = function start() {
        console.log(`${this.timeLimit} minutes and counting...`);
    }
}

const myExam1 = new Exam('JavaScript', 30, 60);
const myExam2 = new Exam('Spring Boot', 45, 90);

myExam2.timeLimit = 125;

console.log(myExam1);
console.log(myExam2);

myExam1.start();
myExam2.start();

// inheritance
// this is MUCH more straightforward using class notation, which we'll do next
function Assessment() {}

Exam.prototype = Object.create(Assessment.prototype);
Exam.prototype.constructor = Exam;

const myExam3 = new Exam('MySQL', 10, 20);

console.log(myExam3.__proto__);