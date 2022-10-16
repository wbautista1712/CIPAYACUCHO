USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarDistrito')
    BEGIN
        DROP PROCEDURE uspListarDistrito
    END
GO

CREATE PROCEDURE uspListarDistrito

@IndOpSp int,
@idDistrito nvarchar(6),
@idProvincia nvarchar(4),
@descripcion nvarchar(100),
@estado bit

AS

IF (@IndOpSp=1)
    BEGIN
        SELECT idDistrito, idProvincia, descripcion, estado
        FROM Distrito
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idDistrito, idProvincia, descripcion, estado
        FROM Distrito
        WHERE idDistrito=@idDistrito AND estado=1
    END

GO
