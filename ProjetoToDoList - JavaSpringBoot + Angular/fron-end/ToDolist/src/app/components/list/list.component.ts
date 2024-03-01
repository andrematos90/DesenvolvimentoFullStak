import { List } from 'src/app/interfaces/List';
import { ListService } from './../../services/list.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  dataSource:List[]=[]
  displayedColumns!:any

  constructor(private listService: ListService) { }

  ngOnInit(): void {
    this.listService.getList().subscribe(response =>{
      this.dataSource = response
    })
  }

  addTask(){}

}
