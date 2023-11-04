


// URL da API que você deseja acessar
const apiUrl = 'http://localhost:8080/cars';

// Função para fazer a requisição GET
async function carregaCarros() {
    let container:any = document.querySelector('.container');

  try {
    const response = await fetch(apiUrl);

    // Verifica se a resposta foi bem-sucedida (código de status 200)
    if (response.ok) {
      const data = await response.json();
      console.log('Dados da resposta:', data);
    } else {
      console.error('A requisição falhou com código de status:', response.status);
    }
  } catch (error) {
    console.error('Ocorreu um erro ao fazer a requisição:', error);
  }
}


