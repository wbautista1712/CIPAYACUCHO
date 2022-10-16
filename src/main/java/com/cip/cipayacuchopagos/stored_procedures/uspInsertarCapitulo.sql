USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarCapitulo')
    BEGIN
        DROP PROCEDURE uspInsertarCapitulo
    END
GO

CREATE PROCEDURE uspInsertarCapitulo

@descripcion nvarchar(200),
@estado bit

AS

DECLARE @idCapitulo int;
SELECT @idCapitulo =  ISNULL(MAX(idCapitulo),0)+1 FROM Capitulo;

INSERT INTO Capitulo (idCapitulo, descripcion, estado)
VALUES (@idCapitulo, @descripcion, @estado)

SELECT MAX(idCapitulo)
FROM Capitulo

GO
