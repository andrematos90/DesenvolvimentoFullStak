import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ListService } from 'src/app/services/list.service';

@Component({
  selector: 'app-delete-dialog',
  templateUrl: './delete-dialog.component.html',
  styleUrls: ['./delete-dialog.component.css']
})
export class DeleteDialogComponent implements OnInit {

  constructor(public dialog: MatDialog, private itemService : ListService) { }

  ngOnInit(): void {
  }

  async deleteActivity(itemId: number){
    await this.itemService.deleteActivity(itemId).subscribe();
  }

}
