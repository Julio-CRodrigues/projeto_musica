
# 🎵 Projeto Música

Sistema desenvolvido durante o curso de **Análise e Desenvolvimento de Sistemas na FIAP**, com o objetivo de criar uma **API RESTful** para gerenciar informações relacionadas a músicas utilizando Java com Spring Boot.

---

## 🚀 Sobre o Projeto

Esta aplicação é uma **API RESTful** que permite realizar o cadastro, listagem, atualização, exclusão e consulta de músicas, com filtros por duração e internacionalidade.

Além disso, o sistema:

- Utiliza **cache com Spring** para otimização de performance
- Protege rotas com **Spring Security**, exigindo autenticação básica
- Está documentado com **Swagger (OpenAPI)** para facilitar o uso dos endpoints
- Apresenta boas práticas de organização em camadas (controller, service, repository)

---

## 🔐 Autenticação

Esta API utiliza autenticação HTTP básica com usuário padrão do Spring Security.

- **Usuário:** `user`
- **Senha:** gerada automaticamente no console ao iniciar a aplicação

### 📌 Onde encontrar a senha?

Ao rodar a aplicação, procure no terminal por algo como:

```
Using generated security password: e1x2y3z4...
```

> Copie essa senha e use no Swagger UI quando solicitado.
>
> ⚠️ Endpoints como `/musicas/todas` e `/musicas/todas_cacheable` estão liberados sem login.

---

## 🧰 Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.7.0-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
![Spring Web](https://img.shields.io/badge/Spring_Web-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2-Database-0066A1?style=for-the-badge&logo=h2&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-UI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![Eclipse IDE](https://img.shields.io/badge/Eclipse-IDE-2C2255?style=for-the-badge&logo=eclipse-ide&logoColor=white)

---

## ⚙️ Funcionalidades

- 📥 Cadastro de músicas  
- 📄 Listagem completa e paginada  
- 🔍 Consulta por ID e por substring  
- 🌍 Filtro de músicas internacionais  
- ⏱️ Filtro de músicas por duração  
- 🔐 Segurança com autenticação básica (Spring Security)  
- ⚡ Otimização com cache  
- 🔗 Links HATEOAS para facilitar navegação na API  
- 🧾 Documentação interativa via Swagger UI  

---

## 📁 Estrutura do Projeto

```
projeto_musica/
├── controller/             # Controladores REST
│   └── MusicaController.java
├── model/                  # Entidades JPA
│   └── Musica.java
├── repository/             # Interfaces de persistência
│   └── MusicaRepository.java
├── service/                # Camadas de serviço e cache
│   └── MusicaService.java
│   └── MusicaCachingService.java
├── security/               # Configuração de segurança
│   └── SegurancaConfig.java
├── swagger/                # Configuração Swagger
│   └── swaggerConfiguration.java
└── ProjetoMusicaApplication.java  # Classe principal
```

---

## 🛠️ Como Executar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/Julio-CRodrigues/projeto_musica.git
   ```

2. Importe o projeto no Eclipse como **"Existing Maven Project"**.

3. Execute a classe `ProjetoMusicaApplication.java` como uma aplicação Spring Boot.

4. Acesse a aplicação localmente:
   - API Base: [http://localhost:8080](http://localhost:8080)
   - Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 📡 Como Usar a API

Após executar a aplicação, você pode interagir com a API das seguintes formas:

### 🔗 Swagger UI (Interface Visual)

1. Acesse:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

2. Autentique-se com as credenciais indicadas (user / "gerada automaticamente no console").

3. Navegue pela lista de endpoints divididos por grupo (inserção, consulta, atualização, remoção).

4. Clique em um endpoint → **"Try it out"** → Preencha os parâmetros → **Execute**.

---

### 📌 Endpoints Principais

| Método | Endpoint                             | Descrição |
|--------|--------------------------------------|-----------|
| GET    | `/musicas/todas`                     | Retorna todas as músicas |
| GET    | `/musicas/{id}`                      | Retorna música por ID |
| GET    | `/musicas/paginadas?page=0&size=5`   | Retorna músicas paginadas |
| GET    | `/musicas/longas?duracao=3.5`        | Filtra músicas com duração acima de X minutos |
| GET    | `/musicas/internacionais_otimizadas` | Lista músicas internacionais com cache |
| POST   | `/musicas/inserir`                   | Insere uma nova música |
| PUT    | `/musicas/atualizar/{id}`            | Atualiza uma música existente |
| DELETE | `/musicas/excluir/{id}`              | Remove uma música pelo ID |

---

### 📤 Exemplo de Requisição (JSON)

```json
{
  "titulo": "Imagine",
  "artista": "John Lennon",
  "genero": "Rock",
  "duracao": 3.1,
  "data_lancamento": "1971-10-11",
  "internacional": true
}
```

---

## 👨‍💻 Autor

Julio Cesar Rodrigues  
📧 juliocesarcxz29@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/julio-cesar-rodrigues29/)

---

## 📝 Licença

Este projeto é apenas para fins educacionais. Todos os direitos reservados à FIAP e ao autor.
