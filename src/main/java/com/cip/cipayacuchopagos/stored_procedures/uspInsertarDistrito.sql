USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarDistrito')
    BEGIN
        DROP PROCEDURE uspInsertarDistrito
    END
GO

CREATE PROCEDURE uspInsertarDistrito

@idProvincia nvarchar(4),
@descripcion nvarchar(100),
@estado bit

AS

DECLARE @idDistrito int;
SELECT @idDistrito =  ISNULL(MAX(idDistrito),0)+1 FROM Distrito;

INSERT INTO Distrito (idDistrito, idProvincia, descripcion, estado)
VALUES (@idDistrito, @idProvincia, @descripcion, @estado)

SELECT MAX(idDistrito)
FROM Distrito

GO
