Os DTOs são arquivos voltados para a representação daqueles que estão em models, com mudanças voltadas para a entrada de
dados via API(forms) e sua visualização pelos usuários (Views).

O principal propósito dos DTOs é fazer com que a API não se comunique diretamente com as classes de domínio estabelecidas
em models. Dessa forma, elas se comunicam diretamente com os DTOs para que as informações sejam entregues corretamente e
assim fortalecer a engenharia de software por trás deste tipo de arquitetura.

Nota: Form é o dado via DTO que chegam; View é o dado via DTO de saída. 