
CREATE table almacenes(
	codigo int,
    lugar VARCHAR(100),
    capacidad int,
    primary key (codigo)
);
CREATE table cajas(
	num_referencia VARCHAR(5),
    contenido VARCHAR(100),
    valor int,
    codigo_almacen int,
    foreign key (codigo_almacen) REFERENCES almacenes (codigo)
	ON DELETE CASCADE ON UPDATE CASCADE,
	primary key (num_referencia)
);
INSERT INTO `almacenes` VALUES (1,'Valencia',3),(2,'Barcelona',4),(3,'Bilbao',7),(4,'Los Angeles',2),(5,'San Francisco',8);
INSERT INTO `cajas` VALUES ('0MEN7','Rocks',180,3),('4HE8P','Rocks',250,1),('4RET3','Scissors',190,4),('7GE3H','Rocks',200,1),('8EJN6','Papers',75,1),('E8Y6U','Papers',50,3),('E9J6F','Papers',175,2),('LEL08','Rocks',140,4),('P0EH6','Scissors',125,1),('P2ET6','Scissors',150,2),('TUE55','Papers',90,5);
