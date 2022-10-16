USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarPago')
    BEGIN
        DROP PROCEDURE uspListarPago
    END
GO

CREATE PROCEDURE uspListarPago

@IndOpSp int,
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

IF (@IndOpSp=1)
    BEGIN
        SELECT idPago, idUsuario, idComprobantePago, fechaPago, montoTotal, numeracion, codigoQR, descripcion, estado
        FROM Pago
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idPago, idUsuario, idComprobantePago, fechaPago, montoTotal, numeracion, codigoQR, descripcion, estado
        FROM Pago
        WHERE idPago=@idPago AND estado=1
    END

GO
