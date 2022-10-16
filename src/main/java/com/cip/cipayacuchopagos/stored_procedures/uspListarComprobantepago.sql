USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarComprobantepago')
    BEGIN
        DROP PROCEDURE uspListarComprobantepago
    END
GO

CREATE PROCEDURE uspListarComprobantepago

@IndOpSp int,
@idComprobantePago int,
@descripcion nvarchar(50),
@estado bit

AS

IF (@IndOpSp=1)
    BEGIN
        SELECT idComprobantePago, descripcion, estado
        FROM ComprobantePago
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idComprobantePago, descripcion, estado
        FROM ComprobantePago
        WHERE idComprobantePago=@idComprobantePago AND estado=1
    END

GO
