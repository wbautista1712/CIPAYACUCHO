USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarProvincia')
    BEGIN
        DROP PROCEDURE uspInsertarProvincia
    END
GO

CREATE PROCEDURE uspInsertarProvincia

@idDepartamento nvarchar(2),
@descripcion nvarchar(100),
@estado bit

AS

DECLARE @idProvincia int;
SELECT @idProvincia =  ISNULL(MAX(idProvincia),0)+1 FROM Provincia;

INSERT INTO Provincia (idProvincia, idDepartamento, descripcion, estado)
VALUES (@idProvincia, @idDepartamento, @descripcion, @estado)

SELECT MAX(idProvincia)
FROM Provincia

GO
