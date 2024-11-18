import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environment/environment';

@Injectable({
  providedIn: 'root'
})
export class MomentService {

  //url da API
  private baseApiUrl = environment.baseApiUrl;
  private apiUrl = `${this.baseApiUrl}api/moments`

  constructor(private http: HttpClient) { }

  //salva momento
  saveMoment(moment:FormGroup):Observable<any>{
    console.log("chegou")
    const formData = new FormData();
    formData.append('title', moment.get('title')?.value);
    formData.append('description', moment.get('description')?.value);
    formData.append('image', moment.get('image')?.value);

    return this.http.post(this.apiUrl, formData);
  }

  //recupera momento para ser exibido no componente
  getMoments():Observable<any[]>{
    return this.http.get<any[]>(this.apiUrl);
  }
}
