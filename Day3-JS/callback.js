

function check(name, callback){
   console.log("This side " + name);
   callback();
}

function inOffice(){
   console.log("In Office");
}

check("siddhant", inOffice)