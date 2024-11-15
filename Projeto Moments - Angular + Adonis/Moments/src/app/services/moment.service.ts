import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environment/environment';

@Injectable({
  providedIn: 'root'
})
export class MomentService {

  private baseApiUrl = environment.baseApiUrl;
  private apiUrl = `${this.baseApiUrl}api/moments`

  constructor(private http: HttpClient) { }

  saveMoment(moment:FormGroup):Observable<any>{
    console.log("chegou")
    const formData = new FormData();
    formData.append('title', moment.get('title')?.value);
    formData.append('description', moment.get('description')?.value);
    formData.append('image', moment.get('image')?.value);

    return this.http.post(this.apiUrl, formData);
  }
}
