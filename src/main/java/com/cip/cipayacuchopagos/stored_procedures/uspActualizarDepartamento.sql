USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarDepartamento')
    BEGIN
        DROP PROCEDURE uspActualizarDepartamento
    END
GO

CREATE PROCEDURE uspActualizarDepartamento

@idDepartamento nvarchar(2),
@descripcion nvarchar(100),
@estado bit

AS

UPDATE Departamento SET idDepartamento = @idDepartamento, descripcion = @descripcion, estado = @estado
WHERE idDepartamento = @idDepartamento

GO
