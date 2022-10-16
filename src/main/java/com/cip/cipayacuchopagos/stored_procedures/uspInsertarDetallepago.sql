USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarDetallepago')
    BEGIN
        DROP PROCEDURE uspInsertarDetallepago
    END
GO

CREATE PROCEDURE uspInsertarDetallepago

@idConceptoPago int,
@cantidad int,
@precio decimal(9,4),
@idPago int,
@estado bit

AS

DECLARE @idDetallePago int;
SELECT @idDetallePago =  ISNULL(MAX(idDetallePago),0)+1 FROM DetallePago;

INSERT INTO DetallePago (idDetallePago, idConceptoPago, cantidad, precio, idPago, estado)
VALUES (@idDetallePago, @idConceptoPago, @cantidad, @precio, @idPago, @estado)

SELECT MAX(idDetallePago)
FROM DetallePago

GO
