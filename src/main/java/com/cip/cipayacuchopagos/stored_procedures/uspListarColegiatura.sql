USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarColegiatura')
    BEGIN
        DROP PROCEDURE uspListarColegiatura
    END
GO

CREATE PROCEDURE uspListarColegiatura

@IndOpSp int,
@idColegiatura int,
@numero nvarchar(15),
@idUsuario int,
@estado bit

AS

IF (@IndOpSp=1)
    BEGIN
        SELECT idColegiatura, numero, idUsuario, estado
        FROM Colegiatura
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idColegiatura, numero, idUsuario, estado
        FROM Colegiatura
        WHERE idColegiatura=@idColegiatura AND estado=1
    END

GO
