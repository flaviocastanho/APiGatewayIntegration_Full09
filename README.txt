./mvnw clean install
./mvnw spring-boot:run

http://localhost:8080/api/v1/peca
http://localhost:8080/api/v1/peca/ABC123
http://localhost:8080/api/v1/peca/ABC123/componente


curl -X POST http://localhost:8080/api/v1/peca \
 -H "Content-Type: application/json" \
 -d '{
       "codigo": "P001",
       "nome": "Peça Exemplo"
     }'
	 
curl -X POST http://localhost:8080/api/v1/peca/P001/componente \
 -H "Content-Type: application/json" \
 -d '{
       "sku": "SKU001",
       "descricao": "Componente Exemplo",
       "preco": 99.90,
       "quantidade": 10
     }'

curl http://localhost:8080/api/v1/peca/P001

curl http://localhost:8080/api/v1/peca

curl http://localhost:8080/api/v1/peca/P001/componente
	 