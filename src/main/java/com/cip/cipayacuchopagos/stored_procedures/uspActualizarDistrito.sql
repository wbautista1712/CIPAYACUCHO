USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarDistrito')
    BEGIN
        DROP PROCEDURE uspActualizarDistrito
    END
GO

CREATE PROCEDURE uspActualizarDistrito

@idDistrito nvarchar(6),
@idProvincia nvarchar(4),
@descripcion nvarchar(100),
@estado bit

AS

UPDATE Distrito SET idDistrito = @idDistrito, idProvincia = @idProvincia, descripcion = @descripcion, estado = @estado
WHERE idDistrito = @idDistrito

GO
