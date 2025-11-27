import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginUsuario } from '../../../model/login-usuario';
import { JwtDto } from '../../../model/dto/jwt-dto';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

    private API_URL = 'http://localhost:4043/api/auth'; // <-- Ajusta a tu backend


  constructor(private http: HttpClient) { }

  sendVerificationCode(correo: string): Observable<any> {
    return this.http.post(`${this.API_URL}/forgot-password`, { correo });
  }

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
