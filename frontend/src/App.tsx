import React from 'react';
import './styles/style.css';
import DepreciacaoCalculator from './components/DepreciacaoCalculator/DepreciacaoCalculator';

const App: React.FC = () => {
  return (
    <div className="App">
      <h1 className="text-center text-3xl font-bold my-6">Calculadora de Depreciação</h1>
      <DepreciacaoCalculator />
    </div>
  );
};

export default App;
