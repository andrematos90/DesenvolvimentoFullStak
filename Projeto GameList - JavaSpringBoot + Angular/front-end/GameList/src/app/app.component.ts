import { StateService } from './services/state.service';
import { Component, OnInit } from '@angular/core';
import { EventService } from './services/event.service';
import { StateKey } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  showModal: boolean = false;

  constructor(
    private eventService: EventService,
    private stateService: StateService) { }

  ngOnInit() {

    this.stateService.showModal$.subscribe((showModal: boolean) => {
      this.showModal = showModal;
    });


    this.eventService.toggleEvent$.subscribe(() => {
      this.Modaltoggle();

    });

  }

  Modaltoggle() {

    console.log("chegou no pai")
    this.stateService.setShowModal(!this.showModal);

  }

}
