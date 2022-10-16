USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarCategoriacip')
    BEGIN
        DROP PROCEDURE uspActualizarCategoriacip
    END
GO

CREATE PROCEDURE uspActualizarCategoriacip

@idCategoriaCIP int,
@descripcion nvarchar(50),
@estado bit

AS

UPDATE CategoriaCIP SET idCategoriaCIP = @idCategoriaCIP, descripcion = @descripcion, estado = @estado
WHERE idCategoriaCIP = @idCategoriaCIP

GO
