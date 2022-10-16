USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarComprobantepago')
    BEGIN
        DROP PROCEDURE uspActualizarComprobantepago
    END
GO

CREATE PROCEDURE uspActualizarComprobantepago

@idComprobantePago int,
@descripcion nvarchar(50),
@estado bit

AS

UPDATE ComprobantePago SET idComprobantePago = @idComprobantePago, descripcion = @descripcion, estado = @estado
WHERE idComprobantePago = @idComprobantePago

GO
