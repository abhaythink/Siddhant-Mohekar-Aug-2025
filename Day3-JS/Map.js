let Ravish = {name: "Ravish Gaikwad"},
    Aryan = {name: "Aryan Gaikwad"},
    Siddhant = {name: "Siddhant Mohekar"};

let degree = new Map();
   degree.set(Ravish, "BCA");
   degree.set(Aryan, "BSC");
   degree.set(Siddhant, "BTech");

//    console.log(degree.get(Siddhant))

for(const usr of degree.keys()){
    console.log("Name: " +usr.name + " Degree: "+degree.get(usr));
}

for(const val of degree.values()){
    console.log("Degree: " + val);
}
degree.delete(Siddhant);


for(const usr of degree.entries()){
    console.log(`${usr[0].name}` + " " + `${usr[1]}`);
}


