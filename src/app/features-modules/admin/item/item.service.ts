import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  apiUrlEndPoint:string='/itemPost';
  baseUrl:string=environment.baseUrl;
  constructor( private httpClient:HttpClient) { }

  onAddItem(item:any):Observable<any>{
    return this.httpClient.post<any>(
      this.baseUrl.concat(this.apiUrlEndPoint),item
    )

  }

  listAllItems():Observable<any>{
    return this.httpClient.get<any>(this.baseUrl.concat(this.apiUrlEndPoint));

  }

  removeItem(id:number):Observable<any>{
    return this.httpClient.delete<any>(this.baseUrl.concat(this.apiUrlEndPoint+"/"+id))
  }

  getItemById(id:number):Observable<any>{
    return this .httpClient.get<any>(
      this.baseUrl.concat(this.apiUrlEndPoint+'/'+id)
    );
  }

  onEditItem(value:any,id:any):Observable<any>{
    return this.httpClient.put<any>(
      this.baseUrl.concat(this.apiUrlEndPoint+'/'+ id),value
    );
  }
}
