USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarColegiatura')
    BEGIN
        DROP PROCEDURE uspInsertarColegiatura
    END
GO

CREATE PROCEDURE uspInsertarColegiatura

@numero nvarchar(15),
@idUsuario int,
@estado bit

AS

DECLARE @idColegiatura int;
SELECT @idColegiatura =  ISNULL(MAX(idColegiatura),0)+1 FROM Colegiatura;

INSERT INTO Colegiatura (idColegiatura, numero, idUsuario, estado)
VALUES (@idColegiatura, @numero, @idUsuario, @estado)

SELECT MAX(idColegiatura)
FROM Colegiatura

GO
