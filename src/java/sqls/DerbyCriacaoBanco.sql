CREATE TABLE CLIENTES (
  id int NOT NULL GENERATED ALWAYS AS IDENTITY,
  nome varchar(20) NOT NULL,
  cpf varchar(20) NOT NULL,
  telefone varchar(20) NOT NULL,
  email varchar(30) default NULL,
  PRIMARY KEY  (id)
); 

INSERT INTO  clientes  VALUES (DEFAULT,'Kleber','123123123-12','1234-4321','candidomendes@ap.com.br'),(DEFAULT,'Vinicius','321321289-32','1111-1111','vinicius@ap.com.br'),(DEFAULT,'Elaine','456456456-32','2222-2222','elaine@ap.com.br'),(DEFAULT,'Spock','678678678-32','3333-3333','candidomendes@ap.com.br'),(DEFAULT,'Yara','135135135-15','4444-4444','yara@ap.com.br'),(DEFAULT,'Joelma','123321123-12','1234-4321',NULL),(DEFAULT,'Melissa','123123123-12','4321-4321',NULL),(DEFAULT,'Teste2','cpf','telefone',NULL),(DEFAULT,'teste2','teste2','teste2',NULL),(DEFAULT,'12','12','12',NULL),(DEFAULT,'123','123','123',NULL),(DEFAULT,'1','1','1',NULL),(DEFAULT,'Novo Teste da Silva','cpf da Silva','Telefone da Silva',NULL);

CREATE TABLE  pedidos  (
   id  int NOT NULL GENERATED ALWAYS AS IDENTITY,
   numero  varchar(20) NOT NULL,
   idCliente  int NOT NULL,
  PRIMARY KEY  ( id ),  
  CONSTRAINT  pedidos_ibfk_1  FOREIGN KEY ( idCliente ) REFERENCES  clientes  ( id )
); 
CREATE INDEX idClienteIndex ON pedidos(idCliente);


INSERT INTO  pedidos  VALUES (DEFAULT,'P10010-0',2),(DEFAULT,'P20010-0',2),(DEFAULT,'P30010-0',2),(DEFAULT,'P10010-1',3),(DEFAULT,'P10020-2',3),(DEFAULT,'P30020-2',1);

CREATE TABLE  produtos  (
   id  int NOT NULL GENERATED ALWAYS AS IDENTITY,
   nome  varchar(50) default NULL,
   codigo  varchar(50) default NULL,
   preco  double default NULL,
   descricao  varchar(50) default NULL,
   image  varchar(50) default NULL,
  PRIMARY KEY  ( id )
) ;

INSERT INTO produtos VALUES
(DEFAULT,'Floratta in Rose','Floratta',106.5,'Desodorante Colonia 100ml','Floratta.jpg'),
(DEFAULT,'Accordes','accordes',125,'Desodorante Colonia 100ml','accordes.jpg'),
(DEFAULT,'Egeo Dolce','egeo',24.3,'Desodorante Colonia 100ml','egeo.jpg'),
(DEFAULT,'Malbec','malbec',188,'Desodorante Colonia 100ml','malbec.jpg'),
(DEFAULT,'Quasar','quasar',150,'Desodorante Colonia 100ml','quasar')


CREATE TABLE  itenspedidos  (
   id  int NOT NULL GENERATED ALWAYS AS IDENTITY,
   quantidade  int NOT NULL,
   idProduto  int NOT NULL,
   idPedido  int NOT NULL,
  PRIMARY KEY  ( id ),
  CONSTRAINT  itenspedidos_ibfk_1  FOREIGN KEY ( idProduto ) REFERENCES  produtos  ( id ),
  CONSTRAINT  itenspedidos_ibfk_2  FOREIGN KEY ( idPedido ) REFERENCES  pedidos  ( id )
);
CREATE INDEX idProdutoIndex ON itenspedidos(idProduto);
CREATE INDEX idPedidoIndex ON itenspedidos(idPedido); 

INSERT INTO  itenspedidos  VALUES (DEFAULT,1,1,2),(DEFAULT,1,3,2),(DEFAULT,1,2,7),(DEFAULT,10,5,3),(DEFAULT,1,3,4),(DEFAULT,1,3,5),(DEFAULT,1,1,5),(DEFAULT,1,4,6);



