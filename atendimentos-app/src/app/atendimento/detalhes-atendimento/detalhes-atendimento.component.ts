import { Component, EventEmitter, Output } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Inject } from '@angular/core';
import { Atendimento } from 'src/domain/atendimento';


@Component({
  selector: 'app-detalhes-atendimento',
  templateUrl: './detalhes-atendimento.component.html',
  styleUrls: ['./detalhes-atendimento.component.css']
})
export class DetalhesAtendimentoComponent {

  constructor(
    public dialogRef: MatDialogRef<DetalhesAtendimentoComponent>,
    @Inject(MAT_DIALOG_DATA) public historico: Atendimento
    ) {}  

    fechar(){
      this.dialogRef.close();
    }

}
