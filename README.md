# Projeto de Comunicação entre Estoque e Vendas com Apache Kafka

Este projeto consiste em dois microserviços: **Estoque** e **Vendas**, que se comunicam de forma assíncrona utilizando **Apache Kafka**. O objetivo é permitir a venda de produtos com base no estoque disponível, sincronizando as informações entre os serviços de forma eficiente.

## Arquitetura

- **Microserviço de Estoque**: Responsável por gerenciar o estoque de produtos. Sempre que um produto é vendido, ele atualiza a quantidade disponível.
- **Microserviço de Vendas**: Responsável por processar as vendas. Ao realizar uma venda, envia uma mensagem para o microserviço de estoque para atualizar que o produto foi vendido.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Apache Kafka**
- **Kafka**
- **PostgreSQL**

## Como Funciona

### 1. Microserviço de Estoque

- Gerencia a tabela de estoque no banco de dados.
- Consome mensagens do tópico Kafka para receber atualizações de vendas.
- Atualiza o estoque de produtos com base nas vendas realizadas.

### 2. Microserviço de Vendas

- Realiza o processo de venda de produtos.
- Pode vender um produto pelo EndPoint(/venda) passando o ID, nome e quantidade.

### 3. Apache Kafka

- **Tópico `vendas-produto`**: Usado para enviar mensagens do microserviço de vendas para o de estoque.

## Considerações Finais

- Tem muitas a melhorar nesse projeto e continuarei trabalhando nele, acabei fazendo ele pra aprender mais sobre o serviço de mensageria kafka.
- Qualquer dica, ajuda ou conselhos ajudaria muito!
