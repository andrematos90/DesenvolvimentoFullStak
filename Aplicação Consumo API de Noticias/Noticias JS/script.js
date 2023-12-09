let button = document.querySelector(".botao");

function getNews(){
    console.log("clicou")
    fetch('https://newsapi.org/v2/top-headlines?country=br&apiKey=2397034a4c8e452c8b7cfddb8c5e0be1')
    .then(function (result){
        return result.json();
    })
    .then(function(json){
        console.log(json)
    });
}