USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarColegiatura')
    BEGIN
        DROP PROCEDURE uspActualizarColegiatura
    END
GO

CREATE PROCEDURE uspActualizarColegiatura

@idColegiatura int,
@numero nvarchar(15),
@idUsuario int,
@estado bit

AS

UPDATE Colegiatura SET idColegiatura = @idColegiatura, numero = @numero, idUsuario = @idUsuario, estado = @estado
WHERE idColegiatura = @idColegiatura

GO
