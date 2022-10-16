USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarProvincia')
    BEGIN
        DROP PROCEDURE uspActualizarProvincia
    END
GO

CREATE PROCEDURE uspActualizarProvincia

@idProvincia nvarchar(4),
@idDepartamento nvarchar(2),
@descripcion nvarchar(100),
@estado bit

AS

UPDATE Provincia SET idProvincia = @idProvincia, idDepartamento = @idDepartamento, descripcion = @descripcion, estado = @estado
WHERE idProvincia = @idProvincia

GO
