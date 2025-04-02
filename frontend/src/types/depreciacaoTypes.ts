export type DepreciacaoForm = {
    valorInicial: number;
    valorResidual: number;
    vidaUtil: number;
  };
  
  export type DepreciacaoResponse = {
    [x: string]: any;
    depreciacaoAnual: number;
    valorFinal: number;
  };
  