import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { MatToolbarModule} from '@angular/material/toolbar';
import {MatInputModule } from '@angular/material/input';
import { MatButtonModule} from '@angular/material/button';
import { MatTabsModule } from '@angular/material/tabs';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule} from '@angular/material/dialog'
import { MatPaginatorModule} from '@angular/material/paginator';
import { MatSnackBarModule} from '@angular/material/snack-bar';
import { MatSelectModule } from '@angular/material/select';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CadastrarListarPaciente } from './paciente/cadastrar-listar-paciente/cadastrar-listar-paciente';
import { PacienteService } from '../service/paciente.service';
import { PacienteDetalheComponent } from './paciente/paciente-detalhe/paciente-detalhe.component';
import { EditarPacienteComponent } from './paciente/editar-paciente/editar-paciente.component';
import { CadastrarListarAtendimentoComponent } from './atendimento/cadastrar-listar-atendimento/cadastrar-listar-atendimento.component';
import { EditarAtendimentoComponent } from './atendimento/editar-atendimento/editar-atendimento.component';
import { DetalhesAtendimentoComponent } from './atendimento/detalhes-atendimento/detalhes-atendimento.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastrarListarPaciente,
    PacienteDetalheComponent,
    EditarPacienteComponent,
    CadastrarListarAtendimentoComponent,
    EditarAtendimentoComponent,
    DetalhesAtendimentoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatInputModule,
    MatButtonModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatTabsModule,
    MatTableModule,
    MatIconModule,
    MatCardModule,
    MatDialogModule,
    MatPaginatorModule,
    MatSnackBarModule,
    MatSelectModule,
    BrowserAnimationsModule
  ],
  providers: [
    PacienteService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
