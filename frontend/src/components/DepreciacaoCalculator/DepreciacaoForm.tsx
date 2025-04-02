import React, { useState } from "react";
import { calcularDepreciacao } from "../../service/depreciacaoService";
import { DepreciacaoResponse } from "../../types/depreciacaoTypes";
import ResultadoDepreciacao from "./ResultadoDepreciacao";

type Props = {
  form: { valorInicial: number; valorResidual: number; vidaUtil: number };
  handleChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
};

const DepreciacaoForm: React.FC<Props> = ({ form, handleChange }) => {
  const [error, setError] = useState<string | null>(null);
  const [resultado, setResultado] = useState<DepreciacaoResponse | null>(null);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);
    try {
      const response = await calcularDepreciacao(form);
      console.log("Resposta da API:", response);
      setResultado(response);
    } catch (error) {
      console.error("Erro ao calcular depreciação", error);
      setError("Falha ao conectar ao servidor.");
    }
  };

  return (
    <div className="wrap-calc">
      <form className="calc-form" onSubmit={handleSubmit}>
        <span className="calc-form-title"> Calcular Depreciação </span>
        <div className="wrap-input">
          <input
            name="valorInicial"
            onChange={handleChange}
            className="input"
          />
          <span className="focus-input" data-placeholder="Valor de Aquisição"></span>
        
        </div>
        <div className="wrap-input">
          <input
            name="vidaUtil"
            onChange={handleChange}
            className="input"
          />
          <span className="focus-input" data-placeholder="Vida Útil (anos)"></span>
        </div>
        
        <div className="container-calc-form-btn">
          <button type="submit" className="calc-form-btn">
            Calcular
          </button>
        </div>

        {error && <p className="text-red-500 mt-2">{error}</p>}
      </form>

      <div className="result">
      {resultado && (
          <div className="mt-4 p-2 border rounded">
            <p><strong>Resultado:</strong>
            {resultado && <ResultadoDepreciacao resultado={resultado} />}</p>
          </div>
        )}
      </div>
    </div>
  );
};

export default DepreciacaoForm;
