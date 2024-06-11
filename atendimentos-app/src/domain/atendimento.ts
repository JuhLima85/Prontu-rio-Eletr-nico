export class Atendimento{
    id: number;
    dataAtendimento: string;
    nomeProfissional: string;
    especialidadeEnum: string;
    registroAtendimento: string;
    retorno: string;
    paciente_id: number;

    constructor(
        id: number,
        dataAtendimento: string,
        nomeProfissional: string,
        especialidadeEnum: string,
        registroAtendimento: string,
        retorno: string,
        paciente_id: number
    ) {
        this.id = id;
        this.dataAtendimento = dataAtendimento;
        this.nomeProfissional = nomeProfissional;
        this.especialidadeEnum = especialidadeEnum;
        this.registroAtendimento = registroAtendimento;
        this.retorno = retorno;
        this.paciente_id = paciente_id;
    }

}