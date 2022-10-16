USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarCategoriacip')
    BEGIN
        DROP PROCEDURE uspInsertarCategoriacip
    END
GO

CREATE PROCEDURE uspInsertarCategoriacip

@descripcion nvarchar(50),
@estado bit

AS

DECLARE @idCategoriaCIP int;
SELECT @idCategoriaCIP =  ISNULL(MAX(idCategoriaCIP),0)+1 FROM CategoriaCIP;

INSERT INTO CategoriaCIP (idCategoriaCIP, descripcion, estado)
VALUES (@idCategoriaCIP, @descripcion, @estado)

SELECT MAX(idCategoriaCIP)
FROM CategoriaCIP

GO
