import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private toggleEventSource = new Subject<void>();

  toggleEvent$ = this.toggleEventSource.asObservable();
  showModal$ = this.toggleEventSource.asObservable();

  emitToggleEvent() {
    this.toggleEventSource.next();
  }




}
