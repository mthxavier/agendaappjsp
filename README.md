# Agenda App

Agenda App é um sistema web parecido com Google Classroom, desenvolvido utilizando **JSP, Hibernate e Materialize**. A aplicação permite o gerenciamento de alunos, professores e disciplinas, garantindo uma interface amigável e responsiva.

## Funcionalidades

- **Autenticação**: Tela de login com diferença na interface para alunos e professores.
- **Segurança**: Utilização de JWT e cookies para login de usuários.
- **CRUD de Alunos**: Cadastro, leitura, atualização e remoção de alunos.
- **CRUD de Professores**: Cadastro, leitura, atualização e remoção de professores.
- **CRUD de Disciplinas**: Professores podem criar, editar e remover disciplinas.
- **Vinculação de Professor com Disciplina**: O professor logado pode criar disciplinas e automaticamente se tornar o responsável por elas.
- **Ingresso de Aluno em Disciplina**: Alunos podem entrar em uma disciplina utilizando uma chave cadastrada no banco de dados.

## Tecnologias Utilizadas

- **Linguagem**: Java
- **Frontend**: JSP + Materialize (framework CSS)
- **Backend**: Servlets + Hibernate (ORM para MySQL) + JWT
- **Servidor**: Tomcat
- **Banco de Dados**: MySQL

## Melhorias Futuras

- Implementar JWT para autenticação mais segura.
- Melhorar a experiência do usuário com AJAX e chamadas assíncronas.
- Criar um sistema de notas e atividades para as disciplinas.


