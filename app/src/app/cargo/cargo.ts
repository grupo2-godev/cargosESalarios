import { CBO2002 } from 'src/app/model/cbo2002/cbo2002';
import { CBO1994 } from 'src/app/model/cbo1994/cbo1994';
import { HorasMes } from 'src/app/model/horasmes/horasmes';
import { GrauInstrucao } from 'src/app/model/grauinstrucao/grauinstrucao';


export interface Cargo {
    idCargo?: number;
    nomeCargo: String;
    dataCadastro: String;
    dataUltimaRevisao: String;
    cbo2002: CBO2002;
    cbo94: CBO1994;
    horasMes: HorasMes;
    grauInstrucao: GrauInstrucao;
    experienciaMinima: String;
    atribuicoes: String;
    status: boolean;
    idPermissao: number;
}