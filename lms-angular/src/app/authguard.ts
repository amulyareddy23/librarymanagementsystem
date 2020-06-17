import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {
    canActivate(route: ActivatedRouteSnapshot) {
        const expectedRoles = route.data.role;
        const loginInfo = JSON.parse(localStorage.getItem('userInfo'));
        let role;
        for (let index in expectedRoles) {
            if (expectedRoles[index] === loginInfo.userInfo.role) {
                role = expectedRoles[index];
            }
        }
        if (loginInfo && loginInfo.userInfo.role === role) {
            return true;
        } else {
            return false;
        }
    }
}