import axios from "axios";
import { DepreciacaoForm, DepreciacaoResponse } from "../types/depreciacaoTypes";

export const calcularDepreciacao = async (form: DepreciacaoForm): Promise<DepreciacaoResponse> => {
  try {
    const response = await axios.post<DepreciacaoResponse>("http://localhost:8080/depreciacao", form);
    return response.data;
  } catch (error) {
    console.error("Erro ao calcular depreciação", error);
    throw error;
  }
};
