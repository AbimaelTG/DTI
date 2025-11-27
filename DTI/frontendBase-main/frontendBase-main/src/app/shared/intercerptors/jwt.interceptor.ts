import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse,
  HTTP_INTERCEPTORS
} from '@angular/common/http';

import { Observable, throwError } from 'rxjs';

import { catchError, concatMap } from 'rxjs/operators';
import { TokenService } from '../service/auth/token.service';
import { AuthService } from '../service/auth/auth.service';
import { JwtDto } from '../model/dto/jwt-dto';



@Injectable({
  providedIn: 'root'
})
export class JwtInterceptor implements HttpInterceptor {

  constructor(private tokenService:TokenService , private auth:AuthService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if (!this.tokenService.isLogged()) {
        return next.handle(req);
    }

    let intReq = req;
    const token = this.tokenService.getToken();
    if (token) {
      intReq = this.addToken(req, token);
    }
    
    return next.handle(intReq).pipe(catchError((err: HttpErrorResponse) => {
      if (err.status === 401) {

        const dto: JwtDto = new JwtDto(this.tokenService.getToken()!);
        return this.auth.refresh(dto).pipe(concatMap( (data:any) => {
          console.log("refreshing ......");
          this.tokenService.setToken(data.token);
          intReq = this.addToken(req, data.token);
          return next.handle(intReq);
        }));
      }else{
        this.tokenService.logout();
        return throwError(err);
      }
    }));
  } 
  
  private addToken(req: HttpRequest<any>, token:string): HttpRequest<any>{
    return req.clone({headers: req.headers.set('Authorization', 'Bearer '+ token)});
  }
}

export const jwtInterceptor = [{provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true}];
