"use strict";
// URL da API que você deseja acessar
const apiUrl = 'http://localhost:8080/cars';
// Função para fazer a requisição GET
async function carregaCarros() {
    try {
        const response = await fetch(apiUrl);
        // Verifica se a resposta foi bem-sucedida (código de status 200)
        if (response.ok) {
            const database = await response.json();
            console.log('Dados da resposta:', database);
            const container = document.querySelector('.container');
            // Crie a tabela com cabeçalhos das colunas
            const tablehtml = `
        <table>
          <tr>
            <th>Modelo</th>
            <th>Montadora</th>
            <th>Ano</th>
            <th>Tipo de Combustível</th>
            <th>0 a 100km/h</th>
            <th>Importado</th>
          </tr>
          ${database.map(carro => `
            <tr>
              <td>${carro.modelCar}</td>
              <td>${carro.brandCar}</td>
              <td>${carro.modelYear}</td>
              <td>${carro.fuelType}</td>
              <td>${carro.zeroToHundred}</td>
              <td>${carro.imported}</td>
            </tr>
          `).join('')}
        </table>`;
            // Limpa o conteúdo anterior do container
            container.innerHTML = '';
            container.innerHTML = tablehtml;
        }
        else {
            console.error('A requisição falhou com código de status:', response.status);
        }
    }
    catch (error) {
        console.error('Ocorreu um erro ao fazer a requisição:', error);
    }
}
