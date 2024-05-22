import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Paciente } from '../../../domain/paciente';
import { PacienteService } from '../../../service/paciente.service';

@Component({
  selector: 'app-editar-paciente',
  templateUrl: './editar-paciente.component.html',
  styleUrls: ['./editar-paciente.component.css']
})
export class EditarPacienteComponent implements OnInit {

  pacienteForm: FormGroup = new FormGroup({}); 
  paciente: Paciente | null = null;  
  id: number = 0; 

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder,    
    private service: PacienteService
  ) { }

  ngOnInit(): void {   
    this.id = this.route.snapshot.params['id'];    
    this.carregarDetalhesPaciente();
    this.inicializarFormulario();
  }
  
  carregarDetalhesPaciente() {
    this.service.getContatoById(this.id).subscribe((paciente: Paciente) => {
      this.paciente = paciente;
      this.atualizarFormulario();
    });
  }

  inicializarFormulario() {
    this.pacienteForm = this.fb.group({
      nome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  atualizarFormulario() {
    this.pacienteForm.patchValue({
      nome: this.paciente!.nome,
      email: this.paciente!.email
    });
  }
  
  salvarAlteracoes() {    
    const formValues = this.pacienteForm.value
    const paciente = new Paciente( 
      this.id, 
      formValues.nome,
      formValues.cpf,
      formValues.idade, 
      formValues.email) 
    this.service.updatePaciente(paciente).subscribe(() => {      
      this.router.navigate(['/']);
    });
  }

  cancelarEdicao() {    
    this.router.navigate(['/']);
  } 

}
