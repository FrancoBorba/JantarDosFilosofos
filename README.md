# Projeto: Jantar dos Filósofos

## Descrição Geral
Este projeto implementa uma solução para o **Problema Clássico do Jantar dos Filósofos**, proposto por **Edsger Dijkstra** em 1965. O problema é uma abstração de cenários de concorrência, onde cinco filósofos alternam entre pensar e comer, compartilhando recursos limitados (os garfos). A solução busca evitar **deadlocks**, **inanição** e garantir que os filósofos possam comer de forma justa.

O projeto foi desenvolvido para a disciplina de **Programação Concorrente**, orientada pelo professor **Marlos Marques**.

---

## O Problema do Jantar dos Filósofos
Imagine cinco filósofos sentados ao redor de uma mesa redonda. Cada filósofo tem um prato de comida e um garfo à sua esquerda e à sua direita. Para comer, o filósofo precisa de **dois garfos** (o da esquerda e o da direita). 

Os estados dos filósofos são:
1. **Pensando**: O filósofo não usa os garfos.
2. **Faminto**: O filósofo tenta pegar os dois garfos.
3. **Comendo**: O filósofo usa os dois garfos para comer.

### Desafios do Problema
- **Exclusão Mútua**: Dois filósofos não podem usar o mesmo garfo simultaneamente.
- **Evitar Deadlock**: Nenhum filósofo deve ficar esperando indefinidamente pelos garfos.
- **Evitar Inanição**: Todos os filósofos devem ter a oportunidade de comer.

---

## Solução Implementada
Este projeto utiliza diferentes abordagens para resolver o problema:
1. **Semáforos**: Para controlar o acesso aos garfos e garantir exclusão mútua.
2. **Monitor**: Para gerenciar o estado de cada filósofo (Pensando, Faminto ou Comendo) e evitar inanição.
3. **Estratégias de Prevenção de Deadlock**: 
   - Limitar o número de filósofos que podem pegar os garfos ao mesmo tempo.
   - Garantir uma ordem de aquisição dos recursos (garfos).

---

## Funcionalidades
- Simulação da alternância entre os estados dos filósofos.
- Logs detalhados mostrando as ações de cada filósofo (pensando, pegando garfos, comendo).
- Interface textual para acompanhar o comportamento dos filósofos.

---

## Tecnologias Utilizadas
- **Linguagem de Programação**: Java
- **Ambiente de Desenvolvimento**: Visual Studio Code
- **Conceitos Aplicados**: Concorrência, Exclusão Mútua, Gerenciamento de Recursos

---

## Como Executar
1. Clone este repositório:
   ```bash
   git clone https://github.com/FrancoBorba/JantarDosFilosofos.git
2. Abra o projeto em sua IDE de preferência.
3. Compile e execute o código principal para iniciar a simulação.

## Exemplos de Saída
- A interface gráfica mostra os filosofos e seus estados , sendo possivel pausar e acelerar seus estados

## Aprendizados
- Implementação de soluções clássicas para problemas de concorrência.
- Análise comparativa de desempenho entre as soluções (eficiência e simplicidade).
- Desenvolvimento de aplicações concorrentes em Java.

## Autor
**Franco Ribeiro Borba**
- **Curso**: Ciência da Computação, 4º semestre
- **Instituição**: UESB (Universidade Estadual do Sudoeste da Bahia)
- **Professor Orientador**: Marlos Marques

## Licença
Este projeto é licenciado sob a Licença MIT. Consulte o arquivo `LICENSE` para mais informações.

## Contato
- [LinkedIn](https://www.linkedin.com/in/franco-borba-37462825b/)
- Email: franco.borba14@gmail.com
