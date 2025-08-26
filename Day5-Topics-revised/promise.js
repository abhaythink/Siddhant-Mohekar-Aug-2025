

// let prom = new Promise((resolve,reject)=>{
//     if(ture){
//         resolve("true");
//     }else{
//         reject("false");
//     }
// })

// Promise.reject("rejected means error occurred")
// .then(x => x+5)
// .then(x => console.log(x))
// .catch((error) => console.log(error));

Promise.resolve()
.then(() => {throw new Error('first then error catch')})
.catch(err => console.log("error msg :", err))
.then(() => {throw new Error('2nd then error catch')})
.catch(err => console.log("2nd error msg :" + err));
