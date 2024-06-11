import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditarPacienteComponent } from './paciente/editar-paciente/editar-paciente.component';
import { CadastrarListarPaciente } from './paciente/cadastrar-listar-paciente/cadastrar-listar-paciente';
import { CadastrarListarAtendimentoComponent } from './atendimento/cadastrar-listar-atendimento/cadastrar-listar-atendimento.component';


const routes: Routes = [
  { path: '', component: CadastrarListarPaciente }, 
  { path: 'editar-paciente/:id', component: EditarPacienteComponent },
  { path: 'criar-atendimento/:id', component: CadastrarListarAtendimentoComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
