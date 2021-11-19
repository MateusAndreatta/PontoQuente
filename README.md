# spring-cloud-netflix-proxy-apis
[Criando proxy de APIs com Spring cloud, Zuul e Eureka](https://wp.me/p5RSbg-kW)

O Zuul não tem suporte na versão mais atual do spring-boot, por isso nesse fork ele foi substituido
pelo `spring-cloud-gateway`
## Pré requisito
- Maven 3
- Java 11

### Optional
- Docker e docker-compose

## Preparando ambiente

### Sem Docker
- ```cd spring-cloud-netflix-proxy-apis```
- ```mvn clean package```

### Com Docker
Execute o `build.sh` ou build as imagens docker manualmente.

Cada modulo tem o seu próprio `Dockerfile` e `build.sh` com o comando utilizado para buildar a imagem.
Caso vc esteja usando Windows e não queira usar o git bash, você pode abrir e rodar o conteudo de cada build.sh,
por exemplo o customers:
```
cd japao
docker build --rm -t carlosedba/japao-service:latest .
```


## Executando
### Sem Docker
Service Discovery (Eureka)
- ```cd eureka```
- ```mvn spring-boot:run```

Proxy (Gateway)
- ```cd gateway```
- ```mvn spring-boot:run```

API do PontoQuente
- ```cd pontoquente```
- ```mvn spring-boot:run```


### Com Docker
```
docker-compose up -d
```

Acssando Eureka: http://localhost:8761
Instances currently registered with Eureka
```

Application	AMIs	Availability Zones	Status
PONTOQUENTE	n/a (1)	(1)	UP (1) - 192.168.11.247:pontoquente:8070
ZUUL	      n/a (1)	(1)	UP (1) - 192.168.11.247:zuul:8080
```

## Acessando APIs

#### Diretamente
#### Sem Docker
- http://localhost:8070/pontoquente
#### Com Docker
As portas das api não estão expostas no docker compose, então caso queria acessar elas diretamente terá que modificar o
docker compose, por exemplo o customer-service ficaria assim:

```
ponto-quente-service:
  image: 'carlosedba/ponto-quente-service:latest'
  networks:
    - ponto-network
  ports:
  - "8070:8070"
  depends_on:
    - eureka-service
    - mariadb-service
  environment:
    EUREKA_URL: ponto-quente-service
    EUREKA_DEFAULT_ZONE: 'http://eureka-service:8761/eureka'
```

#### Via Proxy (Gateway)
- http://localhost:8080/pontoquente


O procedimento é o mesmo com ou sem docker

