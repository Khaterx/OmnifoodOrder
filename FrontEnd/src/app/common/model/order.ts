
export class Order {
    id: number;
    name: string;
    dataCreate: Date;
    dataUpdate: Date;
    description: string;
    image: string;
    price: number;


    constructor(id: number, name: string, dataCreate: Date, dataUpdate: Date, description: string, image: string, price: number) {
        this.id = id;
        this.name = name;
        this.dataCreate = dataCreate;
        this.dataUpdate = dataUpdate;
        this.description = description;
        this.image = image;
        this.price = price;
    }
}
