import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditarPacienteComponent } from './paciente/editar-paciente/editar-paciente.component';
import { CadastrarListarPaciente } from './paciente/cadastrar-listar-paciente/cadastrar-listar-paciente';

const routes: Routes = [
  { path: '', component: CadastrarListarPaciente }, 
  { path: 'editar-paciente/:id', component: EditarPacienteComponent } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
