
export class Category {
    id: number;
    name: string;
    icons:string;
    dataCreate: Date;
    dataUpdate: Date;


  constructor(id: number, name: string, icons: string, dataCreate: Date, dataUpdate: Date) {
    this.id = id;
    this.name = name;
    this.icons = icons;
    this.dataCreate = dataCreate;
    this.dataUpdate = dataUpdate;
  }
}
