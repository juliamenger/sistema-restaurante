# Sistema de Pedidos para Restaurante

Projeto desenvolvido em Java com o objetivo de simular um sistema de pedidos para um restaurante.

## Funcionalidades

- Criação de pedidos com identificação do cliente.
- Escolha de lanches disponíveis no cardápio.
- Adição de complementos, como cheddar e bacon extra.
- Personalização dos lanches, permitindo retirar ingredientes.
- Cálculo automático do valor dos pedidos.

## Organização do projeto

O projeto está dividido em três pacotes:

- **app:** contém as classes responsáveis pela execução do sistema, interação com o usuário e coordenação das operações.
- **cardapio:** reúne as classes relacionadas aos lanches, complementos e à criação dos itens do cardápio.
- **pedido:** contém as classes responsáveis pela representação e gerenciamento dos pedidos.

## Padrões de projeto utilizados

- **Factory:** centraliza a criação dos diferentes tipos de lanches, separando a lógica de instanciação das demais classes.
- **Decorator:** permite adicionar complementos aos lanches de forma dinâmica, modificando sua descrição e preço sem alterar a classe original.

## Testes

Foram utilizados testes unitários com **JUnit 5** para verificar funcionalidades como o cálculo dos preços com adicionais e a validação de valores negativos.

## Tecnologias

- Java
- JUnit 5
- IntelliJ IDEA

## Vídeo da apresentação:

https://drive.google.com/file/d/1Y9KpsZWnR3f5AnzX0vGi1cblj4XIP5v2/view?usp=drive_link

