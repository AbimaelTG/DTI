import { Model } from "src/app/utilities/model";

export class TcEstatus implements Model{
    id: number;
    descripcion: string; // Asume que TcEstatus tiene un campo de descripción
  
    constructor(id: number, descripcion: string) {
      this.id = id;
      this.descripcion = descripcion;
    }
  }