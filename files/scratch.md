Eu tava aqui pensando um pouco sobre a estrutura e tive algumas ideias, amanhã  vcs veem se algo faz sentido:

**User:**

- name:string
- surname:string
- email:string
- password:string

**Seller:**

- belongs_to:User

 **Buyer:**

- belongs_to:User

 **Wish:**

- belongs_to:Buyer
- belongs_to:Product
- title:string
- description:text
- budget:decimal
- status:string [desired, fulfilled]

**Tag:**

- name:string
- identifier:string
- description:text

 **WishTag:**

- belongs_to:Wish
- belongs_to:Tag

 **Offer:**

- belongs_to:Seller
- belongs_to:Wish
- status:string [issued, canceled, expired, accepted, declined]
- terms:text
- expires_at:datetime - accepted_at:datetime

> - Como eu vejo, o `Buyer` tem varios `wishes`, o `Seller` faz varias `Offer` para um `Wish`, depois da pra fazer uma validacao de `offers` pelo `status`, soh pode haver uma oferta `issued` por vendedor
>
> - Outra coisa q tive pensando eh q uma tabela de produto talvez ficasse muito aberta  com nome e valor, entao a gente conseguiria ter uma base usando `Tags`, para meio q categorizar, semprecisar fazer uma cadeia de categorias
>
> - Nessa estrutura inicia ficaria como a olx a transacao a principio seria combinada por fora
