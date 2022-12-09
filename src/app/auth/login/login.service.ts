import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  apiUrlEndPoint='/user/login'
  baseUrl:string=environment.baseUrl


  constructor(
    private httpClient:HttpClient
  ) { }

  onUserLogin(login:any):Observable<any>{{
    return this.httpClient.post<any>(
      this.baseUrl.concat(this.apiUrlEndPoint),login
    );
  }

  }
}
