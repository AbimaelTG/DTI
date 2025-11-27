import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { TokenService } from '../service/auth/token.service';



@Injectable({
  providedIn: 'root'
})
export class ProdGuardService implements CanActivate{

  perfilReal: string;

  constructor(private tokenService: TokenService,
              private router: Router  ) {
                this.perfilReal='';
               }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean{
    const expectedRol = route.data['expectedRol'];
    const roles = this.tokenService.getRoles();

    roles.forEach((perfil: string) =>{
      if (perfil === 'ADMINISTRADOR') {
        this.perfilReal= 'admin';
      }
      
    })
   
    if (!this.tokenService.isLogged || expectedRol.indexOf(this.perfilReal) < 0) {
      this.router.navigate(['/login']);
      return false;
    }
    return true;
  }
}