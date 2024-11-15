import { Component, Input, OnInit, Output,EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MomentService } from 'src/app/services/moment.service';





@Component({
  selector: 'app-moment-form',
  templateUrl: './moment-form.component.html',
  styleUrls: ['./moment-form.component.css']
})
export class MomentFormComponent implements OnInit {

  @Input() btnText!: string;
  image?: File;

  momentForm!: FormGroup;

  constructor(private momentService: MomentService) { }

  ngOnInit(): void {
    this.momentForm = new FormGroup({
      id: new FormControl(''),
      title: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      image: new FormControl(''),
    });
  }

  get title() {
    return this.momentForm.get('title')!;
  }

  get description() {
    return this.momentForm.get('description')!;
  }

  onFileSelected(event:any){

    const file: File = event.target.files[0]

    this.momentForm.patchValue({image:event.target.files[0]});
  }

  submit():void {
    
   console.log(this.momentForm.value)
   
    this.momentService.saveMoment(this.momentForm).subscribe(response =>{
      console.log('Momento salvo com sucesso', response);
    }, error =>{
      console.error('Erro ao salvar momento', error);
    })
   
  }

}
