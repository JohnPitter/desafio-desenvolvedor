# Desafio Desenvolvedor

<div align="center">

![Java](https://img.shields.io/badge/Java-orange?style=for-the-badge&logo=openjdk)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Kafka](https://img.shields.io/badge/Kafka-231F20?style=for-the-badge&logo=apachekafka&logoColor=white)
![SQL Server](https://img.shields.io/badge/SQL_Server-CC2927?style=for-the-badge&logo=microsoftsqlserver&logoColor=white)

**Marketplace Assincrono**

*Arquitetura de microservicos com processamento assincrono via Kafka*

[Arquitetura](#arquitetura) •
[Instalacao](#instalacao) •
[Servicos](#servicos)

</div>

---

## Overview

Marketplace assincrono construido com arquitetura de microservicos. Utiliza Apache Kafka para comunicacao assincrona entre servicos, SQL Server como banco de dados e Docker para orquestracao.

---

## Arquitetura

```
┌─────────────┐     ┌─────────────┐     ┌──────────────────┐
│     API     │────▶│    Kafka    │────▶│  Processamento   │
└─────────────┘     └─────────────┘     └──────────────────┘
                          │                       │
                          ▼                       ▼
                    ┌─────────────┐     ┌──────────────────┐
                    │ Notificacao │     │    Database       │
                    └─────────────┘     │   (SQL Server)   │
                                        └──────────────────┘
```

---

## Servicos

| Servico | Descricao |
|---------|-----------|
| **API** | Gateway de entrada para o marketplace |
| **Checkout** | Processamento de compras |
| **Processamento** | Worker assincrono via Kafka |
| **Notificacao** | Servico de notificacoes |
| **Database** | SQL Server para persistencia |

---

## Instalacao

### Requisitos

| Requisito | Versao |
|-----------|--------|
| Docker | 20+ |
| Docker Compose | 2.0+ |

### Setup

1. Configure o banco de dados:

```bash
docker-compose up -d database
```

2. Crie o banco:

```bash
docker exec -it database /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P 'YourStrong!Passw0rd'
```

```sql
CREATE DATABASE marketplace;
GO
```

3. Configure o Kafka:

```bash
docker-compose up -d zookeeper kafka
docker exec kafka kafka-topics --create --topic processamento --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1
```

4. Inicie todos os servicos:

```bash
docker-compose up
```

---

## Comandos

| Comando | Descricao |
|---------|-----------|
| `docker-compose up -d database` | Inicia apenas o banco |
| `docker-compose up -d zookeeper kafka` | Inicia Kafka |
| `docker-compose up` | Inicia todos os servicos |
| `docker-compose stop` | Para todos os servicos |

---

## License

MIT
