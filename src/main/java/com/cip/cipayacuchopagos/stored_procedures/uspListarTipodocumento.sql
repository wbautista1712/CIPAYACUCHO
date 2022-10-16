USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarTipodocumento')
    BEGIN
        DROP PROCEDURE uspListarTipodocumento
    END
GO

CREATE PROCEDURE uspListarTipodocumento

@IndOpSp int,
@idTipoDocumento int,
@descripcion nvarchar(20),
@estado bit

AS

IF (@IndOpSp=1)
    BEGIN
        SELECT idTipoDocumento, descripcion, estado
        FROM TipoDocumento
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idTipoDocumento, descripcion, estado
        FROM TipoDocumento
        WHERE idTipoDocumento=@idTipoDocumento AND estado=1
    END

GO
