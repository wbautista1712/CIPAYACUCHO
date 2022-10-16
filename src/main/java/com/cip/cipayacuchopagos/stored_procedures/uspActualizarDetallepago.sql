USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarDetallepago')
    BEGIN
        DROP PROCEDURE uspActualizarDetallepago
    END
GO

CREATE PROCEDURE uspActualizarDetallepago

@idDetallePago int,
@idConceptoPago int,
@cantidad int,
@precio decimal(9,4),
@idPago int,
@estado bit

AS

UPDATE DetallePago SET idDetallePago = @idDetallePago, idConceptoPago = @idConceptoPago, cantidad = @cantidad, precio = @precio, idPago = @idPago, estado = @estado
WHERE idDetallePago = @idDetallePago

GO
