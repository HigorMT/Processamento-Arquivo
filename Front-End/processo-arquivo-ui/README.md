# Processamento Arquivo UI

Frontend do sistema de Processamento de Arquivos

Projeto gerado com [Angular CLI](https://github.com/angular/angular-cli) versão 15.2.9. <br/>
Tema tilizado no projeto foi o <a href="https://designer.primeng.org/#/">md-dark-indigo</a>  

---

### 1. Alteração das URLs do back-end

> Para que o front-end aponte para o back-end correto, deverá ser alterado o arquivo `environment` que fica localizado
> na pasta `src/environments`, na pasta raiz do projeto.
>
> A alteração a ser realizada, deve ser nos parâmetros de URL, conforme exemplo abaixo:

```
export const environment = {
    apiUrl: 'https://{URL}',
};
```


### 2. Install NPM e Angular CLI

> Após a instalação do NodeJS, deve ser instalado o [Angular CLI](https://angular.io/cli) e outras dependências do
> front-end, executando o seguinte comando: <br/>
> ``npm install``<br/>
> ``npm install -g @angular/cli``<br/>
> <br/>

### 3. Build

> Para realizar o build do projeto, basta executar o seguinte comando, após a instalação do Angular CLI: <br/>
> ``ng build`` <br/><br/>


### 4. Run

> Para execução do projeto utilizando o Node, basta executar o seguinte comando:<br/>
> ``ng serve -o``
