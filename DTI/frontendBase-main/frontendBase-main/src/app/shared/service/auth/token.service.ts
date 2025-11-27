import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Base64 } from 'js-base64';

const TOKEN_KEY = 'AuthToken';


@Injectable({
  providedIn: 'root'
})
export class TokenService {

  roles:Array<string> = [];

  constructor(private router:Router) { }


  public setToken(token : string){
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(){
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public getRoles(){
    if (!this.isLogged()) {
      this.logout();
      return null;
    }
    const token = this.getToken();
    if (!token) {
      this.logout();
      return null;
    }
    const payload = token.split('.')[1];
    //console.log(Base64.decode(payload));
    const payloadDecoded = Base64.decode(payload);
    const values =JSON.parse(payloadDecoded);
    const roles = values.roles;

    return roles;
  }

  
 

  public isLogged(): boolean{
    
   if (this.getToken() != null) {
     return true;
   }
   return false;
  }

  public getNameUser(){
    if (!this.isLogged()) {
      this.logout();
      return null;
    }
    const token = this.getToken();
    if (!token) {
      this.logout();
      return null;
    }
    const payload = token.split('.')[1];
    const payloadDecoded = Base64.decode(payload);
    const values =JSON.parse(payloadDecoded);
    const nameUser = values.nombreUsuario;
    return nameUser;
  }

  //obtener id del usuario
  public getIdUser(){
    if (!this.isLogged()) {
      this.logout();
      return null;
    }
    const token = this.getToken();
    if (!token) {
      this.logout();
      return null;
    }
    const payload = token.split('.')[1];
    const payloadDecoded = Base64.decode(payload);
    const values =JSON.parse(payloadDecoded);
    const idUser = values.nId;

    return idUser;
  }

  //obtener  usuario
  public getUser(){
    if (!this.isLogged()) {
      this.logout();
      return null;
    }
    const token = this.getToken();
    if (!token) {
      this.logout();
      return null;
    }
    const payload = token.split('.')[1];
    const payloadDecoded = Base64.decode(payload);
    const values =JSON.parse(payloadDecoded);
    const user = values.sub;

    return user;
  }



  public logout(){
    window.sessionStorage.clear();
    this.router.navigate(['']);
  }

  

}
