// let p = new Promise((resolve, reject) => {
//     let num = 1 + 3;
//     if(num == 2){
//         resolve("success");
//     }else{
//         reject("failure");
//     }
// });
// p.then((message)=> {
//     console.log("promise is in then : " + message);
// }).catch((message) => {
//     console.log("promise is in catch : " + message);
// });

const ino = false;
const working = true;

// function inoffice(resolve, reject){
//     if(ino){
//        resolve("You are in office");
//     }else if(working){
//         resolve("You are working from home");
//     }else{
//         reject("You are not in office");
//     }
// }
// inoffice((messege) => {
//     console.log(messege);
// }, (error) => {
//     console.log(error);
// });

// function inofficeNew(){
//     return new Promise((resolve, reject) => {
//         if(ino){
//        resolve("You are in office");
//     }else if(working){
//         resolve("You are working from home");
//     }else{
//         reject("You are not in office");
//     }
//     })
// }
// inofficeNew().then((messege) => {
//     console.log(messege);
// }).catch((error) => {
//     console.log(error);
// });

let p1 = new Promise((resolve, reject)=>{
    resolve("promise 1");
})
let p2 = new Promise((resolve, reject)=>{
    resolve("promise 2");
})
let p3 = new Promise((resolve, reject)=>{
    resolve("promise 3");
})

// Promise.all([p1, p2, p3]).then((messeges)=> {
//     console.log(messeges);
// })

Promise.race([p1, p2, p3]).then((messege)=> {
    console.log(messege);
})

