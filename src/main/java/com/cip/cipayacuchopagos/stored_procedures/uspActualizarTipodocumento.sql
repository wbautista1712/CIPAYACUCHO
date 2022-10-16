USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarTipodocumento')
    BEGIN
        DROP PROCEDURE uspActualizarTipodocumento
    END
GO

CREATE PROCEDURE uspActualizarTipodocumento

@idTipoDocumento int,
@descripcion nvarchar(20),
@estado bit

AS

UPDATE TipoDocumento SET idTipoDocumento = @idTipoDocumento, descripcion = @descripcion, estado = @estado
WHERE idTipoDocumento = @idTipoDocumento

GO
