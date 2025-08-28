

let arr = [1,5,9,7,5,3];
let objarr = [
    {name: "AI106",type: "domatic"},
    {name: "QA806",type: "International"}
]
// for(let an of arr.entries()){
//     console.log(an);
// }

let nums = [8,9,10];

// let a = [...nums, ...arr];
// console.log(a);

let ca = nums.slice();
console.log(ca);

let ro = (...n) =>{
    return n;
}

// console.log(ro(5,8,9,7,3,8,9,6,3,21,3));

let [{name: n1,type: n2},{name:n3, type: n4}] = objarr;

console.log(n1);

let [a1,a2] = objarr;

function show({name , type}){
    console.log(name,type);
}
show(a1);


let [x, ...rem] = arr;

console.log(x,rem);
