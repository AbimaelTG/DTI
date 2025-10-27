import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { TokenService } from '../service/auth/token.service';


@Injectable({
  providedIn: 'root'
})
export class LoginGuard implements CanActivate {

  constructor(private tokenService: TokenService,
    private router: Router  ) { }

    canActivate( next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    
      if (this.tokenService.isLogged()) {
        this.router.navigate(['/inicio']);
        return false;
      }
      return true;
    }
  
}
