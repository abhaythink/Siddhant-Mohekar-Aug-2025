

// class company{
//     constructor(cname){
//         this.cname = cname;
//     }


//     printname(){
//         setTimeout(() => {
//             console.log("our compant name from arrow "+this.cname);
//         },100);
//     }

//     printname2(){
//         setTimeout(function () {
//             console.log("our company name from normal function "+ this.cname);
//         })
//     }
// }

// let com = new company('Asus');
// com.printname2();
// com.printname();



// let ships = () => ({
//     name:"Titanic",
//     weight: 20000
// });

// console.log(ships());

// let muti = n => n*n;

// console.log(muti(5));

// setTimeout((n=6)=>{
//     console.log(n);
// },500)

let obj = {
    name:"Titanic",
    weight: 20000,
    countrycode: 125,
    getcode: function (){
        console.log(this.countrycode);
    }
}

obj.getcode();