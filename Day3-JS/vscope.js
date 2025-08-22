// var a =10;

// function printVar(){
//     let a = 20;
//     console.log(a);
// }

// console.log(a);

// printVar();

// 'use strict'
function leak(){
    num = 10
    console.log(num);
 }
leak();