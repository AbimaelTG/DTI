
import { Model } from "@/lib/model";
import { TcEstatus } from "./TcEstatus";

export class TwCliente implements Model {
    id!: number;
    nombre?: string;
    telefono?: string;
    direccion?: string;
    email?: string;
    fechaRegistro?: string;
    idEstatus?:number; // Representado como string para facilitar el manejo del formato
    estatus?: TcEstatus; // Relación con TcEstatus
  
    
  }