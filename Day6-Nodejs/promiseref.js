
let p = new Promise((resolve,rejects) => {
    setTimeout(()=>{
        console.log("with 2 sec timer starts")
        resolve()
    },2000);
})

// p.then(()=>{
//     let a = 10;
//     while(a != 5){
//         setTimeout(()=>{
//              console.log(a);
//              a--;
//         },1000)
       
//     }
//     return a;
// }).then(a => {
//     console.log("Last 5 sec");
//     while(a != 0){
//         setTimeout(()=>{
//              console.log(a);
//              a--;
//         },1000)
//     }
//     console.log("it just a 0");
// })
