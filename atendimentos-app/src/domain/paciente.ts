export class Paciente{
    
    id: number;
    nome: string;
    cpf: string;
    idade: string;
    email: string;
    favorito: boolean = false;
    foto: any;

    constructor(id: number, nome: string, cpf: string, idade: string, email: string) {        
            this.id = id;            
            this.nome = nome;
            this.cpf = cpf;
            this.idade = idade;
            this.email = email;
    }    
} 