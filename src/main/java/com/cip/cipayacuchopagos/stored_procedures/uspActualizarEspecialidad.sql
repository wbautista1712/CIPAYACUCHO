USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarEspecialidad')
    BEGIN
        DROP PROCEDURE uspActualizarEspecialidad
    END
GO

CREATE PROCEDURE uspActualizarEspecialidad

@idEspecialidad int,
@descripcion nvarchar(200),
@idCapitulo int,
@estado bit

AS

UPDATE Especialidad SET idEspecialidad = @idEspecialidad, descripcion = @descripcion, idCapitulo = @idCapitulo, estado = @estado
WHERE idEspecialidad = @idEspecialidad

GO
