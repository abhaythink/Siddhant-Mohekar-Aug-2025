
let ship = {
    name: "titanic",
    getName: function (){
        console.log(this.name);
    }
}

ship.getName();

let name = 'AI102';

let ship1 = {
    name: "titanic",
    getName: () => {
        console.log(name);
    }
}

ship1.getName();
