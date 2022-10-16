USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarPago')
    BEGIN
        DROP PROCEDURE uspActualizarPago
    END
GO

CREATE PROCEDURE uspActualizarPago

@idPago int,
@idUsuario int,
@idComprobantePago int,
@fechaPago datetime,
@montoTotal decimal(9,4),
@numeracion nvarchar(10),
@codigoQR nvarchar(500),
@descripcion nvarchar(100),
@estado bit

AS

UPDATE Pago SET idPago = @idPago, idUsuario = @idUsuario, idComprobantePago = @idComprobantePago, fechaPago = @fechaPago, montoTotal = @montoTotal, numeracion = @numeracion, codigoQR = @codigoQR, descripcion = @descripcion, estado = @estado
WHERE idPago = @idPago

GO
