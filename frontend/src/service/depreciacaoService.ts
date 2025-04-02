import axios from "axios";
import { DepreciacaoForm, DepreciacaoResponse } from "../types/depreciacaoTypes";

export const calcularDepreciacao = async (form: DepreciacaoForm): Promise<DepreciacaoResponse> => {
  try {
    const response = await axios.post<DepreciacaoResponse>("http://localhost:8080/depreciacao/calcular", form);
    return response.data;
  } catch (error: any) {
    console.error("Erro ao calcular depreciação", error);

    // Verifica se é um erro de resposta da API
    if (error.response) {
      throw new Error(error.response.data.message || "Erro ao calcular depreciação.");
    } else {
      throw new Error("Falha ao conectar ao servidor.");
    }
  }
};

