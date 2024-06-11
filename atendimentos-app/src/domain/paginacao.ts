/*import { Paciente } from "./paciente";

export class PaginaContato {
    content: Paciente[] = [];
    totalElements: number = 0;
    size: number = 0;
    number: number = 0;

}*/

export class Pagina<T> {
    content: T[] = [];
    totalElements: number = 0;
    size: number = 0;
    number: number = 0;
}
