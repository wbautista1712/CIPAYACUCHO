USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarProvincia')
    BEGIN
        DROP PROCEDURE uspListarProvincia
    END
GO

CREATE PROCEDURE uspListarProvincia

@IndOpSp int,
@idProvincia nvarchar(4),
@idDepartamento nvarchar(2),
@descripcion nvarchar(100),
@estado bit

AS

IF (@IndOpSp=1)
    BEGIN
        SELECT idProvincia, idDepartamento, descripcion, estado
        FROM Provincia
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idProvincia, idDepartamento, descripcion, estado
        FROM Provincia
        WHERE idProvincia=@idProvincia AND estado=1
    END

GO
