import React from "react";
import './styles/style.css';


type Props = {
  form: { valorInicial: string; valorResidual: string; vidaUtil: string };
  handleChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
};

const DepreciacaoForm: React.FC<Props> = ({ form, handleChange }) => {
  return (
    <div className="space-y-4">
  <div>
    <input
      type="number"
      name="valorInicial"
      placeholder="Valor Inicial"
      value={form.valorInicial}
      onChange={handleChange}
      className="w-full p-2 mb-2 border rounded"
    />
  </div>
  <div>
    <input
      type="number"
      name="valorResidual"
      placeholder="Valor Residual"
      value={form.valorResidual}
      onChange={handleChange}
      className="w-full p-2 mb-2 border rounded"
    />
  </div>
  <div>
    <input
      type="number"
      name="vidaUtil"
      placeholder="Vida Útil (anos)"
      value={form.vidaUtil}
      onChange={handleChange}
      className="w-full p-2 mb-4 border rounded"
    />
  </div>
</div>
  );
};

export default DepreciacaoForm;
