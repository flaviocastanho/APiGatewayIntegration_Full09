/*Acessar o diretorio do projeto e executar os camandos abaixo* /
./mvnw clean install
./mvnw spring-boot:run

/*Consumo Postman*/
/*POST PECA*/
curl: POST: http://localhost:8080/api/v1/peca 
Header: "Content-Type: application/json"
json:
{
	"codigo": "P001",
	"nome": "Peça Exemplo 1"
}

/*GET PECAS*/
curl: GET: http://localhost:8080/api/v1/peca

/*GET PECA*/
curl: GET: http://localhost:8080/api/v1/peca/P001


/*POST COMPONENTE*/
curl: POST: http://localhost:8080/api/v1/peca/P001/componente
Header: "Content-Type: application/json"
json:
{
   "sku": "SKU001",
   "descricao": "Componente Exemplo 1",
   "preco": 99.90,
   "quantidade": 10
}

/*GET COMPONENTE*/
curl: GET: http://localhost:8080/api/v1/peca/P001/componente


