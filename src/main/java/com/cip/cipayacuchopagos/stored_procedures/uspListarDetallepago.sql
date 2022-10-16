USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarDetallepago')
    BEGIN
        DROP PROCEDURE uspListarDetallepago
    END
GO

CREATE PROCEDURE uspListarDetallepago

@IndOpSp int,
@idDetallePago int,
@idConceptoPago int,
@cantidad int,
@precio decimal(9,4),
@idPago int,
@estado bit

AS

IF (@IndOpSp=1)
    BEGIN
        SELECT idDetallePago, idConceptoPago, cantidad, precio, idPago, estado
        FROM DetallePago
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idDetallePago, idConceptoPago, cantidad, precio, idPago, estado
        FROM DetallePago
        WHERE idDetallePago=@idDetallePago AND estado=1
    END

GO
