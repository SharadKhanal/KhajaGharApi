import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  apiUrlEndPoint:string='/user';
  baseUrl:string=environment.baseUrl;

  constructor(private httpClient:HttpClient) { }

  onRegisterUser(register:any):Observable<any>{
    return this.httpClient.post<any>(
      this.baseUrl.concat(this.apiUrlEndPoint),register
    );
  }

 
}
