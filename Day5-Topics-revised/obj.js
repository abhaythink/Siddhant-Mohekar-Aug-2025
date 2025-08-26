
let ship ={
    shipcountrycode : 1010,
    State: 'Mexico'
}

// console.log(ship['shipcountrycode']);
// console.log(ship.weight);

ship.country = 'USA';

console.log(ship);

delete ship.country;

console.log(ship);
