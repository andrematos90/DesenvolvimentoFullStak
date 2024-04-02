import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ListUpDateService {

  private listUpdatedSubject: BehaviorSubject<void> = new BehaviorSubject<any>(null);

  constructor() { }

  // Método para emitir a atualização da lista
  emitListUpdate(): void {
    this.listUpdatedSubject.next();
  }

  // Método para observar as atualizações da lista
  getListUpdate(): Observable<void> {
    return this.listUpdatedSubject.asObservable();
  }
}
