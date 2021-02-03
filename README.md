# microservices
Projeto desenvolvido para praticar alguns aprendizados sobre microsserviços  

## Tecnologias e objetivos do projeto
(Projeto está em desenvolvimento e como principal objetivo é colocar em prática o meu aprendizado, tudo pode ser alterado futuramente)
 Este projeto visa contruir um sistema simples utilizando microsserviços utilizando o ecossitema spring cloud Netflix, serão construidos 4 projetos SpringApp's que irão se comunicar via Feign, o mapemento dos serviçõs será feito via Eureka Server, utilizaremos o Hystrix como circuit breaker para tolerância a falha de comunicação entre os serviços, Ribbon será reponsavel por fazer o balanceamento de carga das requisições, API gateway Zuul será responsável pela comunicação externa do sistema, autenticação com OAuth 2.0 e JWT além de utilizar o conceitos de Rest nos SpringApp's. 
