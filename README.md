# Codesquare

- Tecnologias Utilizadas
    - Java
    - Spring Boot
    - Mysql
    - Docker
    - Docker-Compose
    - Angular

- Requisitos para execução
    - Docker
        - Para instalar o docker siga os passos da instalação do docker community
            - [Ubuntu](https://docs.docker.com/install/linux/docker-ce/ubuntu/)
            - [Debian](https://docs.docker.com/install/linux/docker-ce/debian/)
            - [Fedora](https://docs.docker.com/install/linux/docker-ce/fedora/)
            - [CentOS](https://docs.docker.com/install/linux/docker-ce/centos/)
    - Docker Compose
        - Como o processo de instalação do docker já adiciona o repositório do docker no seu gerenciador de pacotes provavelmente um simples "... install docker-compose" já irá instalar mas se não for esse o caso dê uma olhada nesse [link com o proecesso de instalação](https://docs.docker.com/compose/install/)

- Execução
    - Basta um simples `docker-compose up` na raiz do projeto onde está o arquivo `docker-compose.yml`
    - Para executar o projeto basta o docker com docker-compose, pois todo o docker-compose está com os containers preparados para a execução, sendo eles 3, o backend Java, frontend Angular e o container com o banco mysql
    - A primeira execução é um pouco demorada pois irá ser criado e inicializado a instância do mysql.
    