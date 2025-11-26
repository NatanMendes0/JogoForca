# Jogo da Forca (Hangman Game)

Um jogo clássico da forca implementado em Java usando programação orientada a objetos e interfaces.

## 📋 Descrição

Este projeto implementa o tradicional jogo da forca (hangman) onde o jogador tenta adivinhar uma palavra oculta letra por letra. A cada erro, uma parte do boneco é desenhada na forca. O jogador tem até 6 tentativas erradas antes de perder o jogo.

## 🎯 Objetivo

O objetivo principal deste projeto é demonstrar os conceitos de:
- Programação Orientada a Objetos (POO)
- Utilização de Interfaces em Java
- Manipulação de arrays e listas
- Implementação de lógica de jogo
- Interação com o usuário através do console

## 🏗️ Arquitetura do Projeto

O projeto está estruturado seguindo boas práticas de desenvolvimento orientado a objetos:

```
JogoForca/
├── src/
│   ├── Principal.java           # Classe principal com método main
│   ├── interfaces/
│   │   ├── Desenhavel.java      # Interface para desenhar o estado do jogo
│   │   └── Jogavel.java         # Interface para mecânicas de jogo
│   └── model/
│       └── Forca.java            # Classe principal do jogo (implementa as interfaces)
├── bin/                          # Arquivos compilados (.class)
└── README.md                     # Documentação do projeto
```

### Componentes Principais

#### 1. Interfaces

**Desenhavel.java**
- Define o contrato para desenhar o estado atual do jogo
- Método: `void desenha()`

**Jogavel.java**
- Define o contrato para a lógica do jogo
- Métodos:
  - `void joga(char letra)` - Processa uma tentativa do jogador
  - `int verificaFim()` - Verifica se o jogo terminou (0=continua, 1=vitória, 2=derrota)

#### 2. Classe Forca

A classe `Forca` implementa as interfaces `Desenhavel` e `Jogavel`, contendo toda a lógica do jogo:

**Atributos:**
- `palavras`: Lista com banco de palavras disponíveis para o jogo
- `tentativas`: Lista de letras já tentadas pelo jogador
- `palavraSorteada`: Array com a palavra sorteada
- `palavraDigitada`: Array representando o progresso do jogador (letras descobertas)
- `erros`: Contador de tentativas erradas

**Funcionalidades:**
- Seleção aleatória de palavras de um banco com mais de 90 palavras
- Desenho progressivo do boneco (6 estágios)
- Validação de entrada do jogador
- Controle de letras já tentadas
- Verificação de vitória/derrota

#### 3. Classe Principal

A classe `Principal` contém o método `main` e gerencia o fluxo do jogo:
- Inicialização do jogo
- Loop principal de interação com o usuário
- Validação de entrada (apenas letras únicas)
- Exibição de mensagens de vitória/derrota

## 🎮 Como Jogar

### Pré-requisitos

- Java Development Kit (JDK) 8 ou superior
- Terminal/Console para executar o programa

### Compilação

Para compilar o projeto, execute no diretório raiz:

```bash
javac -d bin src/interfaces/*.java src/model/*.java src/Principal.java
```

### Execução

Para executar o jogo:

```bash
cd bin
java Principal
```

Ou diretamente:

```bash
java -cp bin Principal
```

### Regras do Jogo

1. O sistema sorteia aleatoriamente uma palavra do banco de palavras
2. A palavra é exibida com traços (-) representando cada letra
3. Digite uma letra por vez para tentar adivinhar
4. Se a letra estiver na palavra, ela será revelada em todas as posições onde aparece
5. Se a letra não estiver na palavra, você perde uma tentativa e uma parte do boneco é desenhada
6. Você tem no máximo 6 erros antes de perder o jogo
7. Vença o jogo descobrindo todas as letras antes de completar a forca

## ✨ Características

- ✅ Banco com mais de 90 palavras variadas (português e alguns termos técnicos)
- ✅ Interface de console interativa e intuitiva
- ✅ Desenho ASCII art da forca em 6 estágios
- ✅ Validação robusta de entrada
- ✅ Rastreamento de letras já tentadas
- ✅ Mensagens claras de feedback (acerto/erro)
- ✅ Exibição organizada do estado do jogo
- ✅ Código bem estruturado e documentado
- ✅ Uso de interfaces para separação de responsabilidades

## 🔧 Estrutura de Dados

### Banco de Palavras

O jogo inclui palavras de diferentes categorias:
- Natureza (animais, plantas, elementos naturais)
- Tecnologia (computador, internet, software)
- Cotidiano (objetos, lugares, conceitos)
- Programação (java, algoritmo, interface, desenvolvimento)

### Estados do Jogo

- **0**: Jogo em andamento
- **1**: Vitória (palavra completamente descoberta)
- **2**: Derrota (6 erros atingidos)

## 📚 Conceitos de Programação Aplicados

1. **Interfaces**: Definição de contratos através das interfaces `Desenhavel` e `Jogavel`
2. **Encapsulamento**: Atributos privados com métodos getters para acesso controlado
3. **Polimorfismo**: Implementação de múltiplas interfaces na classe `Forca`
4. **Coleções Java**: Uso de `List`, `ArrayList` e `Arrays`
5. **Tratamento de Entrada**: Validação e normalização de input do usuário
6. **Lógica Condicional**: Switch-case para desenho progressivo da forca
7. **Métodos Utilitários**: Uso de `Collections.sort()`, `Arrays.fill()`, `Arrays.equals()`

## 🎨 Exemplo de Execução

```
=== JOGO DA FORCA ===
Tente adivinhar a palavra!

  ____
 |    |
 |
 |
 |
 |
_|___

Letras Digitadas: []
Palavra: --------
Erros: 0/6
---
Digite uma letra: a
Boa! Letra 'a' encontrada!

  ____
 |    |
 |
 |
 |
 |
_|___

Letras Digitadas: [a]
Palavra: -a------
Erros: 0/6
---
```

## 🤝 Contribuindo

Este é um projeto educacional. Sugestões de melhorias incluem:
- Adicionar níveis de dificuldade
- Implementar sistema de pontuação
- Adicionar categorias de palavras
- Criar interface gráfica (GUI)
- Adicionar dicas para o jogador
- Implementar ranking de jogadores

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais.

## ✍️ Autor

Desenvolvido como trabalho acadêmico demonstrando conhecimentos de Java e POO.
