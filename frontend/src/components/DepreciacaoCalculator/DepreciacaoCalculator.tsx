import { useState } from "react";
import DepreciacaoFormComponent from "./DepreciacaoForm";
import ResultadoDepreciacao from "./ResultadoDepreciacao";
import { calcularDepreciacao } from "../../service/depreciacaoService";
import { DepreciacaoForm, DepreciacaoResponse } from "../../types/depreciacaoTypes";

const DepreciacaoCalculator: React.FC = () => {
  const [form, setForm] = useState<DepreciacaoForm>({
    valorInicial: "",
    valorResidual: "",
    vidaUtil: ""
  });
  const [resultado, setResultado] = useState<DepreciacaoResponse | null>(null);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async () => {
    try {
      const response = await calcularDepreciacao(form);
      setResultado(response);
    } catch (error) {
      console.error("Erro ao calcular depreciação", error);
    }
  };

  return (
    <div className="p-6 max-w-lg mx-auto bg-white shadow-md rounded-xl">
      <h2 className="text-2xl font-bold mb-4">Calculadora de Depreciação</h2>
      <DepreciacaoFormComponent form={form} handleChange={handleChange} />
      <button
        onClick={handleSubmit}
        className="w-full bg-blue-500 text-white py-2 rounded hover:bg-blue-600"
      >
        Calcular
      </button>

      {resultado && <ResultadoDepreciacao resultado={resultado} />}
    </div>
  );
};

export default DepreciacaoCalculator;
