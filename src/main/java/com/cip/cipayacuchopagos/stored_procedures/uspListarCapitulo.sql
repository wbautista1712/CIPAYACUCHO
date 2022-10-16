USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarCapitulo')
    BEGIN
        DROP PROCEDURE uspListarCapitulo
    END
GO

CREATE PROCEDURE uspListarCapitulo

@IndOpSp int,
@idCapitulo int,
@descripcion nvarchar(200),
@estado bit

AS

IF (@IndOpSp=1)
    BEGIN
        SELECT idCapitulo, descripcion, estado
        FROM Capitulo
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idCapitulo, descripcion, estado
        FROM Capitulo
        WHERE idCapitulo=@idCapitulo AND estado=1
    END

GO
