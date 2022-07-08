## Descrição
Entidades
- O cliente pode ser PessoaFisica ou PessoaJuridica

Requisitos Funcionais
- Criar um método para listar os itens no carrinho (Produto, Quantidade, Preço Unitário e Total por item)
- Calcular o total a pagar do carrinho de compras.
- Criar um método para adicionar um item no carrinho.
- Criar um método para remover um item do carrinho.
- Criar um método para alterar a quantidade de um item do carrinho.
- Ao adicionar um novo produto verificar se o produto já existe, se existir atualizar apenas a quantidade.
- Criar classes de repository para manipulação e armazenamento dos dados (CRUD).
- Ao iniciar o programa verificar de onde recuperar os dados dos produtos, ter a opção de buscar os itens fixos na memória ou de uma outra fonte de dados (esta outra fonte de dados não precisa ser implementada, apenas simulada).

Regras
- Criar promoção para tipo de produto. Prever o desconto no momento de calcular o total da compra.
- Apenas para alguns produtos prever a cobrança de uma taxa extra a ser adicionado no valor total da compra.
- Apenas para alguns produtos prever a cobrança de frete (pode ser valor fixo ou porcentagem).

## Relatório
- [Arquitetura](docs/Arquitetura.md)