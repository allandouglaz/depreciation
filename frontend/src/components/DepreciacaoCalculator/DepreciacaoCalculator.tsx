import { useState } from "react";
import DepreciacaoFormComponent from "./DepreciacaoForm";
import { DepreciacaoForm, DepreciacaoResponse } from "../../types/depreciacaoTypes";

const DepreciacaoCalculator: React.FC = () => {
  const [form, setForm] = useState<DepreciacaoForm>({
    valorInicial: 0,
    valorResidual: 0,
    vidaUtil: 0
  });
  const [resultado, setResultado] = useState<DepreciacaoResponse | null>(null);
  const [error, setError] = useState<string | null>(null);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm({ ...form, [e.target.name]: Number(e.target.value) });
  };


  return (
    <div className="container-calc">
      <DepreciacaoFormComponent form={form} handleChange={handleChange} />

      {error && <p className="text-red-500 mt-2">{error}</p>}

      </div>
    
  );
};

export default DepreciacaoCalculator;
