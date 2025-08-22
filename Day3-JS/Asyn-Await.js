
  function inOfficePromise(){
    return new Promise((resolve, reject) => {
    let inoffice = false;

    if(inoffice){
        resolve("in the office");
    }else{
        reject("not in office");
    }
 });
}

// inOfficePromise().then((msg) => {
//     console.log(msg);
// }).catch((error) => {
//     console.log(error);
// })

   async function checkInOffice() {
    try{
       const ino = await inOfficePromise();
       console.log(ino);
    }catch(error){
        console.error(error);
    }
       
}
checkInOffice();