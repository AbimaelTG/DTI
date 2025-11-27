export class LoginUsuario {
    sUsuario:string;
    sPassword:string;

    constructor(correo: string, contrasena: string){
        this.sUsuario = correo;
        this.sPassword= contrasena;
    }
}
 