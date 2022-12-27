# One To Many e Many To One
### 3. ONE TO MANY e MANY TO ONE
#### a. Cliente - Um cliente pode ter vários números de telefone //  Da perspectiva do cliente o relacionamento é ONE TO MANY.
|   Long id   |
|   :---:     |
| Set < NumeroTelefone > numbers |
|   |
#### b. NumeroTelefone - E um número pode pertencer a um cliente apenas. //  Da perspectiva do NumeroTelefone o relacionamento é MANY TO ONE
|   Long id   |
|     :---:   |
| String number |
| |
### 4. E há dois modos que estes relacionamentos podem ocorrer:
#### a. Unidirecional - Significa que somente nós estaremos habilitados para acessar esse relacionamento de maneira única.
##### 1. Exemplo: Se este Cliente for configurado ONE TO MANY de Cliente para NumeroTelefone, nós não conseguiremos usar a Entidade NumeroTelefone
##### 2. Mas nós conseguiremos acessar o NumeroTelefone do Cliente que é Unidirecional. Para que haja acceso, é preciso configurar de um lado e do outro esse tipo de modo Unidirecional de relacionamento.
##### 3. Cliente - Um cliente pode ter vários números de telefone //  Da perspectiva do cliente o relacionamento é ONE TO MANY.
|   Long id   |
|   :---:      |
| Set <  NumeroTelefone > numbers |
|   |
##### 4. NumeroTelefone - E um número pode pertencer a um cliente apenas. //  Da perspectiva do NumeroTelefone o relacionamento é MANY TO ONE
|   Long id   |
|     :---:   |
| String number |
| |
#### b. Bidirecional - Significa que podemos acessar os objetos ou entidades uns dos outros. E conseguiremos navegar de Cliente para NumeroTelefone e vice-versa.
# Annotations
### 1. @OneToOne
### 2. @OneToMany
### 3. @ManyToOne
### 4. @ManyToMany
# Entendendo as Associações
### 1. [OneToMany] ->  Cliente 1(um cliente)  ------------------>  *(Vários NumeroTelefone) NumeroTelefone <- [ManyToOne]
### 2. Quando declaramos uma lista de NumeroTelefone dentro da classe Cliente, porque um Cliente pode ter vários numerosTelefone, e do lado do NumeroTelefone nós definirmos um objeto cliente por causa de múltiplos numerosTelefone pertecerem a um único cliente. Então colocamos a seguinte anotação:
#### a. @OneToMany acima de List<NumeroTelefone> numerosTelefone; em Cliente
|   Cliente   |
|    :---:    |
|    @OneToMany     |
| List < NumeroTelefone > numerosTelefone;|
#### b. @ManyToOne acima de Cliente cliente; em NumeroTelefone
|   NumeroTelefone   |
|     :---:      |
|    @ManyToOne    |
| Cliente cliente |
### 3. Nesse caso, @OneToMany pode ser chamada como um tipo de associação Pai porque um Cliente pode ter múltiplos NumeroTelefone.
### 4. E chamamos NumeroTelefone como uma tipo de associação Filho porque muitos NumeroTelefone podem pertencer a um único Cliente.
# Entendendo os Modos de Associações
## A. Bidirecional
### 1. No exemplo abaixo, nós navegamos de Cliente para todos os seus numerosTelefone. E nós podemos recuperar todos os numerosTelefone de List de Cliente e de NumeroTelefone nós podemos ir ao seu cliente.
#### a. @OneToMany acima de List<NumeroTelefone> numerosTelefone; em Cliente
|   Cliente   |
|    :---:      |
|    @OneToMany     |
| List < NumeroTelefone > numerosTelefone;|
#### b. @ManyToOne acima de Cliente cliente; em NumeroTelefone
|   NumeroTelefone   |
|     :---:      |
|    @ManyToOne    |
| Cliente cliente |
## B. Unidirecional
### 1. No exemplo abaixo, nós não precisamos definir o Cliente com a @ManyToOne e ele já se torna uma associação de modo unidirecional.
### 2. Porque navegamos de Cliente para os NumeroTelefone dele:
#### a. Não precisa por @ManyToOne acima de Cliente cliente; em NumeroTelefone.
#### b. Contudo, como não definimos o Cliente de NumeroTelefone com a anotação @ManyToOne, não vamos conseguir navegar de NumeroTelefone para Cliente. E daí a listagem não funcionará.
|   NumeroTelefone   |
|    :---:     |
| Cliente cliente |
#### b. @OneToMany acima de List<NumeroTelefone> numerosTelefone; em Cliente
|   Cliente   |
|    :---:      |
|    @OneToMany     |
| List < NumeroTelefone > numerosTelefone;|
### 3. Então dependerá da regra de negócio se faremos a associação Unidirecional ou Bidirecional.
