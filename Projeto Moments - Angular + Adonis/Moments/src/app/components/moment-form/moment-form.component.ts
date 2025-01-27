import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router'; // Certifique-se de importar o Router
import { MomentService } from 'src/app/services/moment.service';

@Component({
  selector: 'app-moment-form',
  templateUrl: './moment-form.component.html',
  styleUrls: ['./moment-form.component.css'],
})
export class MomentFormComponent implements OnInit {
  @Input() btnText!: string;
  image?: File;
  momentForm!: FormGroup;

  constructor(
    private momentService: MomentService,
    private router: Router // Injeção do serviço Router
  ) {}

  ngOnInit(): void {
    this.momentForm = new FormGroup({
      id: new FormControl(''),
      title: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      image: new FormControl(''),
    });
  }

  submit(): void {
    console.log(this.momentForm.value);

    const id = this.momentForm.get('id')?.value;
    const updateData = this.momentForm.value;

    this.momentService.updateMoment(id, updateData).subscribe({
      next: () => {
        console.log('Momento atualizado com sucesso!');
        this.router.navigate(['/']); // Navega para a página inicial
      },
      error: (err) => {
        console.error('Erro ao atualizar o momento:', err);
      },
    });
  }
}
