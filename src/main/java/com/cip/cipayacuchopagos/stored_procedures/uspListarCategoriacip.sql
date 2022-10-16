USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarCategoriacip')
    BEGIN
        DROP PROCEDURE uspListarCategoriacip
    END
GO

CREATE PROCEDURE uspListarCategoriacip

@IndOpSp int,
@idCategoriaCIP int,
@descripcion nvarchar(50),
@estado bit

AS

IF (@IndOpSp=1)
    BEGIN
        SELECT idCategoriaCIP, descripcion, estado
        FROM CategoriaCIP
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idCategoriaCIP, descripcion, estado
        FROM CategoriaCIP
        WHERE idCategoriaCIP=@idCategoriaCIP AND estado=1
    END

GO
