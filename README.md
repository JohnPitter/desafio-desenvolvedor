# Start

1. Abrir o powershell

2. Configurar base de dados SQL Server:
- docker-compose up -d database

- docker exec -it database /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P 'YourStrong!Passw0rd'

- CREATE DATABASE marketplace;
- GO

- SELECT Name FROM sys.Databases;
- GO

- CTRL + C

2. Configurar Kafka:

- docker-compose up -d zookeeper kafka
- docker exec kafka kafka-topics --create --topic processamento --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1

- CTRL + C

3. Desativar serviços individualmente:

- docker-compose stop

4. Ativar todos os serviços novamente:

- docker-compose up