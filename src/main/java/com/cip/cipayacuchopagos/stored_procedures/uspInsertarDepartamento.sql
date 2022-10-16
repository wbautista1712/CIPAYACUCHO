USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarDepartamento')
    BEGIN
        DROP PROCEDURE uspInsertarDepartamento
    END
GO

CREATE PROCEDURE uspInsertarDepartamento

@descripcion nvarchar(100),
@estado bit

AS

DECLARE @idDepartamento int;
SELECT @idDepartamento =  ISNULL(MAX(idDepartamento),0)+1 FROM Departamento;

INSERT INTO Departamento (idDepartamento, descripcion, estado)
VALUES (@idDepartamento, @descripcion, @estado)

SELECT MAX(idDepartamento)
FROM Departamento

GO
