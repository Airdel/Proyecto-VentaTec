
--16. PARTICIONA LA TABLA carticulos POR EL TIPO DE BIEN DE ACUERDO A LA SIGUIENTE TABLA
--Creacion de los filegroups
alter database SIB
add filegroup particion1_17400000
go
alter database SIB
	add filegroup particion2_17400000
go
alter database SIB
	add filegroup particion3_17400000
go
alter database SIB
	add filegroup particion4_17400000
go
alter database SIB
	add filegroup particion5_17400000
go


SELECT * FROM carticulos
--Creacion de los datafiles
alter database SIB
add file
(
	name='particion1.ndf',
	filename='C:\EJEMPLO\particion1.ndf'
)to filegroup particion1_17400000;

alter database SIB
add file
(
	name='particion2.ndf',
	filename='C:\EJEMPLO\particion2.ndf'
)to filegroup particion2_17400000;

alter database SIB
add file
(
	name='particion3.ndf',
	filename='C:\EJEMPLO\particion3.ndf'
)to filegroup particion3_17400000;

alter database SIB
add file
(
	name='particion4.ndf',
	filename='C:\EJEMPLO\particion4.ndf'
)to filegroup particion4_17400000;

alter database SIB
add file
(
	name='particion5.ndf',
	filename='C:\EJEMPLO\particion5.ndf'
)to filegroup particion5_17400000;

FECHA MESES
LEFT 31/01/2020, 28/02/2020
RIGTH 1/02/2020 01/03/2020
CARACTERES MAS DE 1 SE RECOMIENDA RIGTH
CHAR(2) 1Y02
SELECT * FROM carticulos
TIPO DE BIEN 
1Y2    PARTICION 1   
3      PARTICION 2
4Y5      PARTICION 3
6	   PARTICION 4
7      PARTICION 5

--- suponga edades
--6,7 y 8 part1
--9 y 10   part2
--11 y 12  part3
--13 a 16  part4
left
8,10,12
rigth
9,11,13




--Funcion de particion
CREATE PARTITION 
FUNCTION F_Particion_17400000(char(2))
AS RANGE RIGHT 
FOR VALUES ('03','05','06','07');

--Esquema de particion
create partition scheme EsquemaPorTB_17400000
as partition F_Particion_17400000
to(particion1_17400000, particion2_17400000, 
particion3_17400000, 
particion4_17400000, 
particion5_17400000)


--crear un indice clustereado en la tabla
--con el campo de particion

--quitar PK y  crearselo como nonclustered
--Indice clustereado
ALTER TABLE carticulos --QUITANDO
  DROP CONSTRAINT PK_arti
GO

ALTER TABLE carticulos
ADD CONSTRAINT PK_arti
PRIMARY KEY NONCLUSTERED 
(scvetb, scvefam, scveart)
GO

--- Asignando esquema de particion a la 
-- tabla para AHORA SI PARTICIONARLA
CREATE CLUSTERED INDEX IDX_PARAPARTICION
ON carticulos (scvetb)
ON EsquemaPorTB_17400000(scvetb);


/*
17. INSERTE 5 ARTICULOS PARA QUE QUEDEN EN LA PARTICION 1, 2 PARA QUEBEN EN LA PARTICION 2 Y 3 PARA
QUEDEN EN LA PARTICION 5.
*/
--5 articulos particion 1

insert into carticulos values ('01','01','200','Particion1'),('02','02','201','Particion1'),('01','01','202','Particion1'),
('02','02','203','Particion1'),('01','01','204','Particion1')

--2 articulos en la particion 2
insert into carticulos values ('03','03','205','Particion2'),('03','03','206','Particion2')

--3 articulos en la particion 5
INSERT INTO carticulos VALUES ('07','20','1111','Particion5'),('07','20','1112','Particion5'),('07','20','1113','Particion5')

/*
18. MUESTRA DE NUEVO CUANTOS ARTICULOS EXISTEN POR CADA TIPO DE BIEN (PUNTO 11)
*/
select COUNT(*) as Num_Articulos,a.scvetb from carticulos a inner join cTipoBien tb on (a.scvetb=tb.scvetb) group by a.scvetb
--Dividido por tipo bien
--4+37+15+49+39+1357+133 = 1634 articulos

/*
19. MUESTRE CUANTOS REGISTROS TIENE CADA PARTICION. COMPARA SI LA CONSULTA 18 Y 19 COINCIDEN AL FINAL
COMO QUEDARON LAS PARTICIONES Y DESCRIBE LO QUE OBSERVASTE EN LOS COMENTARIOS.
*/


select * from carticulos
where scvetb = '01' or scvetb = '02'
SELECT p.partition_number AS Num_Particion,
f.name AS Nombre, p.rows AS Columnas
FROM sys.partitions p
JOIN sys.destination_data_spaces dds ON
p.partition_number = dds.destination_id
JOIN sys.filegroups f ON dds.data_space_id =
f.data_space_id
WHERE OBJECT_NAME(OBJECT_ID) = 'carticulos'
AND P.index_id=1
ORDER BY Num_Particion
GO
--Dividido por particiones
--41+15+88+1357+133 = 1634 articulos en total
/*
El numero de datos totales coincide entre la consulta 18 y 19 solo que en la 18 esta dividido por tipo bien
mientras que en la 19 esta dividido por particiones, en unos casos una particion representa la union de 2 tipos
pero al final es el mismo numero de registros
*/

/*
20. MUESTRA LOS DATOS DE CADA REGISTRO MOSTRANDO SOLO LA CLAVE DEL TIPO DE BIEN, LA FAMILIA Y SU
DESCRIPCION DE CADA PARTICION POR SEPARADO.
*/
--Particion 1
SELECT scvetb,scvefam,sdesart FROM carticulos WHERE $partition.F_Particion_17400000(scvetb)=1
--Particion 2
SELECT scvetb,scvefam,sdesart FROM carticulos WHERE $partition.F_Particion_17400000(scvetb)=2
--Particion 3
SELECT scvetb,scvefam,sdesart FROM carticulos WHERE $partition.F_Particion_17400000(scvetb)=3
--Particion 4
SELECT scvetb,scvefam,sdesart FROM carticulos WHERE $partition.F_Particion_17400000(scvetb)=4
--Particion 5
SELECT scvetb,scvefam,sdesart FROM carticulos WHERE $partition.F_Particion_17400000(scvetb)=5