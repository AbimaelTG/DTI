import { Routes } from '@angular/router';
import { AppLayout } from '@/layout/components/app.layout';
import { Notfound } from '@/layout/notfound/notfound';
import { LoginGuard } from '@/shared/guards/login.guard';
import { ProdGuardService } from '@/shared/guards/prod-guard.service';

export const appRoutes: Routes = [
    {
        path: '',
        loadComponent: () =>
            import('@/pages/auth/login').then((m) => m.Login),
        canActivate: [LoginGuard],
    },
    {
        path: 'inicio',
        component: AppLayout,
        canActivate: [ProdGuardService],
        data: { expectedRol: ['admin'] },
        children: [
            {
                path: '',
                loadComponent: () => import('@/pages/home').then((c) => c.Index),
                data: { breadcrumb: 'Home Dashboard' }
            },
        ]
    },
    { path: 'notfound', component: Notfound },

    {
        path: 'error',
        loadComponent: () => import('@/layout/notfound/notfound').then((c) => c.Notfound)
    },

    {
    path: 'superior',
    component: AppLayout,
    canActivate: [ProdGuardService],
    data: { expectedRol: ['superior', 'admin'] }, // o los roles que correspondan
    children: [
        {
            path: 'tablero',
            loadComponent: () =>
                import('@/pages/auth/login').then((c) => c.Login),
            data: { breadcrumb: 'Tablero Superior' }
        }
    ]
},



    {
        path: '**', redirectTo: 'login'

    },

    

    {
        path: 'auth',
        children: [
            {
                path: 'login',
                loadComponent: () => import('@/pages/auth/login').then(m => m.Login),
                canActivate: [LoginGuard],
            },
            {
                path: 'register',
                loadComponent: () => import('@/pages/auth/register').then(m => m.Register),
            },

              {
            path: 'verification',
            loadComponent: () => import('@/pages/auth/verification').then(m => m.Verification),
             },

             {
                path: 'forgotpassword',
                loadComponent: ()=>
                    import('@/pages/auth/forgotpassword').then(m => m.ForgotPassword)
             },

            {
                path: '',
                redirectTo: 'login',
                pathMatch: 'full'
            }
        ]
    }


];
