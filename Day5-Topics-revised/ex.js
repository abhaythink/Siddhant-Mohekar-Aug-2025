export default class Hospital{
    constructor(name,address,NoOfPatient){
        this.name = name;
        this.address = address;
        this.NoOfPatient = NoOfPatient;
    }
}

export function giveNoOfPatinets(hos){
    console.log(hos.NoOfPatient);
}

export function giveAddressHospital(hos){
    console.log(hos.address);
}