import { Component, OnInit, Inject } from '@angular/core';

import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'
import { Paciente } from '../../../domain/paciente';

@Component({
  selector: 'app-paciente-detalhe',
  templateUrl: './paciente-detalhe.component.html',
  styleUrls: ['./paciente-detalhe.component.css']
})
export class PacienteDetalheComponent implements OnInit {
  constructor(
    public dialogRef: MatDialogRef<PacienteDetalheComponent>,
    @Inject(MAT_DIALOG_DATA) public paciente: Paciente
  ) {}

  ngOnInit(): void {      
  }

  fechar(){
    this.dialogRef.close();
  }

}
