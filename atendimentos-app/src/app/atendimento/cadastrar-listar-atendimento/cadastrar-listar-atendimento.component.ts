import { Component, OnInit } from '@angular/core';
import { Atendimento } from '../../../domain/atendimento';
import { Paciente } from '../../../domain/paciente';

import { FormBuilder, FormGroup, Validators } from '@angular/forms'

import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { PacienteService } from 'src/service/paciente.service';
import { AtendimentoService } from 'src/service/atendimento.service';
import { MatDialog } from '@angular/material/dialog';
import { DetalhesAtendimentoComponent } from '../detalhes-atendimento/detalhes-atendimento.component';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-cadastrar-listar-atendimento',
  templateUrl: './cadastrar-listar-atendimento.component.html',
  styleUrls: ['./cadastrar-listar-atendimento.component.css']
})
export class CadastrarListarAtendimentoComponent implements OnInit {

  formulario: FormGroup = new FormGroup({});
  atendimentos: Atendimento[] = [];
  colunas = ['dataAtendimento', 'nomeProfissional', 'especialidadeEnum', 'retorno', 'ver']
  idPaciente: number = 0; 
  paciente: Paciente | undefined;   

  totalElementos = 0;
  pagina = 0;
  tamanho = 5;
  pageSizeOptions : number[] = [5]

  constructor(
    private service: AtendimentoService,
    private fb: FormBuilder,    
    private snackBar: MatSnackBar,
    private route: ActivatedRoute,
    private router: Router,
    private pacienteService: PacienteService,
    private dialog: MatDialog    
  ){}  

  ngOnInit(): void {    
    this.idPaciente = this.route.snapshot.params['id'];  
    this.montarFormulario();    
    this.listarAtendimentos(this.pagina, this.tamanho);    
    this.pacienteService.getPacienteById(this.idPaciente).subscribe((paciente: Paciente) => {
      this.paciente = paciente;
      console.log("Paciente: " + JSON.stringify(paciente));
    });
  }

  montarFormulario(){
    this.formulario = this.fb.group({      
      nomeProfissional: ['', Validators.required],
      especialidadeEnum: ['', Validators.required],
      registroAtendimento: ['', Validators.required],
      retorno: ['']           
    })
  } 

  listarAtendimentos(pagina: number = 0, tamanho: number = 5) {    
    this.service.list(pagina, tamanho).subscribe(response => {
      this.atendimentos = response.content;
      this.totalElementos = response.totalElements;
      this.pagina = response.number;      
    })
  }    

submit() {  
  const formValues = this.formulario.value;

  // Remova o campo 'id' de formValues se você não o estiver usando
  delete formValues.id;

  this.service.save(this.idPaciente, formValues).subscribe(
    (resposta: Atendimento) => {
      this.listarAtendimentos();
      this.snackBar.open('Atendimento adicionado!', 'Sucesso', {
        duration: 2000
      });
      this.formulario.reset();
      console.log("Atendimento adicionado: ", resposta);
    },
    error => {
      console.error("Erro ao adicionar Atendimento: ", error);
      this.snackBar.open('Erro ao adicionar o Atendimento!', 'Erro', {
        duration: 2000
      });
    }
  );
}

verDetalhes(atendimento: Atendimento) {
  this.dialog.open( DetalhesAtendimentoComponent, {   
    data: atendimento.registroAtendimento
  })
}

paginar(event: PageEvent){
  this.pagina = event.pageIndex;
  this.listarAtendimentos(this.pagina, this.tamanho)
}

cancelarEdicao() {    
  this.router.navigate(['/']);
}  

}
