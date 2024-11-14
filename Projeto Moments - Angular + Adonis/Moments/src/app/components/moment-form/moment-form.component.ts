import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';



@Component({
  selector: 'app-moment-form',
  templateUrl: './moment-form.component.html',
  styleUrls: ['./moment-form.component.css']
})
export class MomentFormComponent implements OnInit{

 @Input() btnText!: String;

 momentForm!: FormGroup;

 constructor(){}

 ngOnInit(): void {
     this.momentForm = new FormGroup({
      id: new FormControl(''),
      title: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      image: new FormControl(''),
     });
 }

 get title(){
  return this.momentForm.get('title');
 }

 get description(){
  return this.momentForm.get('description');
 }

 get image(){
  return this.momentForm.get('image');
 }

 submit(){
  console.log("enviou formulário")
 }

}
