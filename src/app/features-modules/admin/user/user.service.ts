import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  apiUrlEndPoint:string='/user';
  baseUrl:string=environment.baseUrl

  constructor(
    private httpClient:HttpClient
  ) { }

  
  listAllUsers():Observable<any>{
    return this.httpClient.get<any>(this.baseUrl.concat(this.apiUrlEndPoint))
  }

  removeUser(id:number):Observable<any>{
    return this.httpClient.delete<any>(this.baseUrl.concat(this.apiUrlEndPoint+"/delete/"+id))
  }
}
