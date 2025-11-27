import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginUsuario } from '../../../model/login-usuario';
import { JwtDto } from '../../../model/dto/jwt-dto';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  public login (loginUsuario: LoginUsuario){
  console.log('login en service', loginUsuario);

  const body = {
    correo: loginUsuario.sUsuario,
    contrasena: loginUsuario.sPassword
  };

  return this.http.post<JwtDto>(
    environment.servicios.api.concat(Endpoint.login),
    body
  );
}

  
  public refresh (jwtDto: JwtDto){
    return this.http.post<JwtDto>(environment.servicios.api.concat(Endpoint.refresh), jwtDto);
  }

  
}

const enum Endpoint{

  login = 'auth/login',
  refresh= 'auth/refresh',
  

}
