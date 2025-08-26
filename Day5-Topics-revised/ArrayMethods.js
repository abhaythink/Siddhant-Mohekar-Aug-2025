
let userarr = [
    {carname: "Swift", brand: "MS", price: 600000},
    {carname: "Polo", brand: "FW", price: 650000},
    {carname: "Dzire", brand: "MS", price: 800000},
    {carname: "Fortuner", brand: "Toyota", price: 6000000},
    {carname: "Creta", brand: "hundai", price: 1200000},
    {carname: "Enova", brand: "Toyota", price: 1900000},
    {carname: "i10", brand: "hundai", price: 650000}
]

// let farr = userarr.filter((el)=> {
//     return el.Price > 10000000;
// });

// console.log(farr);

// let marr = userarr.map((el)=>{
//      return el.Carname;
// });
// console.log(marr);

// userarr.forEach((el)=>{
//     el.price = el.price - (el.price/10);
// })

// console.log(userarr);

// const car = userarr.find((el)=>{
//     return el.brand === 'Toyota';
// })
// console.log(car);

// const isCarofToyotaA = userarr.some((cr) =>{
//     return cr.brand === 'Toyota';
// }) 
// console.log(isCarofToyotaA);

// const checkp = userarr.every((el) =>{
//     return el.price < 10000000;
// })

// console.log(checkp);

// const scar = userarr.reduce((worth, el) => {
//     return el.price + worth;
// },0);

// console.log(scar);

// let comp = ['OnePlus','Apple','VIVO',"OPPO"];

// const iscarA = comp.includes('Realme');
// console.log(iscarA);


let numarr = [1,58,99,3,4,7];

console.log(numarr.splice(3,2));
console.log(numarr);
// console.log(numarr.slice(1,3));