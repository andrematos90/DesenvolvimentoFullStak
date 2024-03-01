import { List } from 'src/app/interfaces/List';
import { ListService } from './../../services/list.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import {MatTable, MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  dataSource:List[]=[]
  displayedColumns: string[] = ['activity', 'description', 'deadLine', 'exceeded', 'completed', 'actions'];

  @ViewChild(MatTable) table!: MatTable<List>;

  constructor(private listService: ListService) { }

  ngOnInit(): void {
    this.listService.getList().subscribe(response =>{
      this.dataSource = response
    })
  }

  addTask(){}

}
