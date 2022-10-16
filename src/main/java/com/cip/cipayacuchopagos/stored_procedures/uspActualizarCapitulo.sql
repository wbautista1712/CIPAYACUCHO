USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarCapitulo')
    BEGIN
        DROP PROCEDURE uspActualizarCapitulo
    END
GO

CREATE PROCEDURE uspActualizarCapitulo

@idCapitulo int,
@descripcion nvarchar(200),
@estado bit

AS

UPDATE Capitulo SET idCapitulo = @idCapitulo, descripcion = @descripcion, estado = @estado
WHERE idCapitulo = @idCapitulo

GO
