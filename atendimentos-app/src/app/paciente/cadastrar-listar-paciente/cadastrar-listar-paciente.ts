import { Component, OnInit } from '@angular/core';
import { Paciente } from '../../../domain/paciente';
import { PacienteService } from '../../../service/paciente.service';

import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { MatDialog } from '@angular/material/dialog';

import { PacienteDetalheComponent } from '../paciente-detalhe/paciente-detalhe.component';
import { PageEvent } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';


@Component({
  selector: 'app-cadastrar-listar-paciente',
  templateUrl: './cadastrar-listar-paciente.html',
  styleUrls: ['./cadastrar-listar-paciente.css']
})

export class CadastrarListarPaciente implements OnInit{  
  
  formulario: FormGroup = new FormGroup({});
  pacientes: Paciente[] = [];
  colunas = ['id','foto', 'nome', 'cpf', 'idade', 'email', 'atendimento', 'excluir', 'editar']
  imagem: string | ArrayBuffer | null = null;

  totalElementos = 0;
  pagina = 0;
  tamanho = 5;
  pageSizeOptions : number[] = [5]

  constructor(
    private service: PacienteService,
    private fb: FormBuilder,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    private router: Router
    
  ){}

  ngOnInit(): void {    
    this.montarFormulario();
    this.listarPacientes(this.pagina, this.tamanho);
  }

  montarFormulario(){
    this.formulario = this.fb.group({
      nome: ['', Validators.required],
      cpf: ['', Validators.required], 
      idade: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    })
  } 

  listarPacientes(pagina: number = 0, tamanho: number = 5){
    this.service.list(pagina, tamanho).subscribe(response => {
      this.pacientes = response.content;
      this.totalElementos = response.totalElements;
      this.pagina = response.number;
    })
  }

  favoritar(paciente: Paciente){
    this.service.favourite(paciente).subscribe(response => {
      paciente.favorito = !paciente.favorito;
    })
  }

  submit(){
    const formValues = this.formulario.value
    const paciente = new Paciente(formValues.id, formValues.nome, formValues.cpf, formValues.idade, formValues.email)
    this.service.save(paciente).subscribe( resposta => {
      this.listarPacientes()       
       this.snackBar.open('O Paciente foi registrado!', 'Sucesso', {
        duration: 2000
       })   
       this.formulario.reset(); 
      })
  }

  uploadFoto(event: Event, paciente: Paciente){
    const files = (event.target as HTMLInputElement).files; 
    if(files && files.length > 0){     
      const foto = files[0];      
      const formData: FormData = new FormData();
      formData.append("foto", foto);
      this.service
        .upload(paciente, formData)
        .subscribe(response => this.listarPacientes(this.pagina, this.tamanho));
    }
  }  

  vizualizarPaciente(paciente: Paciente) {
    this.dialog.open( PacienteDetalheComponent, {
      width: '500px',
      height: '550px',
      data: paciente
    })
  }

  paginar(event: PageEvent){
    this.pagina = event.pageIndex;
    this.listarPacientes(this.pagina, this.tamanho)
  }
  
  excluirPaciente(paciente: Paciente) {
    this.service.delete(paciente).subscribe(() => {      
      this.listarPacientes(this.pagina, this.tamanho);     
      this.snackBar.open('Paciente excluído!', 'Sucesso', {
        duration: 2000
      });
    }, error => {      
      this.snackBar.open('Erro ao excluir Paciente!', 'Erro', {
        duration: 2000
      });
    });
  }
  
  editarPaciente(paciente: Paciente) {        
    this.router.navigate(['/editar-paciente', paciente.id]);
  }

  criarAtendimento(paciente: Paciente){
    this.router.navigate(['/criar-atendimento', paciente.id]);
  }

}
