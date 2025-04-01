import React from "react";
import { DepreciacaoResponse } from "../../types/depreciacaoTypes";


type Props = {
  resultado: DepreciacaoResponse;
};

const ResultadoDepreciacao: React.FC<Props> = ({ resultado }) => {
  return (
    <div className="mt-4 p-4 bg-gray-100 rounded">
      <p><strong>Depreciação Anual:</strong> R$ {resultado.depreciacaoAnual.toFixed(2)}</p>
      <p><strong>Valor Final:</strong> R$ {resultado.valorFinal.toFixed(2)}</p>
    </div>
  );
};

export default ResultadoDepreciacao;
