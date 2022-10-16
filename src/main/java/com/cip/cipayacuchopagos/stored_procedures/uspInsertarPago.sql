USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarPago')
    BEGIN
        DROP PROCEDURE uspInsertarPago
    END
GO

CREATE PROCEDURE uspInsertarPago

@idUsuario int,
@idComprobantePago int,
@fechaPago datetime,
@montoTotal decimal(9,4),
@numeracion nvarchar(10),
@codigoQR nvarchar(500),
@descripcion nvarchar(100),
@estado bit

AS

DECLARE @idPago int;
SELECT @idPago =  ISNULL(MAX(idPago),0)+1 FROM Pago;

INSERT INTO Pago (idPago, idUsuario, idComprobantePago, fechaPago, montoTotal, numeracion, codigoQR, descripcion, estado)
VALUES (@idPago, @idUsuario, @idComprobantePago, @fechaPago, @montoTotal, @numeracion, @codigoQR, @descripcion, @estado)

SELECT MAX(idPago)
FROM Pago

GO
